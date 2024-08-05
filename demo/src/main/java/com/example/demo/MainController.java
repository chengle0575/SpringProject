package com.example.demo;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

gitqq
@Controller //stereotype annotation for adding bean to context
public class MainController {

    @RequestMapping("/")//associate below method to an HTTP request
    public String home(Model page,@RequestParam String color, @RequestParam String name){ //the Model refer to ui.model in package
                                    //parameter to retrieve from HTTP request parameter

        page.addAttribute("username",name);
        page.addAttribute("color",color);


        return "homepage.html"; //return the HTML name that we want tthe brower to display
    }
}
