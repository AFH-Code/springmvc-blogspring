package com.afhunt.blogspring.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class TagEntity {
    private @Id
    @GeneratedValue
    Long id;


    @Column(name="name", nullable=false, length=512)
    public String name;

    @Column(name="description", nullable=false, length=512)
    public String description;

    @ManyToMany(mappedBy="tags", fetch = FetchType.EAGER)
    private Set<NewsEntity> news = new HashSet<NewsEntity>();

    protected TagEntity() {
        this(null, null);
    }
    public TagEntity(String name, String description) {
        this.id = null;
        this.description = description;
        this.name = name;
    }
}
