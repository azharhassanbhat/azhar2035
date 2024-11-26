package com.khudse.controller;

import com.khudse.entity.Post;
import com.khudse.payload.PostDto;
import com.khudse.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    private PostService postservice;

    public PostController(PostService postservice) {
        this.postservice = postservice;
    }

    @PostMapping()
    public ResponseEntity<PostDto> addPt(@RequestBody PostDto postDto){
       PostDto postDtosave = postservice.addPost(postDto);
        return new ResponseEntity<>(postDtosave, HttpStatus.CREATED);
    }
}
