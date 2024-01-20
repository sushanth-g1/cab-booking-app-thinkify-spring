package com.thinkifylabs.cabbookingapplication.controller;

import com.thinkifylabs.cabbookingapplication.model.User;
import com.thinkifylabs.cabbookingapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    // Endpoint to add a user
    @PostMapping("/users/add")
    public Map<String, String> addUser(@RequestBody User user) {
        userService.addUser(user.getName(), user.getGender(), user.getAge(), user.getUserSource(), user.getUserDestination());
        Map<String, String> response = new HashMap<>();
        response.put("message", "User added successfully.");
        return response;
    }
}
