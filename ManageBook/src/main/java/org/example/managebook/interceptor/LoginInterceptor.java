package org.example.managebook.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.managebook.constant.Constants;
import org.example.managebook.model.UserInfo;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Login preHandle");
        HttpSession session = request.getSession();
        UserInfo userInfo=(UserInfo)session.getAttribute(Constants.USER_SESSION_KEY);
        if(userInfo == null || userInfo.getId()<=0) {
            response.setStatus(401);
            return false;
        }
        return true;
    }
}
