package org.example.springmvc1;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/Session")
public class SessionController {
    @RequestMapping("getCookie")
    public String getCookie(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            Arrays.stream(cookies).forEach(ck -> {
                System.out.println(ck.getName()+":"+ck.getValue());
            });
        }
        return "获取Cookie";
    }

    @RequestMapping("getCookie2")
    public String getCookie2(@CookieValue("word") String word){
        return "获取Cookie中的word："+word;
    }

    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("name","curiez");
        return "成功设置session";
    }

    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        return "session 中的 name："+name;
    }
}
