package me.leechaeyoung.springbootdeveloper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        // 서버에 존재하는 실제 파일명과 일치해야 함
        return "oauthLogin";
    }
}