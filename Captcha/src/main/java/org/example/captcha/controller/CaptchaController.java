package org.example.captcha.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/captcha")
public class CaptchaController {
    @RequestMapping("/get")
    public void getCaptcha(HttpServletResponse response , HttpSession session) throws IOException {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        lineCaptcha.write(response.getOutputStream());
        session.setAttribute("captcha_session_key",lineCaptcha.getCode());
        session.setAttribute("captcha_session_time",System.currentTimeMillis());
    }

    @RequestMapping("/check")
    public boolean checkCaptcha(String inputCode,HttpSession session) {

        if(!StringUtils.hasLength(inputCode)){
            return false;
        }

        String currentCode = (String) session.getAttribute("captcha_session_key");

        if(currentCode.equalsIgnoreCase(inputCode)) {
            long captchaSessionTime = (long) session.getAttribute("captcha_session_time");
            if(System.currentTimeMillis()-captchaSessionTime<60*1000){
                return true;
            }
        }

        return false;

    }
}
