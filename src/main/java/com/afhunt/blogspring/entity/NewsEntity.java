package com.afhunt.blogspring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
class NewsEntity {
    private @Id @GeneratedValue Long id;
    private String name;
    private String description;
    protected NewsEntity() {
        this(null, null);
    }
    NewsEntity(String name, String description) {
        this.id = null;
        this.description = description;
        this.name = name;
    }
}

