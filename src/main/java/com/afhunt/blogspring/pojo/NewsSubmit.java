package com.afhunt.blogspring.pojo;

public class NewsSubmit {
    public String name;
    public String description;
    public Integer categoryId;
    public NewsSubmit(String name, String description){
        this.name = name;
        this.description = description;
    }
}
