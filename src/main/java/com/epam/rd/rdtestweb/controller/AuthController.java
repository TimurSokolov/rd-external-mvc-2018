package com.epam.rd.rdtestweb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.rd.rdtestweb.dto.User;
import com.epam.rd.rdtestweb.service.UserManager;

@Controller
public class AuthController {

    @Autowired
    private UserManager userManager;

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login-page");

        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login-page");

        request.getSession().invalidate();

        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(User user) {
        ModelAndView modelAndView = new ModelAndView();

        if (!user.getPassword().equals("123")) {
            modelAndView.addObject("errorMsg", "Пароль неверен");
            modelAndView.setViewName("login-page");
        } else {
            User currentUser = new User();
            currentUser.setLogin(user.getLogin());

            if (user.getLogin().equals("Admin")) {
                currentUser.setRole("ADMIN");
            } else {
                currentUser.setRole("USER");
            }

            userManager.setUser(currentUser);

            modelAndView.setViewName("redirect:/home");
        }

        return modelAndView;

    }
}
