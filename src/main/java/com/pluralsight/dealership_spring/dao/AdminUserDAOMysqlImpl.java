package com.pluralsight.dealership_spring.dao;



import com.pluralsight.dealership_spring.model.LeaseContract;
import com.pluralsight.dealership_spring.model.SalesContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminUserDAOMysqlImpl implements AdminUserDAO {

    DataSource dataSource;
    LeaseContract lc;
    SalesContract sc;

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
}
