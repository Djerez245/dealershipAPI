package com.pluralsight.dealership_spring.dao;



import com.pluralsight.dealership_spring.model.Vehicle;

import java.util.ArrayList;

public interface VehiclesDAO {
    ArrayList<Vehicle> findAllVehicle();
    ArrayList<Vehicle> findVehicleByMake(String make);
    ArrayList<Vehicle> findVehicleByModel(String model);
    ArrayList<Vehicle> findVehicleByColor(String color);
    ArrayList<Vehicle> findVehicleByVin(int vin);
    ArrayList<Vehicle> findVehiclesByType(String type);
    ArrayList<Vehicle> findVehiclesByPriceRange(double minPrice, double maxPrice);
    ArrayList<Vehicle> findVehiclesByMileage(int minOdometer, int maxOdometer);
    ArrayList<Vehicle> findVehicleByYear(int year);
    void addVehicle(Vehicle v);
    void removeVehicle(int vin);
}
