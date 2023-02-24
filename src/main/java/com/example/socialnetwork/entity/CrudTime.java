package com.example.socialnetwork.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class CrudTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Timestamp createdAt;

    Timestamp updated_at;
}
