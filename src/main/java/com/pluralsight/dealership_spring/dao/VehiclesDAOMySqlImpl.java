package com.pluralsight.dealership_spring.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.pluralsight.dealership_spring.model.Vehicle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Component
public class VehiclesDAOMySqlImpl implements VehiclesDAO {

    private final DataSource dataSource;

    @Autowired
    public VehiclesDAOMySqlImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public ArrayList<Vehicle> findAllVehicle() {
        ArrayList<Vehicle> allVehicles = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;
        boolean sold;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles;
                    """);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                vin = rs.getInt("vin");
                year = rs.getInt("year");
                make = rs.getString("make");
                model = rs.getString("model");
                vehicleType = rs.getString("type");
                color = rs.getString("color");
                odometer = rs.getInt("odometer");
                price = rs.getDouble("price");
                sold = rs.getBoolean("sold");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);
                allVehicles.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allVehicles;
    }

    @Override
    public ArrayList<Vehicle> findVehicleByMake(String make) {
        ArrayList<Vehicle> vehicleByMake = new ArrayList<>();
        int vin;
        int year;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;
        boolean sold;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE make = ?;
                    """);

            statement.setString(1, make);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                vin = rs.getInt("vin");
                year = rs.getInt("year");
                make = rs.getString("make");
                model = rs.getString("com/pluralsight/dealership_spring/model");
                vehicleType = rs.getString("type");
                color = rs.getString("color");
                odometer = rs.getInt("odometer");
                price = rs.getDouble("price");
                sold = rs.getBoolean("sold");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);
                vehicleByMake.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleByMake;
    }

    @Override
    public ArrayList<Vehicle> findVehicleByModel(String model) {
        ArrayList<Vehicle> vehicleByModel = new ArrayList<>();
        int vin;
        int year;
        String make;
        String vehicleType;
        String color;
        int odometer;
        double price;
        boolean sold;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE model = ?;
                    """);

            statement.setString(1, model);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                vin = rs.getInt("vin");
                year = rs.getInt("year");
                make = rs.getString("make");
                model = rs.getString("com/pluralsight/dealership_spring/model");
                vehicleType = rs.getString("type");
                color = rs.getString("color");
                odometer = rs.getInt("odometer");
                price = rs.getDouble("price");
                sold = rs.getBoolean("sold");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);
                vehicleByModel.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleByModel;
    }

    @Override
    public ArrayList<Vehicle> findVehicleByColor(String color) {
        ArrayList<Vehicle> vehicleByColor = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        int odometer;
        double price;
        boolean sold;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE color = ?;
                    """);

            statement.setString(1, color);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                vin = rs.getInt("vin");
                year = rs.getInt("year");
                make = rs.getString("make");
                model = rs.getString("com/pluralsight/dealership_spring/model");
                vehicleType = rs.getString("type");
                color = rs.getString("color");
                odometer = rs.getInt("odometer");
                price = rs.getDouble("price");
                sold = rs.getBoolean("sold");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);
                vehicleByColor.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleByColor;
    }

    @Override
    public ArrayList<Vehicle> findVehicleByVin(int vin) {
        ArrayList<Vehicle> vehicleByVin = new ArrayList<>();
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;
        boolean sold;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE vin = ?;
                    """);

            statement.setInt(1, vin);
            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                vin = rs.getInt("vin");
                year = rs.getInt("year");
                make = rs.getString("make");
                model = rs.getString("com/pluralsight/dealership_spring/model");
                vehicleType = rs.getString("type");
                color = rs.getString("color");
                odometer = rs.getInt("odometer");
                price = rs.getDouble("price");
                sold = rs.getBoolean("sold");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);
                vehicleByVin.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleByVin;
    }

    @Override
    public ArrayList<Vehicle> findVehiclesByType(String vehicleType) {
        ArrayList<Vehicle> vehicleByType = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String color;
        int odometer;
        double price;
        boolean sold;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE type = ?;
                    """);

            statement.setString(1, vehicleType);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                vin = rs.getInt("vin");
                year = rs.getInt("year");
                make = rs.getString("make");
                model = rs.getString("com/pluralsight/dealership_spring/model");
                vehicleType = rs.getString("type");
                color = rs.getString("color");
                odometer = rs.getInt("odometer");
                price = rs.getDouble("price");
                sold = rs.getBoolean("sold");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);
                vehicleByType.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleByType;
    }

    @Override
    public ArrayList<Vehicle> findVehiclesByPriceRange(double minPrice, double maxPrice) {
        ArrayList<Vehicle> vehicleByPrice = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;
        boolean sold;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE price BETWEEN ? AND ?;
                    """);

            statement.setDouble(1, minPrice);
            statement.setDouble(2, maxPrice);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                vin = rs.getInt("vin");
                year = rs.getInt("year");
                make = rs.getString("make");
                model = rs.getString("com/pluralsight/dealership_spring/model");
                vehicleType = rs.getString("type");
                color = rs.getString("color");
                odometer = rs.getInt("odometer");
                price = rs.getDouble("price");
                sold = rs.getBoolean("sold");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);
                vehicleByPrice.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleByPrice;
    }

    @Override
    public ArrayList<Vehicle> findVehiclesByMileage(int minOdometer, int maxOdometer) {
        ArrayList<Vehicle> vehicleByMileage = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;
        boolean sold;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE odometer BETWEEN ? AND ?;
                    """);

            statement.setDouble(1, minOdometer);
            statement.setDouble(2, maxOdometer);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                vin = rs.getInt("vin");
                year = rs.getInt("year");
                make = rs.getString("make");
                model = rs.getString("com/pluralsight/dealership_spring/model");
                vehicleType = rs.getString("type");
                color = rs.getString("color");
                odometer = rs.getInt("odometer");
                price = rs.getDouble("price");
                sold = rs.getBoolean("sold");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);
                vehicleByMileage.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleByMileage;
    }

    @Override
    public ArrayList<Vehicle> findVehicleByYear(int year) {
        ArrayList<Vehicle> vehicleByYear = new ArrayList<>();
        int vin;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;
        boolean sold;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE year = ?;
                    """);

            statement.setInt(1, year);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                vin = rs.getInt("vin");
                year = rs.getInt("year");
                make = rs.getString("make");
                model = rs.getString("com/pluralsight/dealership_spring/model");
                vehicleType = rs.getString("type");
                color = rs.getString("color");
                odometer = rs.getInt("odometer");
                price = rs.getDouble("price");
                sold = rs.getBoolean("sold");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);
                vehicleByYear.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleByYear;
    }

    @Override
    public void addVehicle(Vehicle v){
        try (Connection connection = dataSource.getConnection()) {
            int vin = 0;
            int year = 0;
            String make = "";
            String model = "";
            String vehicleType = "";
            String color = "";
            int odometer = 0;
            double price = 0.0;
            boolean sold = false;

            PreparedStatement statement = connection.prepareStatement("""
                    INSERT INTO vehicles VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
                    """, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, vin);
            statement.setInt(2, year);
            statement.setString(3, make);
            statement.setString(4, model);
            statement.setString(5, vehicleType);
            statement.setString(6, color);
            statement.setInt(7, odometer);
            statement.setDouble(8, price);
            statement.setBoolean(9, sold);

            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + "rows inserted");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeVehicle(int vin) {

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    DELETE FROM vehicles WHERE vin = ?;
                    """);

            statement.setInt(1, vin);

            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + "rows affected");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
