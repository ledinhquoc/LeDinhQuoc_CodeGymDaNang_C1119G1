package com.codegym.SecurityController;

import com.codegym.repository.UserRePository;
import com.codegym.security.Authority;
import com.codegym.security.Authority_type;
import com.codegym.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashSet;
import java.util.Set;

@Controller
public class SecurityController
{
    @Autowired
    private UserRePository userRePository;
    @GetMapping("/login")
    public String handleLoginRequest(){
        return "security/login";
    }
    @GetMapping("/login-failed")
    public String handleLoginFail(Model model){
        model.addAttribute("status","Incorrect username or password!");
        return "security/login";
    }
    @GetMapping("/logout-oke")
    public String handleLogoutOke(){ // deprecated function
        return "redirect:/";
    }
    @GetMapping("/logout")
    public void handleLogout(@ModelAttribute User currentUser){
        System.out.printf("User {%s} logged out",currentUser.getUsername());
        SecurityContextHolder.getContext().setAuthentication(null);
        currentUser=null;
    }
    @GetMapping("/register")
    public String handleRegisterRequest(Model model){
        model.addAttribute("user",new User());
        return "security/register";
    }
    @PostMapping("/user/new")
    public String handleSaveUser(User user, RedirectAttributes redirectAttributes){
        Authority authority=new Authority();
        authority.setAuthorityType(Authority_type.ROLE_USER);
        Set<Authority> authorities=new HashSet<> ();
        authorities.add(authority);
        user.setAuthorities(authorities);

        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(10)));

        userRePository.save(user);
        redirectAttributes.addFlashAttribute("status","Register successfully!");
        return "redirect:/login";
    }
    @GetMapping("/admin")
    public String handleAdminSite(){
        return "security/admin";
    }
}
