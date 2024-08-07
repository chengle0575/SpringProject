package com.example.demo;

import Model.Review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    @GetMapping("/getoneReview")
    public Review getReview(){

        Review rv=new Review("aaa","not bad la");
        return rv;
    }



    @GetMapping("/all")
    public List<Review> getallreviews(){
        Review rv1=new Review("a","good");
        Review rv2=new Review("b","also good");

        return List.of(rv1,rv2);
    }

    @GetMapping("/header")
    public ResponseEntity<Review> getreviewWithHeader(){
        Review rv=new Review("c","just soso");

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
