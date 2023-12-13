package com.mnu.platform.controller;

import com.mnu.platform.entity.Game;
import com.mnu.platform.entity.Review;
import com.mnu.platform.entity.UserData;
import com.mnu.platform.repository.GameRepository;
import com.mnu.platform.repository.ReviewRepository;
import com.mnu.platform.repository.UserRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ReplyController {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    GameRepository gameRepository;

    @PostMapping("/reply")
    public String reply(Review review) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
//        System.out.println(username);
        UserData user = userRepository.findByEmail(username);

        try {
            review.setUser(user);
            int id = 302;
            Long xLong = Long.valueOf(id);
            Optional<Game> game = gameRepository.findById(xLong);
//            System.out.println(game);
//            System.out.println(game.get().getTitle());
            review.setGame(game.get());
            reviewRepository.save(review);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "rg_1";
    }

    @GetMapping("/test")
    public void test(){
        Game game = new Game();
        game.setTitle("MapleStroy");

        gameRepository.save(game);
    }
}
