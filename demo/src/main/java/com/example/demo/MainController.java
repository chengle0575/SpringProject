package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //stereotype annotation for adding bean to context
public class MainController {

    @RequestMapping("/") //associate below method to an HTTP request
    public String home(){
        return "homepage.html"; //return the HTML name that we want tthe brower to display
    }
}
