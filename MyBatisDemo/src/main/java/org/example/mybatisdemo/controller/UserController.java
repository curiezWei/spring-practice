package org.example.mybatisdemo.controller;

import org.example.mybatisdemo.model.UserInfo;
import org.example.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("get")
    public List<UserInfo> getUserAll() {
        return userService.getUserAll();
    }

}
