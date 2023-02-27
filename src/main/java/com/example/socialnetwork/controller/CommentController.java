package com.example.socialnetwork.controller;


import com.example.socialnetwork.dto.requests.CommentRequest;
import com.example.socialnetwork.entity.Comment;
import com.example.socialnetwork.service.CommentServiceImpl;
import com.example.socialnetwork.service.serviceClass.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentServiceImpl commentService;


    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComment() {
        return ResponseEntity.status(200).body(commentService.getAllComment());
    }

    @PostMapping
    public ResponseEntity<String> addComment(@RequestBody CommentRequest commentRequest) {
        return ResponseEntity.status(200).body(commentService.addComment(commentRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateComment(@RequestBody CommentRequest commentRequest,
                                                @PathVariable int id) {
        return ResponseEntity.status(201).body(commentService.updateComment(commentRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable int id) {
        return ResponseEntity.status(202).body(commentService.deleteComment(id));
    }
}
