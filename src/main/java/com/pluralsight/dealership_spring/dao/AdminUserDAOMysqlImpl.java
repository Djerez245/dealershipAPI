package com.pluralsight.dealership_spring.dao;



import com.pluralsight.dealership_spring.model.Contract;
import com.pluralsight.dealership_spring.model.LeaseContract;
import com.pluralsight.dealership_spring.model.SalesContract;
import com.pluralsight.dealership_spring.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AdminUserDAOMysqlImpl implements AdminUserDAO {

    DataSource dataSource;

    @Autowired
    public AdminUserDAOMysqlImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void addSale(SalesContract salesContract) {
        try (Connection connection = dataSource.getConnection()) {

            PreparedStatement statement = connection.prepareStatement("""
                    INSERT INTO sales_contract VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                    """);
            statement.setString(1, salesContract.getDateOfContract());
            statement.setString(2, salesContract.getFirstName());
            statement.setString(3, salesContract.getLastName());
            statement.setString(4, salesContract.getCustomerEmail());
            statement.setInt(5, salesContract.getVehicleSold().getVin());
            statement.setInt(6, salesContract.getVehicleSold().getYear());
            statement.setString(7, salesContract.getVehicleSold().getMake());
            statement.setString(8, salesContract.getVehicleSold().getModel());
            statement.setString(9, salesContract.getVehicleSold().getVehicleType());
            statement.setString(10, salesContract.getVehicleSold().getColor());
            statement.setInt(11, salesContract.getVehicleSold().getOdometer());
            statement.setDouble(12, salesContract.getVehicleSold().getPrice());
            statement.setDouble(13, salesContract.getSalesTaxAmount());
            statement.setDouble(14, salesContract.getTotalPrice());
            statement.setDouble(15, salesContract.getProcessingFee());
            statement.setDouble(16, salesContract.getRecordingFee());
            statement.setBoolean(17, salesContract.isIfWantToFinance());
            statement.setDouble(18, salesContract.getMonthlyPayment());

            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + "rows inserted");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addLease(LeaseContract leaseContract) {

        try (Connection connection = dataSource.getConnection()) {

            PreparedStatement statement = connection.prepareStatement("""
                    INSERT INTO sales_contract VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )
                    """);
            statement.setString(1, leaseContract.getDateOfContract());
            statement.setString(2, leaseContract.getFirstName());
            statement.setString(3, leaseContract.getLastName());
            statement.setString(4, leaseContract.getCustomerEmail());
            statement.setInt(5, leaseContract.getVehicleSold().getVin());
            statement.setInt(6, leaseContract.getVehicleSold().getYear());
            statement.setString(7, leaseContract.getVehicleSold().getMake());
            statement.setString(8, leaseContract.getVehicleSold().getModel());
            statement.setString(9, leaseContract.getVehicleSold().getVehicleType());
            statement.setString(10, leaseContract.getVehicleSold().getColor());
            statement.setInt(11, leaseContract.getVehicleSold().getOdometer());
            statement.setDouble(12, leaseContract.getVehicleSold().getPrice());
            statement.setDouble(13, leaseContract.getExpectedEndingValue());
            statement.setDouble(14, leaseContract.getLeaseFee());
            statement.setDouble(15, leaseContract.getTotalPrice());
            statement.setDouble(16, leaseContract.getMonthlyPayment());

            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + "rows inserted");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SalesContract findSalesContractById(int id) {

        try(Connection connection = dataSource.getConnection()){

            PreparedStatement statement = connection.prepareStatement("""
                    SELECT *
                    FROM sales_contract
                    JOIN vehicles
                    ON sales_contract.vin = vehicles.vin
                    WHERE contract_id = ?;
                    """);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                String date = rs.getString("vehicle_date");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                int dealershipId = rs.getInt("dealership_id");
                int vin = rs.getInt("vin");
                int year = rs.getInt("year");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String type = rs.getString("type");
                String color = rs.getString("color");
                int odometer = rs.getInt("odometer");
                double price = rs.getDouble("price");
                boolean isSold = rs.getBoolean("sold");
                double taxAmount = rs.getDouble("salestax_amount");
                double totalPrice = rs.getDouble("total_price");
                double processingFee = rs.getDouble("processing_fee");
                double recordingFee = rs.getDouble("recording_fee");
                boolean financing = rs.getBoolean("finacing");
                double monthlyPayment = rs.getDouble("monthly_payment");

                Vehicle v = new Vehicle(dealershipId, vin, year, make, model, type, color, odometer, price, isSold);
                return new SalesContract(date, firstName, lastName, email, v, financing);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public LeaseContract findLeaseContractById(int id) {

        try(Connection connection = dataSource.getConnection()){

            PreparedStatement statement = connection.prepareStatement("""
                    SELECT *
                    FROM sales_contract
                    JOIN vehicles
                    ON sales_contract.vin = vehicles.vin
                    WHERE contract_id = ?;
                    """);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                String date = rs.getString("vehicle_date");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                int dealershipId = rs.getInt("dealership_id");
                int vin = rs.getInt("vin");
                int year = rs.getInt("year");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String type = rs.getString("type");
                String color = rs.getString("color");
                int odometer = rs.getInt("odometer");
                double price = rs.getDouble("price");
                boolean isSold = rs.getBoolean("sold");
                double taxAmount = rs.getDouble("expected_endingValue");
                double totalPrice = rs.getDouble("leasing_fee");
                double monthlyPayment = rs.getDouble("monthly_payment");

                Vehicle v = new Vehicle(dealershipId, vin, year, make, model, type, color, odometer, price, isSold);
                return new LeaseContract(date, firstName, lastName, email, v);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
