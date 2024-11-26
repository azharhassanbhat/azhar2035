package com.khudse.service;

import com.khudse.entity.Comment;
import com.khudse.entity.Post;
import com.khudse.payload.CommentDto;
import com.khudse.payload.PostDto;
import com.khudse.repository.CommentRepository;
import com.khudse.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private ModelMapper modelmapper;
    private PostRepository postrepository;
    private CommentRepository commentrepository;

    public PostService(PostRepository postrepository,CommentRepository commentrepository){
        this.postrepository = postrepository;
        this.commentrepository = commentrepository;
    }


    PostDto mapToPostDto(Post post){
        PostDto postDto = modelmapper.map(post,PostDto.class);
        return postDto;
    }
    Post mapToPost(PostDto postDto){
        Post post =modelmapper.map(postDto,Post.class);
        return post;
    }
    CommentDto mapToCommentDto(Comment comment){
        CommentDto commentDto = modelmapper.map(comment, CommentDto.class);
        return commentDto;
    }
    Comment mapToComment(CommentDto commentDto){
        Comment comment = modelmapper.map(commentDto,Comment.class);
        return comment;
    }

    public PostDto addPost(PostDto postDto) {
        Post post =mapToPost(postDto);
        Post p1 = postrepository.save(post);
        PostDto postDtosave = mapToPostDto(p1);
    return postDtosave;
    }

    public CommentDto createComment(CommentDto commentDto, long postId) {
        Post post = postrepository.findById(postId).get();
        commentDto.setId(postId);
        Comment comment  = mapToComment(commentDto);
        Comment com = commentrepository.save(comment);
        CommentDto commentDto1 =mapToCommentDto(com);
        return commentDto1;
    }
}
