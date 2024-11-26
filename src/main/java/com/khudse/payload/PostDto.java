package com.khudse.payload;

import com.khudse.entity.Comment;
import lombok.Data;

import java.util.List;
@Data
public class PostDto {
    private Long id;
    private String name;
    private String description;
    private List<Comment> comment;
}
