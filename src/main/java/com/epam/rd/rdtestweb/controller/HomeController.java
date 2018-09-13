package com.epam.rd.rdtestweb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.rd.rdtestweb.dto.Book;
import com.epam.rd.rdtestweb.dto.User;
import com.epam.rd.rdtestweb.service.UserManager;

@Controller
public class HomeController {

    @Autowired
    private UserManager userManager;

    @RequestMapping("/admin")
    public ModelAndView adminPage(HttpServletRequest request,
            @PathVariable(name = "pageId", required = false) String pageId) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("admin-page");

        User currentUser = userManager.getUser();

        if (!currentUser.getRole().equals("ADMIN")) {
            modelAndView.setViewName("redirect:/home");
            return modelAndView;
        }

        modelAndView.addObject("helloPhrase", "Привет админ, ");

        return modelAndView;
    }

    @RequestMapping("/home")
    public ModelAndView hello(HttpServletRequest request,
            @PathVariable(name = "pageId", required = false) String pageId) {
        ModelAndView modelAndView = new ModelAndView();

        int i = 12/0;
        
        
        List<Book> books = new ArrayList<>();

        books.add(new Book(11L, "Hobbit", "Tolkin"));
        books.add(new Book(21L, "ABC", "Putin"));
        books.add(new Book(31L, "ABC2", "Putin2"));

        modelAndView.setViewName("home-page");

        User currentUser = userManager.getUser();

        modelAndView.addObject("helloPhrase", "Привет, ");
        modelAndView.addObject("books", books);

        return modelAndView;
    }

    @RequestMapping("/book/{bookId}")
    public ModelAndView book(HttpServletRequest request,
            @PathVariable(name = "bookId", required = false) String bookId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("book-page");
        modelAndView.addObject("helloPhrase", "Здесь открылась книга по номеру " + bookId);

        return modelAndView;
    }

}
