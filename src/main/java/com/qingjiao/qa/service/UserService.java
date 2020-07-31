package com.qingjiao.qa.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qingjiao.qa.dao.UserDao;
import com.qingjiao.qa.entity.User;
import com.qingjiao.qa.util.GlobalResult;
import com.qingjiao.qa.util.WechatUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public GlobalResult login(String code,
                 String rawData,
                 String signature,
                 String encrypteData,
                 String iv){
        // 用户非敏感信息：rawData
        // 签名：signature
        JSONObject rawDataJson = JSON.parseObject(rawData);
        // 1.接收小程序发送的code
        // 2.开发者服务器 登录凭证校验接口 appi + appsecret + code
        JSONObject SessionKeyOpenId = WechatUtil.getSessionKeyOrOpenId(code);
        // 3.接收微信接口服务 获取返回的参数
        String openid = SessionKeyOpenId.getString("openid");
        String sessionKey = SessionKeyOpenId.getString("session_key");

        // 4.校验签名 小程序发送的签名signature与服务器端生成的签名signature2 = sha1(rawData + sessionKey)
        String signature2 = DigestUtils.sha1Hex(rawData + sessionKey);
        if (!signature.equals(signature2)) {
            return GlobalResult.build(500, "签名校验失败", null);
        }
        // 4.根据返回的User实体类，判断用户是否是新用户，是的话，将用户信息存到数据库；不是的话，更新最新登录时间
        User user = this.userDao.selectById(openid);
        // uuid生成唯一key，用于维护微信小程序用户与服务端的会话
        String skey = UUID.randomUUID().toString();
        if (user == null) {
            // 用户信息入库
            String nickName = rawDataJson.getString("nickName");
            String avatarUrl = rawDataJson.getString("avatarUrl");
            String gender = rawDataJson.getString("gender");
            String city = rawDataJson.getString("city");
            String country = rawDataJson.getString("country");
            String province = rawDataJson.getString("province");

            user = new User();
            user.setOpenId(openid);
            user.setSkey(skey);
            user.setCreateTime(new Date());
            user.setLastVisitTime(new Date());
            user.setSessionKey(sessionKey);
            user.setCity(city);
            user.setProvince(province);
            user.setCountry(country);
            user.setAvatarUrl(avatarUrl);
            user.setGender(Integer.parseInt(gender));
            user.setNickName(nickName);

            this.userDao.insert(user);
        } else {
            // 已存在，更新用户登录时间
            user.setLastVisitTime(new Date());
            // 重新设置会话skey
            user.setSkey(skey);
            this.userDao.updateById(user);
        }
        GlobalResult result = GlobalResult.build(200, null, skey);
        return result;
    }
}
