package com.afhunt.blogspring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class NewsEntity {
    private @Id @GeneratedValue Long id;
    public String name;
    public String description;
    protected NewsEntity() {
        this(null, null);
    }
    public NewsEntity(String name, String description) {
        this.id = null;
        this.description = description;
        this.name = name;
    }
}

