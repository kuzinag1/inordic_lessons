package ru.news.demoapp.controller;


import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
        //Authentication authentication = SecurityContextHolder
    }

    @GetMapping("/logout")
    public String logoutPage() {
        return "logout";
    }
}
