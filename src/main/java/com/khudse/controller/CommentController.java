package com.khudse.controller;

import com.khudse.entity.Comment;
import com.khudse.payload.CommentDto;
import com.khudse.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {
    private PostService postservice;

    public CommentController(PostService postService) {
        this.postservice = postService;
    }

    @PostMapping()
    public ResponseEntity<CommentDto> createCom(@RequestBody CommentDto commentDto, @RequestParam long postId){
        System.out.println(1000);
        System.out.println(2000);
        System.out.println(3000);
        System.out.println(2000);
        System.out.println(3000);
        CommentDto commentDto1 = postservice.createComment(commentDto,postId);
        return new ResponseEntity<>(commentDto1, HttpStatus.CREATED);
    }
}
