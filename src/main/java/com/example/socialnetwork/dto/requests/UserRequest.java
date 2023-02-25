package com.example.socialnetwork.dto.requests;


import com.example.socialnetwork.entity.enumClass.Gender;
import com.example.socialnetwork.entity.enumClass.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {

    Integer id;

    String firstName;

    String lastName;

    String middleName;

    Timestamp firstTimeLogin;

    String phoneNumber;

    String avatar;

    String bio;

    String email;

    String password;

    String github;

    Date dateBirthday;

    Gender gender;

    String technology;

    Role role;
}
