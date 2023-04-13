package com.afhunt.blogspring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class NewsEntity {
    private @Id @GeneratedValue Long id;

    @Column(name="name", nullable=false, length=512)
    public String name;

    @Column(name="description", nullable=false, length=512)
    public String description;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="category")
    private CategoryEntity category;

    protected NewsEntity() {
        this(null, null);
    }
    public NewsEntity(String name, String description) {
        this.id = null;
        this.description = description;
        this.name = name;
    }
    public NewsEntity(String name, String description, CategoryEntity category) {
        this.id = null;
        this.description = description;
        this.name = name;
        this.category = category;
    }
}

