package com.qingjiao.qa.controller;

import com.qingjiao.qa.entity.User;
import com.qingjiao.qa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value={"/add"},method = RequestMethod.POST)
    public void addUser(@RequestParam("uid") String uid,
                            @RequestParam("nickname") String nickname,
                            @RequestParam("gender") int gender,
                            @RequestParam("url") String url,
                            @RequestParam("city") String city,
                            @RequestParam("country") String country) {

        boolean result = userService.addUser(uid, nickname, gender, url, city, country);
        if(result)
            log.info("add user successfully!!!!! <3");
        else {
            log.error("add user failed :(");
        }
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PATCH)
    public void updateUser(@RequestParam("uid") String uid,
                           @RequestParam("nickname") String nickname,
                           @RequestParam("gender") int gender,
                           @RequestParam("url") String url,
                           @RequestParam("city") String city,
                           @RequestParam("country") String country) {
        boolean result = userService.updateUser(uid, nickname, gender, url, city, country);
        if(result)
            log.info("add user successfully!!!!! <3");
        else {
            log.error("add user failed :(");
        }
    }

    @RequestMapping(value={"/search"},method = RequestMethod.GET)
    public List<User> searchUserByNickname(@RequestParam("keyword") String nickname){
        if(nickname.equals("")){
            log.error("nickname is empty");
            return null;
        }
        List<User> result = userService.searchUserByNickname(nickname);
        if(result!=null){
            log.info("search user successfully!!!!");
            return result;
        } else {
            log.error("search user failed :(");
            return null;
        }
    }

    @RequestMapping(value={"/searchId"},method = RequestMethod.GET)
    public User searchUserById(@RequestParam("uid") String uid){
        if(uid.equals("")){
            log.error("uid is empty");
            return null;
        }
        User result = userService.searchUserById(uid);
        if(result!=null){
            log.info("search user successfully!!!!");
            return result;
        } else {
            log.error("search user failed :(");
            return null;
        }
    }

    @RequestMapping(value={"/delete"},method = RequestMethod.DELETE)
    public void deleteQuestion(@RequestParam("uid") String uid) {
        if(userService.searchUserById(uid)==null) {
            log.error("user not found :8");
            return;
        }
        boolean result = userService.deleteUser(uid);
        if(result) {
            log.info("delete succ :)");
        } else {
            log.error("delete failed :(");
        }
    }

    @RequestMapping(value={"/all"},method = RequestMethod.GET)
    public List<User> listAllUsers() {
        List<User> result = userService.userList();
        if(result!=null) {
            log.info("list all user successfully!!!!");
            return result;
        } else {
            log.error("list user failed :(");
            return null;
        }
    }
}
