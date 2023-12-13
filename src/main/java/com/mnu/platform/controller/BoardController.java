package com.mnu.platform.controller;

import com.mnu.platform.entity.Category;
import com.mnu.platform.entity.Game;
import com.mnu.platform.repository.CategoryRepository;
import com.mnu.platform.repository.GameRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class BoardController {

    private CategoryRepository categoryRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    public BoardController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

//    @Value("${upload.path}")
//    private String uploadPath; // 파일 업로드 경로

    @GetMapping("/board")
    public String showBoardForm(Model model) {
        List<Category> categories = categoryRepository.findAll();

        System.out.println(categories);
        model.addAttribute("categories", categories);
        model.addAttribute("game",new Game());
        return "board";
    }


    @PostMapping("/board")
    public String processForm(@ModelAttribute Game game, RedirectAttributes attributes,
                              @RequestParam(name="categories") List<Long> categoryIds) {
        Set<Category> categories = new HashSet<>();

        for (Long categoryId : categoryIds) {
            Category category = categoryRepository.findById(categoryId).orElse(null);
            if (category != null) {
                categories.add(category);
            }
        }

        game.setCategories(categories);
        gameRepository.save(game);

        attributes.addFlashAttribute("message", "게시물이 성공적으로 등록되었습니다.");
        return "redirect:/game";
    }
}
