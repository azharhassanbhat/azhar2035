package com.khudse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;
    @Column(name="description", nullable = false)
    private String description;

    @OneToMany(mappedBy="post")
    private List<Comment> comment;


}