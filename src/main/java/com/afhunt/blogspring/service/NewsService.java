package com.afhunt.blogspring.service;

import com.afhunt.blogspring.entity.CategoryEntity;
import com.afhunt.blogspring.entity.NewsEntity;
import com.afhunt.blogspring.entity.TagEntity;
import com.afhunt.blogspring.pojo.NewsSubmit;
import com.afhunt.blogspring.repository.CategoryRepository;
import com.afhunt.blogspring.repository.NewsRepository;
import com.afhunt.blogspring.repository.TagRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class NewsService {
    private NewsRepository repository;

    private CategoryRepository categoryRepository;

    private TagRepository tagRepository;

    public NewsService(NewsRepository repository, CategoryRepository categoryRepository, TagRepository tagRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
        this.tagRepository = tagRepository;
    }

    public NewsEntity create(NewsSubmit newsSubmit) {
        return repository.saveAndFlush(new NewsEntity(newsSubmit.name, newsSubmit.description));
    }

    public List<NewsEntity> search(NewsSubmit newsSubmit)
    {
        if (StringUtils.hasText(newsSubmit.name)
                && StringUtils.hasText(newsSubmit.description)){
            return repository
                    .findByNameContainsOrDescriptionContainsAllIgnoreCase(
                            newsSubmit.name, newsSubmit.description);
        }
        if (StringUtils.hasText(newsSubmit.name)){
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

    public List getNews() {
        return repository.findAll();
    }

    @PostConstruct
    void initDatabase(){

        CategoryEntity category1 = new CategoryEntity("Actuality" ,"For news archiving");
        CategoryEntity category2 = new  CategoryEntity("Article" , "For archiving articles");
        categoryRepository.saveAllAndFlush(Arrays.asList(category1, category2));

        TagEntity tag1 = new TagEntity("marketing" ,"Theme Htag marketing");
        TagEntity tag2 = new  TagEntity("politic" , "Theme Htag politic");
        tagRepository.saveAllAndFlush(Arrays.asList(tag1, tag2));

        Set<TagEntity> tags = new HashSet<>();
        tags.addAll(Arrays.asList(tag1, tag2));

        NewsEntity news1 = new NewsEntity("1. Need HELP with your SPRING BOOT 3 App?",
                "SPRING BOOT 3 will only speed things up and make it super SIMPLE to serve templates and raw data.", category2);
        NewsEntity news4 = new NewsEntity("4. Need HELP with your SPRING BOOT 3 App?",
                "SPRING BOOT 3 will only speed things up and make it super SIMPLE to serve templates and raw data.", category2);
        NewsEntity news2 = new NewsEntity("2. Don't do THIS to your own CODE!",
                "As a pro developer, never ever EVER do this to your code. Because you'll ultimately be doing it to YOURSELF!", category1);
        NewsEntity news3 = new NewsEntity("3. SECRETS to fix BROKEN CODE!",
                "Discover ways to not only debug your code, but to regain your confidence and get back in the game as a software developer.", category1);
        repository.saveAllAndFlush(Arrays.asList(news1, news2, news3, news4));

        news1.setTags(tags);
        news2.setTags(tags);
        news3.setTags(tags);
        news4.setTags(tags);
        repository.saveAllAndFlush(Arrays.asList(news1, news2, news3, news4));
        //news3.getTags().forEach(System.out::println);
    }
}
