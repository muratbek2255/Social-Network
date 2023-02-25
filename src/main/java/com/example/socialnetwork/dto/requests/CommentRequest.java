package com.example.socialnetwork.dto.requests;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentRequest {

    String text;

    Date published;

    UserRequest userRequest;

    PostRequest postRequest;

    Boolean deleted;

}
