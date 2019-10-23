package com.runisys.bigdata.phoenix.mybatis.test;

import com.runisys.bigdata.phoenix.mybatis.test.dao.UserInfoMapper;
import com.runisys.bigdata.phoenix.mybatis.test.mybatis.PhoenixDataSourceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@Import(PhoenixDataSourceConfig.class)
@PropertySource("classpath:application.properties")
@Component("com.runisys.bigdata.**")
@MapperScan("com.runisys.bigdata.**")
public class BaseTest {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    public void addUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(2);
        userInfo.setName("Jerry");
        userInfoMapper.addUser(userInfo);
    }

    @Test
    public void getUserById() {
        UserInfo userInfo = userInfoMapper.getUserInfoById(1);
        System.out.println(String.format("ID=%s;Name=%s", userInfo.getId(), userInfo.getName()));
    }

    @Test
    public void getUserByName() {
        UserInfo userInfo = userInfoMapper.getUserInfoByName("Jerry");
        System.out.println(String.format("ID=%s;Name=%s", userInfo.getId(), userInfo.getName()));
    }

    @Test
    public void deleteUser(){
        userInfoMapper.deleteUser(1);
        List<UserInfo> userInfos = userInfoMapper.getUsers();
        for(UserInfo userInfo:userInfos){
            System.out.println(String.format("ID=%s;Name=%s", userInfo.getId(), userInfo.getName()));
        }
    }

}
