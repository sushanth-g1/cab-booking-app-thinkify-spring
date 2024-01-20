package com.thinkifylabs.cabbookingapplication.service;

import com.thinkifylabs.cabbookingapplication.model.User;
import com.thinkifylabs.cabbookingapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImplementation implements UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(String name, String gender, int age, int[] userSource, int[] userDestination) {
        userRepository.addUser(new User(name, gender, age, userSource, userDestination));
    }
}
