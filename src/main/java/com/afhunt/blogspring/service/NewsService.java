package com.afhunt.blogspring.service;

import org.springframework.stereotype.Service;
import com.afhunt.blogspring.entity.News;

import java.util.List;

@Service
public class NewsService {
    private List<News> news = List.of( //
            new News("Need HELP with your SPRING BOOT 3 App?"),
            new News("Don't do THIS to your own CODE!"),
            new News("SECRETS to fix BROKEN CODE!"));

    public List<News> getNews() {
        return news;
    }
}
