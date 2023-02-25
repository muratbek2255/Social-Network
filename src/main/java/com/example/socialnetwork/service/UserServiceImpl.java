package com.example.socialnetwork.service;

import com.example.socialnetwork.entity.User;
import com.example.socialnetwork.repository.UserRepository;
import com.example.socialnetwork.service.serviceClass.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {

        List<User> users = userRepository.findAll();

        return users;

    }

    @Override
    public User getByUserId(int id) {

        User user = userRepository.getById(id);

        return user;

    }
}
