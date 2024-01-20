package com.thinkifylabs.cabbookingapplication.repository;

// DriverRepository.java

public interface DriverRepository {
    void addDriver(String name, int age, String vehicleDetails, int[] currentLocation);
}

