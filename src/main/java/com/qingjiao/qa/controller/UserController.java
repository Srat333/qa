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
    public void addUser(
                            @RequestParam("nickname") String nickname,
                            @RequestParam("url") String url) {

        boolean result = userService.addUser(nickname, url);
        if(result)
            log.info("add user successfully!!!!! <3");
        else {
            log.error("add user failed :(");
        }
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PATCH)
    public void updateUser(@RequestParam("uid") long uid,
                           @RequestParam("nickname") String nickname,
                           @RequestParam("url") String url,
                           @RequestParam("bio") String bio,
                           @RequestParam("rating") double rating) {
        boolean result = userService.updateUser(uid, nickname, url, bio, rating);
        if(result)
            log.info("update user successfully!!!!! <3");
        else {
            log.error("update user failed :(");
        }
    }

    @RequestMapping(value = {"/updatebio"}, method = RequestMethod.PATCH)
    public void updateBio(@RequestParam("uid") long uid,
                           @RequestParam("bio") String bio) {
        boolean result = userService.updateBio(uid, bio);
        if(result)
            log.info("update user bio successfully!!!!! <3");
        else {
            log.error("update user bio failed :(");
        }
    }

    @RequestMapping(value = {"/updaterating"}, method = RequestMethod.PATCH)
    public void updateRating(@RequestParam("uid") long uid,
                           @RequestParam("rating") double rating) {
        boolean result = userService.updateRating(uid, rating);
        if(result)
            log.info("update user rating successfully!!!!! <3");
        else {
            log.error("update user rating failed :(");
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
    public User searchUserById(@RequestParam("uid") long uid){
        if(uid<0){
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
    public void deleteQuestion(@RequestParam("uid") long uid) {
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
