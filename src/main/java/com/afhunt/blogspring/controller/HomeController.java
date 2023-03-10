package com.afhunt.blogspring.controller;

import com.afhunt.blogspring.entity.News;
import com.afhunt.blogspring.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private NewsService newsService;
    public HomeController(NewsService newsService){
        this.newsService = newsService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("news", newsService.getNews());
        return "index";
    }

    @PostMapping("/new-news")
    public String newVideo(@ModelAttribute News newNews) {
        newsService.create(newNews);
        return "redirect:/";
    }
}
