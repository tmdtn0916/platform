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
    @GetMapping(path="/game")
    public String game(){
        return "game_select";
    }

    @GetMapping(path="/info")
    public String info(){
        return "user_info";
    }

    @GetMapping(path="/elements")
    public String elements(){
        return "elements";
    }

    @GetMapping(path="/rg1")
    public String rg1(){
        return "rg_1";
    }

    @GetMapping(path="/rg2")
    public String rg2(){
        return "rg_2";
    }
}
