package com.example.demo;

import Model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    private final ReviewProxy reviewsProxy;

    @Autowired
    public ReviewController(ReviewProxy proxy){

        this.reviewsProxy = proxy;
    }



    @PostMapping("/reviews")
    public Review addreview(
            @RequestBody Review review
    ){
        return reviewsProxy.addReview(review);
    }
/*
    @GetMapping("/all")
    public List<Review> getallreviews(){
        Review rv1=new Review("a","good");
        Review rv2=new Review("b","also good");

        return List.of(rv1,rv2);
    }
*/
    @GetMapping("/header")
    public ResponseEntity<Review> getreviewWithHeader(){
        Review rv=new Review();
        rv.setName("c");
        rv.setContent("just soso");

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("posttime","Aug 7") //add a header
                .body(rv);
    }


    @GetMapping("/body")
    public ResponseEntity<Review> getwithbody(@RequestBody Review clientrequestbody){

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(clientrequestbody);

    }
}
