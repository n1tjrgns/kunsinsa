package com.fakesinsa.fakesinsaboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/admin/login")
    public String adminLogin(){
        return "admin/authentication-login";
    }

    @RequestMapping("/admin")
    public String adminMain(){
        return "admin/index";
    }
}
