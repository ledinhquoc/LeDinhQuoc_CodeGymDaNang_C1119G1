package com.codegym.controller;

import com.codegym.response.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class DashBoardController {

    @ModelAttribute("user")
    public User set(){
        return new User();
    }
    @GetMapping("/dashboard")
    public String login() {
        return "dashboard";
    }

}
