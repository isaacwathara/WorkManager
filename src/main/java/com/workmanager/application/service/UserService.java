package com.workmanager.application.service;
import com.workmanager.domain.model.User;

public class UserService {

    public User createUser(
            String firstname,
            String lastName,
            String email,
            String passwordHash
    ){
        User user = new User (
                firstname,
                lastName,
                email,
                passwordHash
        );

        return user;
    }
}
