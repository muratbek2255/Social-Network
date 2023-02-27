package com.example.socialnetwork.dto.requests;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostRequest {

    Integer id;

    String text;

    Boolean moderation;

    Integer viewCount;

    UserRequest userRequest;
}
