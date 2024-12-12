package com.pluralsight.dealership_spring.model;



import java.util.ArrayList;

public class Dealership {
    private final int id;
    private final String businessName;
    private final String address;
    private final String phoneNumber;
    private final ArrayList<Vehicle> dealershipInventory;

    public Dealership(int id, String businessName, String address, String phoneNumber) {
        this.id = id;
        this.businessName = businessName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dealershipInventory = new ArrayList<>();
    }


    // when this method is called it adds the vehicle to inventory
    public void addVehicle(Vehicle vehicle) {
        dealershipInventory.add(vehicle);
    }

    // when this method is called it removes the vehicle from inventory
    public void removeVehicle(Vehicle vehicle) {
        dealershipInventory.remove(vehicle);
    }


}