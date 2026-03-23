package org.example.springmvc1;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
@RequestMapping("/user")
public class LoginController {
    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session) {
        if(!StringUtils.hasLength(userName)||!StringUtils.hasLength(password)){
            return false;
        }
        if("curiez".equals(userName)&&"curiez".equals(password)){
            session.setAttribute("userName",userName);
            return true;
        }
        return false;
    }

    @RequestMapping("/index")
    public String index(@SessionAttribute("userName") String userName){
        return userName;
    }
}
