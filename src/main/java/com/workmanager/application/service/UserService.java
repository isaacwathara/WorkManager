package com.workmanager.application.service;

import com.workmanager.domain.model.User;
import com.workmanager.domain.repository.UserRepository;

import java.util.Optional;
import java .util.UUID;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(String firstName, String lastName, String email, String passwordHash){
        User user = new User(firstName, lastName, email, passwordHash);

        userRepository.save(user);

        return user;

    }

    public Optional<User> findUserById(UUID id){
        return userRepository.findById(id);
    }

    public Optional<User> findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
