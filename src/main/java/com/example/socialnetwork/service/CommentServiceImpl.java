package com.example.socialnetwork.service;

import com.example.socialnetwork.dto.requests.CommentRequest;
import com.example.socialnetwork.entity.Comment;
import com.example.socialnetwork.entity.Post;
import com.example.socialnetwork.entity.User;
import com.example.socialnetwork.repository.CommentRepository;
import com.example.socialnetwork.service.serviceClass.CommentService;
import com.example.socialnetwork.service.serviceClass.PostService;
import com.example.socialnetwork.service.serviceClass.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final UserService userService;

    private final PostService postService;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    @Override
    public List<Comment> getAllComment() {

        List<Comment> comments = commentRepository.findAll();

        return comments;

    }

    @Override
    public String getByIdComment(int id) {

        Comment comment = commentRepository.getById(id);

        return "Comment with id: " + id + " = " + comment;
    }

    @Override
    public String addComment(CommentRequest commentRequest) {

        Comment comment = new Comment();

        User user = userService.getByUserId(commentRequest.getUserRequest().getId());
        Post post = postService.getByIdPost(commentRequest.getPostRequest().getId());

        comment.setText(commentRequest.getText());
        comment.setUser(user);
        comment.setPost(post);
        comment.setDeleted(Boolean.FALSE);

        return "Comment created!";
    }

    @Override
    public String updateComment(CommentRequest commentRequest, int id) {

        Comment comment = commentRepository.getById(id);

        User user = userService.getByUserId(commentRequest.getUserRequest().getId());
        Post post = postService.getByIdPost(commentRequest.getPostRequest().getId());

        comment.setText(commentRequest.getText());
        comment.setUser(user);
        comment.setPost(post);
        comment.setDeleted(commentRequest.getDeleted());

        return "Comment Updated!";

    }

    @Override
    public String deleteComment(int id) {

        commentRepository.deleteById(id);

        return "Comment deleted";

    }
}
