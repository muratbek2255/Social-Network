package com.example.socialnetwork.service.serviceClass;

import com.example.socialnetwork.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUser();

    public User getByUserId(int id);

}
