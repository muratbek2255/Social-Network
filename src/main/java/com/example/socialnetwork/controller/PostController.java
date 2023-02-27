package com.example.socialnetwork.controller;


import com.example.socialnetwork.dto.requests.PostRequest;
import com.example.socialnetwork.entity.Post;
import com.example.socialnetwork.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/post")
public class PostController {

    private final PostServiceImpl postService;

    @Autowired
    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.status(200).body(postService.getAllPost());
    }

    @PostMapping
    public ResponseEntity<String> addPost(@RequestBody PostRequest postRequest) {
        return ResponseEntity.status(201).body(postService.addPost(postRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePost(@RequestBody PostRequest postRequest,
                                             @PathVariable int id) {
        return ResponseEntity.status(201).body(postService.updatePost(postRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable int id) {
        return ResponseEntity.status(202).body(postService.deletePost(id));
    }
}
