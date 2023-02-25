package com.example.socialnetwork.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "comments", schema = "socal_network")
public class Comment extends CrudTime{

    @Column(name = "text")
    String text;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    Post post;

    @Column(name = "deleted")
    Boolean deleted;
}
