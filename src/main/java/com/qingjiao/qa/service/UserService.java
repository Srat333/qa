package com.qingjiao.qa.service;

import com.qingjiao.qa.dao.UserDao;
import com.qingjiao.qa.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Slf4j
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public boolean addUser(String uid, String nickname, int gender,  String url, String city, String country) {
        User user = new User();
        if(uid.equals("")){
            log.error("uid is empty");
            return false;
        }
        user.setUid(uid);
        user.setNickname(nickname);
        user.setGender(gender);
        user.setUrl(url);
        user.setCity(city);
        user.setCountry(country);

        Date curDate = new Date();

        int result=-1;
        try {
            if(userDao!=null)
                result = userDao.addUser(user);
        } catch (Exception e){
            log.error("add exception happened :(");
            e.printStackTrace();
        }
        if(result!=-1) {
            log.info("add user successfully :) "+curDate+" good luck <3");
            return true;
        } else {
            log.error("add user failure :(");
            return false;
        }
    }

    public boolean updateUser(String uid, String nickname, int gender,String url,String city, String country) {
        if(uid.equals("")) {
            log.error("uid is empty :(");
            return false;
        }
        User user = new User();
        user.setUid(uid);
        user.setNickname(nickname);
        user.setGender(gender);
        user.setUrl(url);
        user.setCity(city);
        user.setCountry(country);
        int index = userDao.updateUser(user);
        if(index<0) {
            log.error("update user failure :(");
            return false;
        } else {
            log.info("update user successfully :)");
            return true;
        }
    }

    public boolean deleteUser(String uid) {
        if(uid.equals("")) {
            log.error("uid is empty");
            return false;
        }
        int result = userDao.deleteUser(uid);
        if(result<0) {
            log.error("delete user failure :(");
            return false;
        } else {
            log.info("delete user successfully :)");
            return true;
        }
    }

    public User searchUserById(String uid) {
        if(uid.equals("")) {
            log.error("uid is empty");
            return null;
        }
        User user = userDao.searchUserById(uid);
        if(user==null) {
            log.error("user not exist");
            return null;
        }
        return user;
    }

    public List<User> searchUserByNickname(String nickname) {
        if(nickname.equals("")) {
            log.error("nickname is empty");
            return null;
        }
        List<User> users = userDao.searchUserByNickname(nickname);
        if(users.size()==0) {
            log.error("user not exist");
            return null;
        }
        return users;
    }

    public List<User> userList() {
        return userDao.userList();
    }

}
