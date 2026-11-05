package com.workmanager.infrastructure.persistence.memory;

import com.workmanager.domain.model.User;
import com.workmanager.domain.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class MemoryUserRepository implements UserRepository{

    private  final Map<UUID, User> users = new HashMap<>();

    @Override
    public void save(User user){
        users.put(user.getId(), user);
    }

    @Override
    public Optional<User> findById(UUID id){
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public Optional<User> findByEmail(String email){

        for (User user : users.values()) {
            if(user.getEmail().equalsIgnoreCase(email)) {
                return Optional.of(user);
            }
        }

        return Optional.empty();
    }
}
