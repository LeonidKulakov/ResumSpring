package ru.kulakov.ResumeSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResumController {

    @GetMapping
    public String getResumPage(Model model){
        model.addAttribute("title", "Моя страница");
        return "resum";
    }
}
