package ru.kulakov.ResumeSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//TODO переделать в нормальный контроллер
@Controller
public class TestController {

    @GetMapping
    public String test(Model model){
        model.addAttribute("title","test");
        return "blog.html";
    }
}