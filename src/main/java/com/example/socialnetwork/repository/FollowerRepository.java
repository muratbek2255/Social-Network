package com.example.socialnetwork.repository;

import com.example.socialnetwork.entity.Follower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowerRepository extends JpaRepository<Follower, Integer> {
}
