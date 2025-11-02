package me.leejoowon.springbootdeveloper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {
    @GetMapping("/login")
    public String login() {
<<<<<<< HEAD
        return "login";
=======
        return "oauthlogin";
>>>>>>> main
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
}
