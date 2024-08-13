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
        page.addAttribute("username",this.loginmanageService.getUsername());
        page.addAttribute("color",color);
        return "homepage.html"; //return the HTML name that we want tthe brower to display
    }



    @GetMapping("/")
    public String logout(Model page, @RequestParam(required = false) String logout){ //the Model refer to ui.model in package

        if("true".equals(logout)){
            this.loginmanageService.setUsername(null);
            System.out.println("already clear name");
        }
        page.addAttribute("username",this.loginmanageService.getUsername());
        page.addAttribute("color","blue");
        return "homepage.html"; //return the HTML name that we want tthe brower to display
    }




    private final ReviewService reviewService;
    private final LoginUserManageService loginmanageService;
    //private final ReviewController reviewController;



    public MainController(ReviewService reviewserv,LoginUserManageService loginmanageService){
        this.reviewService=reviewserv;
        this.loginmanageService=loginmanageService;
        //this.reviewController=reviewController;

    }

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }


    @PostMapping("/login")
    public String login(
            @RequestParam String name
    ){
        this.loginmanageService.setUsername(name);

        return "redirect:/";
    }

/*
    @GetMapping("/reviews")
    public String reviews(Model m){
        //var reviews=reviewService.findAll();
        var reviews=this.reviewController.getAllReview();
        m.addAttribute("reviews",reviews);  //send the data to view

        return "reviews.html";
    }



    @PostMapping("/reviews")
    public String addreview(
            @RequestParam String name,
            @RequestParam String content,
            Model m
    ){

        if(this.loginmanageService.getUsername()==null){ //no user log in currently, cannot add a review
            return "login.html";
        }

        //System.out.println("name and content:"+name+"   "+content);
        Review rv=new Review(name,content);

        //System.out.println("Calling reviewService.addReview");
        reviewService.addReview(rv);

        //System.out.println("Calling reviewService.findAll");
        var reviews=reviewService.findAll();
        m.addAttribute("reviews",reviews);
        m.addAttribute("message","Success! Thanks for sharing!");

        //System.out.println("Returning view reviews.html");
        return "reviews.html";

    }
 */
}
