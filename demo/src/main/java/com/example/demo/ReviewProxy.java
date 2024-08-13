package com.example.demo;

import Model.Review;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



@Component
public class ReviewProxy {

    private final RestTemplate rest;

    @Value("")
    private String reviewServiceUrl;

    public ReviewProxy(RestTemplate rest){
        this.rest=rest;
    }


    public Review addReview(Review review){
        String uri=reviewServiceUrl+"/review";

        HttpHeaders headers=new HttpHeaders();
        headers.add("id", UUID.randomUUID().toString());

        HttpEntity<Review> entity=new HttpEntity<>(review,headers);

        ResponseEntity<Review> response=
                rest.exchange(uri,
                        HttpMethod.POST,
                        entity,
                        Review.class);

        return response.getBody();
    }

}