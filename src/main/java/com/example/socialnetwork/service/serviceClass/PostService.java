package com.example.socialnetwork.service.serviceClass;

import com.example.socialnetwork.dto.requests.PostRequest;
import com.example.socialnetwork.entity.Post;

import java.util.List;

public interface PostService {

    public List<Post> getAllPost();

    public Post getByIdPost(int id);

    public String addPost(PostRequest postRequest);

    public String updatePost(PostRequest postRequest, int id);

    public String deletePost(int id);

}
