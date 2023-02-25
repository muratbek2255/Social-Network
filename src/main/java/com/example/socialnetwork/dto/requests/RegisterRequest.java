package com.example.socialnetwork.dto.requests;


import com.example.socialnetwork.entity.enumClass.Gender;
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
public class RegisterRequest {

    Integer id;

    String firstName;

    String lastName;

    String middleName;

    String phoneNumber;

    String avatar;

    String bio;

    String email;

    String password;

    String github;

    Date dateBirthday;

    Gender gender;

    String technology;
}
