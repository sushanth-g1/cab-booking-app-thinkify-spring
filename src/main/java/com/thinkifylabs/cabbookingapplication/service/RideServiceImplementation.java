package com.thinkifylabs.cabbookingapplication.service;

import com.thinkifylabs.cabbookingapplication.exception.RideException;
import com.thinkifylabs.cabbookingapplication.model.Ride;
import com.thinkifylabs.cabbookingapplication.model.User;
import com.thinkifylabs.cabbookingapplication.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RideServiceImplementation implements RideService{
    private final RideRepository rideRepository;

    @Autowired
    public RideServiceImplementation(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public void addRide(String driverName, int[] source, int[] destination, boolean available) {
        rideRepository.addRides(new Ride(driverName,source,destination,available));
    }
    @Override
    public List<Ride> findRide(String username, User user) {
        List<Ride> availableRides = rideRepository.findRide(user.getUserSource(), user.getUserDestination());

        if (availableRides.isEmpty()) {
            System.out.println("No rides available for " + username);
        } else {
            System.out.println("Rides available for " + username + ":");
            for (Ride ride : availableRides) {
                System.out.println("Driver: " + ride.driverName + " [Available]");
//                ride.available = false;
            }
        }

        return availableRides;
    }

    @Override
    public void chooseRide(String username, String driverName, List<Ride> availableRides, User user) throws RideException {
        if (availableRides.isEmpty()) {
            System.out.println("No rides available for " + username);
            return;
        }
        for (Ride ride : availableRides) {
            if (ride.driverName.equals(driverName) && ride.available) {
                Ride nearestRide = getNearestRide(user.getUserSource(), availableRides);
                if (nearestRide != null) {
                    nearestRide.available = false;
                    System.out.println(username + " is riding with the nearest driver: " + nearestRide.driverName);
                } else {
                    throw new RideException("Error choosing the nearest ride.");
                }
//                ride.available = false;
//                System.out.println(username + " is riding with " + driverName);
                return;
            }
        }
        throw new RideException( "Ride not available or already chosen");
    }

    public Ride getNearestRide(int[] userlocation,List<Ride> rides){
        Ride nearestRide = null;
        double minDistance = Double.MAX_VALUE;
        for (Ride ride : rides){
            double distance = Math.sqrt(Math.pow(ride.source[0]-userlocation[0],2)+Math.pow(ride.source[1]-userlocation[1],2));
            if(distance<minDistance){
                minDistance = distance;
                nearestRide = ride;
            }
        }
        return nearestRide;
    }
}
