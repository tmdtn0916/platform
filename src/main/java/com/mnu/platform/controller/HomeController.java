package com.mnu.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(path = "/home")
    public String home(Model model) {
        return "home";
    }

    @GetMapping(path = "/net")
    public String netfilx(Model model) {
        return "netfilx";
    }

    @GetMapping(path="/banner")
    public String banner(Model model) {
        return "banner";
    }

    @GetMapping(path="/login")
    public String login() {
        return "login";
    }

    @GetMapping(path = "/signup")
    public String singup(){
        return "signup";
    }
}
