package ru.kulakov.ResumeSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.kulakov.ResumeSpring.model.UserModel;

@Controller
public class ResumController {

    @GetMapping("/{login}")
    public String getResumPage(Model model, @PathVariable String login){
        model.addAttribute("title", login);
        model.addAttribute("display", "d-none");
        return "resum";
    }

    @GetMapping("/resum/{login}")
    public String getResumPage(Model model, @PathVariable String login, @RequestBody UserModel user){
        model.addAttribute("title", login);
        return "resum";
    }
}
