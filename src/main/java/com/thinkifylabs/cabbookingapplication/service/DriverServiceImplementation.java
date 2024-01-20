package com.thinkifylabs.cabbookingapplication.service;

import com.thinkifylabs.cabbookingapplication.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DriverServiceImplementation implements DriverService{
    private final DriverRepository driverRepository;

    @Autowired
    public DriverServiceImplementation(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }
    @Override
    public void addDriver(String name, int age, String vehicleDetails, int[] currentLocation) {
        driverRepository.addDriver(name, age, vehicleDetails, currentLocation);
    }

}
