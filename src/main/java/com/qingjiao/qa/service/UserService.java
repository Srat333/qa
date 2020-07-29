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

    public boolean addUser(String nickname, String url) {

        User user = new User();
        user.setNickname(nickname);
        user.setUrl(url);
        user.setBio("to be updated");
        user.setRating(5);

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

    public boolean updateBio(long uid, String bio) {
        if(searchUserById(uid)==null){
            log.error("user not exiest");
            return false;
        }
        int idx = userDao.updateBio(uid, bio);
        if(idx<0) {
            log.error("update user bio failure :(");
            return false;
        } else {
            log.info("update user bio successfully :)");
            return true;
        }
    }

    public boolean updateRating(long uid, double rating){
        if(searchUserById(uid)==null){
            log.error("user not exiest");
            return false;
        }
        int idx = userDao.updateRating(uid, rating);
        if(idx<0) {
            log.error("update user rating failure :(");
            return false;
        } else {
            log.info("update user rating successfully :)");
            return true;
        }
    }

    public boolean updateUser(long uid, String nickname, String url, String bio, double rating) {

        User user = new User();
        user.setUid(uid);
        user.setNickname(nickname);
        user.setUrl(url);
        user.setBio(bio);
        user.setRating(rating);
        int index = userDao.updateUser(user);
        if(index<0) {
            log.error("update user failure :(");
            return false;
        } else {
            log.info("update user successfully :)");
            return true;
        }
    }

    public boolean deleteUser(long uid) {
        if(uid<0) {
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

    public User searchUserById(long uid) {
        if(uid<0) {
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
