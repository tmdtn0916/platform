package com.mnu.platform.controller;

import com.mnu.platform.entity.Review;
import com.mnu.platform.entity.UserData;
import com.mnu.platform.repository.ReviewRepository;
import com.mnu.platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/home")
    public String home(Model model) {
        return "home";
    }
    @GetMapping(path="/game")
    public String game(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserData user = userRepository.findByEmail(username);

        model.addAttribute("name",user.getName());
        model.addAttribute("auth",user.getAuth());
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
    public String rg1(Model model){
        model.addAttribute("new_review",new Review());
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
