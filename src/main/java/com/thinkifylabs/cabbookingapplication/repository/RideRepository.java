package com.thinkifylabs.cabbookingapplication.repository;

import com.thinkifylabs.cabbookingapplication.model.Ride;

import java.util.List;

public interface RideRepository {
    public void addRides(Ride ride);

    List<Ride> findRide(int[] userLocation, int[] userDestination);

    boolean isInRange(int[] point1, int[] point2);

}
