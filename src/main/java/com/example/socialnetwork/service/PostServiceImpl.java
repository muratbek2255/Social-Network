package com.example.socialnetwork.service;

import com.example.socialnetwork.dto.requests.PostRequest;
import com.example.socialnetwork.entity.Post;
import com.example.socialnetwork.repository.PostRepository;
import com.example.socialnetwork.service.serviceClass.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public Post getByIdPost(int id) {
        return null;
    }

    @Override
    public String addPost(PostRequest postRequest) {
        return null;
    }

    @Override
    public String updatePost(PostRequest postRequest, int id) {
        return null;
    }

    @Override
    public String deletePost(int id) {
        return null;
    }
}
