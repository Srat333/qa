package com.qingjiao.qa.controller;
import lombok.extern.slf4j.Slf4j;
import com.qingjiao.qa.entity.WXSessionModel;
import com.qingjiao.qa.util.HttpClientUtil;
import com.qingjiao.qa.util.JsonUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/qa")
public class WXLoginController {

    @PostMapping("/wxLogin")
    public HashMap<String,String> wxLogin(String code){
        HashMap<String,String> result=new HashMap<String, String>();
        HashMap<String,String> paraMap=new HashMap<String, String>();

        log.info("code-from-wx-mini-program: "+code);
        /**
         * 登录凭证校验。通过 wx.login 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程。
         * GET https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
         * appid，secret 微信小程序 账户设置中存在 不能传递到前端
         *
         */
        String url="https://api.weixin.qq.com/sns/jscode2session";
        paraMap.put("appid","wx1ab96d88672df2cd");
        paraMap.put("secret","");
        paraMap.put("js_code", code);
        paraMap.put("grant_type","authorization_code");


        String wxResult= HttpClientUtil.doGet(url,paraMap);
        log.info("wxResult:"+wxResult);

        WXSessionModel model = JsonUtils.jsonToPojo(wxResult,WXSessionModel.class);
        //TODO: 存入session到redis或者MySql
        log.info("user-session: "+model.getOpenid()+" "+model.getSession_key()+" "+60000);
        return result;
    }

}

