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

    @GetMapping(path="/rg3")
    public String rg3(){
        return "rg_3";
    }

    @GetMapping(path="/rg4")
    public String rg4() {
        return "rg_4";
    }

    @GetMapping(path="/pg1")
    public String pg1(){
        return "pg_1";
    }

    @GetMapping(path="/pg2")
    public String pg2(){
        return "pg_2";
    }

    @GetMapping(path="/pg3")
    public String pg3(){
        return "pg_3";
    }

    @GetMapping(path="/pg4")
    public String pg4(){
        return "pg_4";
    }
}
