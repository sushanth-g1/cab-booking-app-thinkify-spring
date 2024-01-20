package com.thinkifylabs.cabbookingapplication.repository;

import com.thinkifylabs.cabbookingapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImplementation implements UserRepository {
    private final List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}
