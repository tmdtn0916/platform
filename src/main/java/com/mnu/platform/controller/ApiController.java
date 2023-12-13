package com.mnu.platform.controller;

import com.mnu.platform.entity.Review;
import com.mnu.platform.entity.UserData;
import com.mnu.platform.repository.ReviewRepository;
import com.mnu.platform.repository.UserRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/getReview")
    public JSONArray review(){
        JSONArray array= new JSONArray();

        List<Review> reviewList = new ArrayList<>();
        reviewList = reviewRepository.findAll();

        for (Review review : reviewList) {
            JSONObject ob = new JSONObject();
            ob.put("reviewId", review.getReviewId());
            ob.put("title", review.getTitle());
            ob.put("recommend", review.isRecommend());
            ob.put("content", review.getContent());

            // Add more fields as needed
            System.out.println(review.getReviewId());
            array.add(ob);
        }
        return array;
    }

    @GetMapping("/getAuth")
    public JSONObject getAuth(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserData user = userRepository.findByEmail(username);

        JSONObject ob = new JSONObject();
        ob.put("auth",user.getAuth());

        return ob;
    }
}
