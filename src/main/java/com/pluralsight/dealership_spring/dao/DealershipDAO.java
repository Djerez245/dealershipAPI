package com.pluralsight.dealership_spring.dao;



import com.pluralsight.dealership_spring.model.Dealership;

import java.util.List;

public interface DealershipDAO {

    Dealership findDealerShipById(int id);
    List<Dealership> findAllDealerships();
}
