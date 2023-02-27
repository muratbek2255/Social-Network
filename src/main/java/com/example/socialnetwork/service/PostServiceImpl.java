package com.example.socialnetwork.service;

import com.example.socialnetwork.dto.requests.PostRequest;
import com.example.socialnetwork.entity.Post;
import com.example.socialnetwork.entity.User;
import com.example.socialnetwork.repository.PostRepository;
import com.example.socialnetwork.service.serviceClass.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final UserServiceImpl userService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserServiceImpl userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    public List<Post> getAllPost() {
        List<Post> posts = postRepository.findAll();

        return posts;
    }

    @Override
    public Post getByIdPost(int id) {
        Post post = postRepository.getById(id);

        return post;
    }

    @Override
    public String addPost(PostRequest postRequest) {

        User user = userService.getByUserId(postRequest.getUserRequest().getId());

        Post post = new Post();

        post.setText(postRequest.getText());
        post.setModeration(postRequest.getModeration());
        post.setUser(user);

        postRepository.save(post);

        return "Post Created!";
    }

    @Override
    public String updatePost(PostRequest postRequest, int id) {

        User user = userService.getByUserId(postRequest.getUserRequest().getId());

        Post post = postRepository.getById(id);

        post.setText(postRequest.getText());
        post.setModeration(postRequest.getModeration());
        post.setUser(user);

        postRepository.save(post);

        return "Post Updated!";
    }

    @Override
    public String deletePost(int id) {
        postRepository.deleteById(id);

        return "Post Deleted!";
    }
}
