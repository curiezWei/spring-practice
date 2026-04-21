package org.example.mybatisdemo.mapper;

import org.example.mybatisdemo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoXMLMapperTest {

    @Autowired
    private UserInfoXMLMapper userInfoXMLMapper;

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhaoliu");
        userInfo.setPassword("123455");
        userInfo.setAge(18);
        userInfo.setGender(2);
        Integer infectLine = userInfoXMLMapper.insert(userInfo);
        System.out.println(infectLine+" "+userInfo.getId());
    }
}