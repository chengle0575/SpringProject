package com.example.demo;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller //stereotype annotation for adding bean to context
public class MainController {

    @RequestMapping("/{color}")//associate below method to an HTTP request
    public String home(Model page,@PathVariable String color){ //the Model refer to ui.model in package
                                    //parameter to retrieve from HTTP request parameter

        page.addAttribute("username","Judy");
        page.addAttribute("color",color);


        return "homepage.html"; //return the HTML name that we want tthe brower to display
    }
}
