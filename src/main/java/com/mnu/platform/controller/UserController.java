package com.mnu.platform.controller;

import com.mnu.platform.entity.Subscribe;
import com.mnu.platform.entity.UserData;
import com.mnu.platform.repository.SubscribeRepository;
import com.mnu.platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class UserController {

    @Autowired
    private SubscribeRepository subscribeRepository;

    @Autowired
    private UserRepository repository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @GetMapping(path = "/signup")
    public String signup(Model model) {
        model.addAttribute("user", new UserData());
        return "signup";
    }

    @PostMapping("/signup")
    public String processRegistrationForm(@ModelAttribute UserData user,
                                          @RequestParam(name = "birth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birth,
                                          @RequestParam(name = "category") String category) {
        String encodedPassword = encoder.encode(user.getPasswd());
        user.setPasswd(encodedPassword);
        user.setAuth(category);
        user.setBirth(birth);
        repository.save(user);

        Subscribe subscribe = new Subscribe();
        subscribe.setUser(user);

        LocalDate currentDate = LocalDate.now();
        subscribe.setStartTime(currentDate);
        subscribe.setEndDate(currentDate.plusDays(30));
        subscribe.setType(category);
        subscribeRepository.save(subscribe);

        return "home";
    }

    @GetMapping(path = "/login")
    public String login() {
        return "login";
    }
}
