package com.example.socialnetwork.service.serviceClass;

import com.example.socialnetwork.dto.requests.CommentRequest;
import com.example.socialnetwork.entity.Comment;

import java.util.List;

public interface CommentService {

    public List<Comment> getAllComment();

    public String getByIdComment(int id);

    public String addComment(CommentRequest commentRequest);

    public String updateComment(CommentRequest commentRequest, int id);

    public String deleteComment(int id);
}
