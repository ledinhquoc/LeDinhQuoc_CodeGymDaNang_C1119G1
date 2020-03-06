package com.codegym.controller;

import com.codegym.security.MyUserDetails;
import com.codegym.security.User;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


@Controller
public class HomeController {

    @RequestMapping(path = "/",method = {RequestMethod.GET,RequestMethod.POST})
    public String getHome(HttpServletRequest request,
                          Model model,
                          @ModelAttribute("currentUser")User currentUser){
        Cookie[] cookies = request.getCookies ();
        for (Cookie c: cookies){
           if (c.getName ().equals ("dateCreated")){
                StringBuilder builder =new StringBuilder ();
               Arrays.asList (c.getValue ().split ("#")).forEach (s -> {
                    if (!s.equals ("")){
                        builder.append ("#").append (s).append ("<br>");
                    }
               });
                    model.addAttribute ("dateCreated",builder);
               System.out.println (c.getValue ());
           }
        }
        Object principle = SecurityContextHolder.getContext ().getAuthentication ().getPrincipal ();
        if (principle instanceof MyUserDetails){
            currentUser = ((MyUserDetails)principle).getUser ();
            System.out.printf ("User name{%s}",currentUser.getUsername ());
        }
        return "home/index";
    }
    }

