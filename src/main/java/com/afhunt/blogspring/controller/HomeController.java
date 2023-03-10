package com.afhunt.blogspring.controller;

import com.afhunt.blogspring.entity.News;
import com.afhunt.blogspring.entity.NewsEntity;
import com.afhunt.blogspring.pojo.NewsSubmit;
import com.afhunt.blogspring.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
    public String newVideo(@ModelAttribute NewsSubmit newNews) {
        newsService.create(newNews);
        return "redirect:/";
    }

    @PostMapping("/multi-field-search")
    public String multiFieldSearch(@ModelAttribute NewsSubmit search, Model model) {
        List<NewsEntity> searchResults = newsService.search(search);
        model.addAttribute("news", searchResults);
        return "index";
    }
}
