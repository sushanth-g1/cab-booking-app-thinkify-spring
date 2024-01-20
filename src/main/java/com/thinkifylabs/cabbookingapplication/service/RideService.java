package com.thinkifylabs.cabbookingapplication.service;

import com.thinkifylabs.cabbookingapplication.exception.RideException;
import com.thinkifylabs.cabbookingapplication.model.Ride;
import com.thinkifylabs.cabbookingapplication.model.User;

import java.util.List;

public interface RideService {
    public void addRide(String driverName, int[] source, int[] destination, boolean available);

    List<Ride> findRide(String username, User user);

    void chooseRide(String username, String driverName, List<Ride> availableRides, User user) throws RideException;

    Ride getNearestRide(int[] userlocation, List<Ride> rides);
}
