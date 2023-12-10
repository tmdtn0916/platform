package com.mnu.platform.controller;

import com.mnu.platform.entity.Category;
import com.mnu.platform.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
public class BoardController {

    private CategoryRepository categoryRepository;

    @Autowired
    public BoardController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Value("${upload.path}")
    private String uploadPath; // 파일 업로드 경로

    @GetMapping("/board")
    public String showBoardForm(Model model) {
        List<Category> categories = categoryRepository.findAll();

        System.out.println(categories);
        model.addAttribute("categories", categories);
        return "board";
    }

//    @PostMapping("/form")
//    public String processForm(@ModelAttribute Bulletin bulletin, RedirectAttributes attributes) {
//        // 게시물 저장 등 로직을 여기에 구현합니다.
//        // bulletin 객체에는 폼에서 제출된 데이터가 자동으로 바인딩됩니다.
//        // 파일 업로드를 처리하려면 MultipartFile을 사용하세요.
//        MultipartFile thumbnailUpload = bulletin.getThumbnailUpload();
//        if (thumbnailUpload != null && !thumbnailUpload.isEmpty()) {
//            try {
//                // 업로드된 파일을 저장하거나 다른 작업을 수행합니다.
//                String fileName = System.currentTimeMillis() + "_" + thumbnailUpload.getOriginalFilename();
//                thumbnailUpload.transferTo(new File(uploadPath + fileName));
//                bulletin.setThumbnail(fileName);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        // 게시물을 저장하거나 처리하는 서비스 메서드를 호출합니다.
//        bulletinBoardService.saveBulletin(bulletin);
//
//        attributes.addFlashAttribute("message", "게시물이 성공적으로 등록되었습니다.");
//        return "redirect:/board/form";
//    }
}
