package com.thinkifylabs.cabbookingapplication.repository;

import com.thinkifylabs.cabbookingapplication.model.User;

import java.util.List;

public interface UserRepository {
    void addUser(User user);
    List<User> getUsers();

}
