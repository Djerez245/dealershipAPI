package com.pluralsight.dealership_spring.model;

public class Vehicle {
    private final int vin;
    private final int year;
    private final String make;
    private final String model;
    private final String vehicleType;
    private final String color;
    private final int odometer;
    private final double price;
    private final boolean sold;


    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price, boolean sold) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
        this.sold = sold;
    }

    public Vehicle() {
        this.vin = 0;
        this.year = 0;
        this.make = "";
        this.model = "";
        this.vehicleType = "";
        this.color = "";
        this.odometer = 0;
        this.price = 0;
        this.sold = false;
    }



    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }


    public String getModel() {
        return model;
    }


    public String getVehicleType() {
        return vehicleType;
    }


    public String getColor() {
        return color;
    }


    public int getOdometer() {
        return odometer;
    }


    public double getPrice() {
        return price;
    }


    public String toString(){
        return String.format("VIN: %-10d | Year: %-5d | Make: %-8s | Model: %-10s | Type: %-8s | Color: %-8s | Odometer: %-10d | Price: %.2f",
                vin, year, make, model, vehicleType, color, odometer, price);
    }

    public String toStringForVehicleFile(){
        return String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\n",
                vin, year, make, model, vehicleType, color, odometer, price);
    }



}


