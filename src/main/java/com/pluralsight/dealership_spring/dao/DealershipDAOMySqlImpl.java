package com.pluralsight.dealership_spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.pluralsight.dealership_spring.model.Dealership;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DealershipDAOMySqlImpl implements DealershipDAO {

    DataSource dataSource;

    @Autowired
    public DealershipDAOMySqlImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Dealership findDealerShipById(int id){
        String businessName = "";
        String phone = "";
        String address = "";

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT *
                    FROM dealerships
                    WHERE id = ?;
                    """);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                id = rs.getInt("id");
                businessName = rs.getString("name");
                address = rs.getString("address");
                phone = rs.getString("phone");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new Dealership(id, businessName, phone, address);
    }

    @Override
    public List<Dealership> findAllDealerships() {
        List<Dealership> dealerships = new ArrayList<>();
        int id;
        String businessName;
        String phone;
        String address;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM dealerships;
                    """);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                id = rs.getInt("id");
                businessName = rs.getString("name");
                address = rs.getString("address");
                phone = rs.getString("phone");

                Dealership d = new Dealership(id, businessName, address, phone);
                dealerships.add(d);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return dealerships;
    }


}
