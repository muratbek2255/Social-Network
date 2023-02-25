package com.example.socialnetwork.repository;

import com.example.socialnetwork.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    @Query(value = "SELECT * FROM socal_network.users WHERE socal_network.users.id = ?1", nativeQuery = true)
    User getById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);

}
