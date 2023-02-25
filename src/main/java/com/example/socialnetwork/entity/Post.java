package com.example.socialnetwork.entity;


import jakarta.persistence.*;

import java.sql.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "posts", schema = "socal_network")
public class Post extends CrudTime{

    @Column(name = "text")
    String text;

    @Column(name = "moderation")
    Boolean moderation;

    @Column(name = "view_count")
    Integer viewCount;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User user;
}
