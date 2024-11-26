package com.khudse.payload;

import com.khudse.entity.Post;
import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String name;
    private String description;
    private Post post;
}
