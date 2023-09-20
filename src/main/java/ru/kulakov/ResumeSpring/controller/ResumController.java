package ru.kulakov.ResumeSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ResumController {

    @GetMapping("/{login}")
    public String showResumPage(Model model, @PathVariable String login) {
        model.addAttribute("title", login);
        model.addAttribute("display", "d-none");
        return "resum.html";
    }

    @GetMapping("/resum/{login}")
    public String getResumPage(Model model, @PathVariable String login) {
        model.addAttribute("title", login);
        return "resum";
    }

    @GetMapping("/resum/{login}/addblog")
    public String showAddBlogPage() {
        return "addblog.html";
    }


    @GetMapping("/resum/{login}/deleteblog")
    public String showDeleteBlogPage() {
        return "deleteblog.html";
    }
}
