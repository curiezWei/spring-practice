package org.example.managebook.service;

import org.example.managebook.mapper.UserInfoMapper;
import org.example.managebook.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo queryUserByName(String userName) {
        return userInfoMapper.queryUserByName(userName);
    }
}
