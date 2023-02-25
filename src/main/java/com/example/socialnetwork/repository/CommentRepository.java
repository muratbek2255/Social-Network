package com.example.socialnetwork.repository;

import com.example.socialnetwork.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "SELECT * FROM socal_network.comments WHERE socal_network.comments.id = ?1", nativeQuery = true)
    Comment getById(@Param("id") int id);

}
