package org.example.managebook.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.managebook.model.UserInfo;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public String login(UserInfo userInfo, HttpSession session){
        if(!StringUtils.hasLength(userInfo.getUserName())||!StringUtils.hasLength(userInfo.getPassword())){
            return "用户名或密码为空，请输入完整～";
        }
        if(!"curiez".equals(userInfo.getUserName())||!"123456".equals(userInfo.getPassword())){
            return "密码或用户名错误！";
        }
        session.setAttribute("userName",userInfo.getUserName());
        return "";
    }
}
