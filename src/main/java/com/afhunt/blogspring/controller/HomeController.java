package com.afhunt.blogspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    List<News> news = List.of(
    new News("Need HELP with your SPRING BOOT 3 App?"),
    new News("Don't do THIS to your own CODE!"),
    new News("SECRETS to fix BROKEN CODE!")
    );
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("news", news);
        return "index";
    }
    private class News {
        public String s;
        public News(String s) {
            this.s = s;
        }
    }
}
