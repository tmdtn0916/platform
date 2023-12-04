package com.mnu.platform.controller;

import com.mnu.platform.entity.UserData;
import com.mnu.platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @GetMapping(path = "/signup")
    public String signup(Model model){
        model.addAttribute("user",new UserData());
        return "signup";
    }

    @PostMapping("/signup")
    public String processRegistrationForm(@ModelAttribute UserData user, Model model) {
        String encodedPassword = encoder.encode(user.getPasswd());
        user.setPasswd(encodedPassword);
        repository.save(user);
        return "home";
    }

    @GetMapping(path="/login")
    public String login() {
        return "login";
    }
}
