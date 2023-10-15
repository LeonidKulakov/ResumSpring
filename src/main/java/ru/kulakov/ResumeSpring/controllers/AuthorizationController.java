package ru.kulakov.ResumeSpring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorizationController {



    @GetMapping("/authorization")
    public String getAuthorizationPage(Model model){
        model.addAttribute("title", "Авторизация");
        return "authorization";
    }
}
