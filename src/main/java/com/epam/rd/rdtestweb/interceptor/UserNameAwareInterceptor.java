package com.epam.rd.rdtestweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.epam.rd.rdtestweb.dto.User;
import com.epam.rd.rdtestweb.service.UserManager;

public class UserNameAwareInterceptor implements HandlerInterceptor {

    @Autowired
    private UserManager userManager;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        User currentUser = userManager.getUser();

//        modelAndView.addObject("userName", currentUser.getLogin());
//        modelAndView.addObject("currentUserRole", currentUser.getRole());
    }

}
