package org.example.mybatisdemo.mapper;

import org.example.mybatisdemo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void getUserInfoList() {
        List<UserInfo> userInfoList = userInfoMapper.getUserInfoList();
        System.out.println(userInfoList);
    }

    @Test
    void getUserInfo1() {
        UserInfo userInfo1 = userInfoMapper.getUserInfo1(1);
        System.out.println(userInfo1);
    }

    @Test
    void getUserInfo2() {
        List<UserInfo> userInfo2 = userInfoMapper.getUserInfo2(0);
        System.out.println(userInfo2);
    }

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhaoliu");
        userInfo.setPassword("123455");
        userInfo.setAge(18);
        userInfo.setGender(2);
        Integer infectLine = userInfoMapper.insert(userInfo);
        System.out.println(infectLine+" "+userInfo.getId());
    }

    @Test
    void delete() {
        Integer infectLine = userInfoMapper.delete(8);
        System.out.println(infectLine);
    }

}