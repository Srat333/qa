package com.qingjiao.qa.dao;

import com.qingjiao.qa.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    @Insert("INSERT INTO users(uid,nickname,gender,url,city,country) " +
            "VALUES(#{uid},#{nickname},#{gender},#{url},#{city},#{country})")
    int addUser(User user);

    @Update("UPDATE users SET nickname=#{nickname}, gender=#{gender}, " +
            "url=#{url}, city=#{city}, country=#{country} where uid=#{uid}")
    int updateUser(User user);

    @Delete("DELETE FROM users WHERE uid=#{uid}")
    int deleteUser(@Param("uid") String uid);

    @Select("SELECT * FROM users WHERE uid=#{uid}")
    User searchUserById(@Param("uid") String uid);

    @Select("SELECT * FROM users WHERE nickname=#{nickname}")
    List<User> searchUserByNickname(@Param("nickname") String nickname);

    @Select("SELECT * FROM users")
    List<User> userList();
}
