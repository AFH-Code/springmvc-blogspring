package com.afhunt.blogspring.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name="tag_news",
            joinColumns = { @JoinColumn(name="newsid") },
            inverseJoinColumns = { @JoinColumn(name="tagid") })
    private Set<TagEntity> tags = new HashSet<TagEntity>();

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

