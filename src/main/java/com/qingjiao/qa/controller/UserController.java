package com.qingjiao.qa.controller;

import com.qingjiao.qa.entity.User;
import com.qingjiao.qa.dao.UserDao;
import com.qingjiao.qa.service.UserService;
import com.qingjiao.qa.util.GlobalResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    /**
     * 微信用户登录详情
     */
    @PostMapping("wx/login")
    @ResponseBody
    public GlobalResult user_login(@RequestParam(value = "code", required = false) String code,
                                   @RequestParam(value = "rawData", required = false) String rawData,
                                   @RequestParam(value = "signature", required = false) String signature,
                                   @RequestParam(value = "encrypteData", required = false) String encrypteData,
                                   @RequestParam(value = "iv", required = false) String iv) {
        if(code==null){
            log.error("invalid code");
            return null;
        }
        GlobalResult result = userService.login(code, rawData, signature, encrypteData, iv);

        return result;
    }

    @GetMapping("user/all")
    @ResponseBody
    public List<User> listAll(){
        return userDao.userList();
    }
}
