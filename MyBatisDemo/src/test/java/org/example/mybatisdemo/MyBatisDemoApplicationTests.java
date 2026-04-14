package org.example.mybatisdemo;

import org.example.mybatisdemo.mapper.UserInfoMapper;
import org.example.mybatisdemo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyBatisDemoApplicationTests {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Test
    void contextLoads() {
        List<UserInfo> userInfoList = userInfoMapper.getUserInfoList();
        System.out.println(userInfoList);
    }

}
