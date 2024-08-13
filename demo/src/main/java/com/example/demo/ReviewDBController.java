package com.example.demo;

import Model.Review;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewDBController {
    private final ReviewRepository reviewRepository;

    public ReviewDBController(ReviewRepository reviewRepository){
        this.reviewRepository=reviewRepository;
    }

    @PostMapping
    public void storeReview(@RequestBody Review review){
        reviewRepository.storeReview(review);

    }

    @GetMapping
    public List<Review> findReviews(){
        return reviewRepository.findAllReviews();

    }
}
