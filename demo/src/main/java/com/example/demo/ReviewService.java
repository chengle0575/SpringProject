package com.example.demo;

import Model.Review;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {
    private List<Review> reviews=new ArrayList<>();

    public void addReview(Review p){
        reviews.add(p);
    }

    public List<Review> findAll(){
        return reviews;
    }
}
