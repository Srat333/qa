package com.qingjiao.qa.dao;

import com.qingjiao.qa.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    @Insert("INSERT INTO users(uid,nickname,url) " +
            "VALUES(#{uid},#{nickname},#{url})")
    int addUser(User user);

    @Update("UPDATE users SET bio=#{bio} where uid=#{uid}")
    int updateBio(long uid, String bio);

    @Update("UPDATE users SET rating=#{rating} where uid=#{uid}")
    int updateRating(long uid, double rating);

    @Update("UPDATE users SET nickname=#{nickname}, url=#{url}, " +
            "bio=#{bio},rating=#{rating} where uid=#{uid}")
    int updateUser(User user);

    @Delete("DELETE FROM users WHERE uid=#{uid}")
    int deleteUser(@Param("uid") long uid);

    @Select("SELECT * FROM users WHERE uid=#{uid}")
    User searchUserById(@Param("uid") long uid);

    @Select("SELECT * FROM users WHERE nickname=#{nickname}")
    List<User> searchUserByNickname(@Param("nickname") String nickname);

    @Select("SELECT * FROM users")
    List<User> userList();
}
