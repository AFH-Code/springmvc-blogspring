package com.afhunt.blogspring.service;

import com.afhunt.blogspring.entity.NewsEntity;
import com.afhunt.blogspring.pojo.NewsSubmit;
import com.afhunt.blogspring.repository.NewsRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.afhunt.blogspring.entity.News;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class NewsService {
    private NewsRepository repository;

    public NewsService(NewsRepository repository) {
        this.repository = repository;
    }

    public List<NewsEntity> getNews() {
        return repository.findAll();
    }

    public NewsEntity create(NewsSubmit newsSubmit) {
        return repository.saveAndFlush(new NewsEntity(newsSubmit.name, newsSubmit.description));
    }

    public List<NewsEntity> search(NewsSubmit newsSubmit)
    {
        if (StringUtils.hasText(newsSubmit.name)
                && StringUtils.hasText(newsSubmit.description)) {
            return repository
                    .findByNameContainsOrDescriptionContainsAllIgnoreCase(
                            newsSubmit.name, newsSubmit.description);
        }
        if (StringUtils.hasText(newsSubmit.name)) {
            return repository.findByNameContainsIgnoreCase
                    (newsSubmit.name);
        }
        if (StringUtils.hasText(newsSubmit.description)) {
            return repository.findByDescriptionContainsIgnoreCase
                    (newsSubmit.description);
        }else{
            return Collections.emptyList();
        }
    }

    @PostConstruct
    void initDatabase() {
        repository.save(new NewsEntity("Need HELP with your SPRING BOOT 3 App?",
                "SPRING BOOT 3 will only speed things up and make it super SIMPLE to serve templates and raw data."));
        repository.save(new NewsEntity("Don't do THIS to your own CODE!",
                "As a pro developer, never ever EVER do this to your code. Because you'll ultimately be doing it to YOURSELF!"));
        repository.save(new NewsEntity("SECRETS to fix BROKEN CODE!",
                "Discover ways to not only debug your code, but to regain your confidence and get back in the game as a software developer."));
    }
}
