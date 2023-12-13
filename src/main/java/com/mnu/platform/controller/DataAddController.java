package com.mnu.platform.controller;

import com.mnu.platform.entity.Category;
import com.mnu.platform.entity.Game;
import com.mnu.platform.repository.CategoryRepository;
import com.mnu.platform.repository.GameRepository;
import com.mnu.platform.repository.SubscribeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataAddController {

    @Autowired
    SubscribeRepository subscribeRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    GameRepository gameRepository;

    @GetMapping("/addCategory")
    public String addCategory(){
        String[] categoryNames = {"Action", "Adventure", "Puzzle", "Strategy", "Sports"};
        try {
            for (String name : categoryNames) {
                Category category = new Category();
                category.setName(name);
                categoryRepository.save(category);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return "game_select";
    }

    @GetMapping ("/gameadd")
    public String addGame(){
        String[] gameNames = {"MineCraft", "FIFA", "MapleStory", "FallOut", "League Of Legend", "Battlefield", "GTA5","StarCraft"};
        try {
            for (String name : gameNames) {
                Game game = new Game();
                game.setTitle(name);
                gameRepository.save(game);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return "game_select";
    }
}
