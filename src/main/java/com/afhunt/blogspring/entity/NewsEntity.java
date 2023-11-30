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

    @ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
    @JoinTable(name="tag_news",
            joinColumns = { @JoinColumn(name="newsid", referencedColumnName="id") },
            inverseJoinColumns = { @JoinColumn(name="tagid", referencedColumnName="id") })
    private Set<TagEntity> tags = new HashSet<>();

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

    public void setTags(Set<TagEntity> tags) {
        this.tags = tags;
    }

    public Set<TagEntity> getTags() {
        return tags;
    }
}

