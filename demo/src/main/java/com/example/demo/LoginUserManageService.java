package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class LoginUserManageService {
    private String username;


    public String getUsername(){
        return this.username;
    }

    public void setUsername(String uname){
        this.username=uname;
    }
}
