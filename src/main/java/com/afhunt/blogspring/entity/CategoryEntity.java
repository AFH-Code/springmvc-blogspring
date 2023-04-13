package com.afhunt.blogspring.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CategoryEntity {
    private @Id
    @GeneratedValue
    Long id;

    @Column(name="name", nullable=false, length=512)
    public String name;

    @Column(name="description", nullable=false, length=512)
    public String description;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="category")
    private List<NewsEntity> news;

    protected CategoryEntity() {
        this(null, null);
    }
    public CategoryEntity(String name, String description) {
        this.id = null;
        this.description = description;
        this.name = name;
    }
}
