package org.example.managebook.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.managebook.model.UserInfo;
import org.example.managebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(String userName,String password,HttpSession session) {
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return "用户名或密码为空，请输入完整～";
        }

        UserInfo userInfo = userService.queryUserByName(userName);
        if(userInfo==null) {
            return "用户不存在";
        }
        if(!password.equals(userInfo.getPassword())) {
            return "密码错误";
        }

        session.setAttribute("user_session_key", userInfo);
        return "";
    }
}
