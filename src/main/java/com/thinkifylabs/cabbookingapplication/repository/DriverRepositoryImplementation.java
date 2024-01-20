package com.thinkifylabs.cabbookingapplication.repository;


import com.thinkifylabs.cabbookingapplication.model.Driver;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DriverRepositoryImplementation implements DriverRepository {
    private final List<Driver> drivers = new ArrayList<>();

    @Override
    public void addDriver(String name, int age, String vehicleDetails, int[] currentLocation) {
        drivers.add(new Driver(name, age, vehicleDetails, currentLocation));
    }

}
