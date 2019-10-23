package com.runisys.bigdata.phoenix.mybatis.test.dao;

import com.runisys.bigdata.phoenix.mybatis.test.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Insert("upsert into user_info (id,name) VALUES(#{user.id},#{user.name})")
    public void addUser(@Param("user") UserInfo userInfo);

    @Delete("delete from USER_INFO WHERE ID=#{userId}")
    public void deleteUser(@Param("userId") int userId);

    @Select("select * from USER_INFO WHERE ID=#{userId}")
    @ResultMap("userResultMap")
    public UserInfo getUserInfoById(@Param("userId") int userId);

    @Select("select * from USER_INFO WHERE NAME=#{userName}")
    @ResultMap("userResultMap")
    public UserInfo getUserInfoByName(@Param("userName") String userName);


    @Select("select * from USER_INFO")
    @ResultMap("userResultMap")
    public List<UserInfo> getUsers();

}
