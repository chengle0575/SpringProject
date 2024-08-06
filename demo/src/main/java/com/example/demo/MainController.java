package com.example.demo;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import Model.Review;


@Controller //stereotype annotation for adding bean to context
public class MainController {

    @RequestMapping("/{color}")//associate below method to an HTTP request
    public String home(Model page,@PathVariable String color){ //the Model refer to ui.model in package
                                    //parameter to retrieve from HTTP request parameter
        page.addAttribute("username","Judy");
        page.addAttribute("color",color);
        return "homepage.html"; //return the HTML name that we want tthe brower to display
    }




    private final ReviewService reviewService;

    public MainController(ReviewService reviewserv){
        this.reviewService=reviewserv;
    }




    @GetMapping("/reviews")
    public String reviews(Model m){
        var reviews=reviewService.findAll();
        m.addAttribute("reviews",reviews);  //send the data to view

        return "reviews.html";
    }

    @PostMapping("/reviews")
    public String addreview(
            @RequestParam String name,
            @RequestParam String content,
            Model m
    ){

        System.out.println("name and content:"+name+"   "+content);
        Review rv=new Review(name,content);

        System.out.println("Calling reviewService.addReview");
        reviewService.addReview(rv);

        System.out.println("Calling reviewService.findAll");
        var reviews=reviewService.findAll();
        m.addAttribute("reviews",reviews);


        System.out.println("Returning view reviews.html");
        return "reviews.html";

    }

}
