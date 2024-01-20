package com.thinkifylabs.cabbookingapplication.controller;

import com.thinkifylabs.cabbookingapplication.exception.RideException;
import com.thinkifylabs.cabbookingapplication.model.Ride;
import com.thinkifylabs.cabbookingapplication.model.User;
import com.thinkifylabs.cabbookingapplication.service.RideService;
import com.thinkifylabs.cabbookingapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RideController {
    @Autowired
    private RideService rideService;

    @Autowired
    private UserService userService;

    // Endpoint to add rides
    @PostMapping("/rides/add")
    public Map<String, String> addRides(@RequestBody Ride ride) {
        rideService.addRide(ride.driverName,ride.source,ride.destination,ride.available);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Rides added successfully.");
        return response;
    }

    // Endpoint to find rides
     @GetMapping("/rides/{username}")
    public List<Ride> findRide(@PathVariable String username, @RequestBody User user) {
        return rideService.findRide(username, user);
    }

    // Endpoint to choose a ride
    @PostMapping("/rides/{username}/choose")
    public Map<String, String> chooseRide(@PathVariable String username, @RequestParam String driverName, @RequestBody List<Ride> availableRides, @RequestBody User user) {
        Map<String, String> response = new HashMap<>();
        try {
            rideService.chooseRide(username, driverName, availableRides, user);
            response.put("message", "Ride chosen successfully.");
        } catch (RideException e) {
            response.put("error", e.getMessage());
        }
        return response;
    }
}
