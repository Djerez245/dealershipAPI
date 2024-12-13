package com.pluralsight.dealership_spring.dao;



import com.pluralsight.dealership_spring.model.Contract;
import com.pluralsight.dealership_spring.model.LeaseContract;
import com.pluralsight.dealership_spring.model.SalesContract;

import java.util.ArrayList;
import java.util.List;

public interface AdminUserDAO {
    void addSale(SalesContract salesContract);
    void addLease(LeaseContract leaseContract);
    ArrayList<SalesContract> findSalesContractById(int id);
    ArrayList<LeaseContract> findLeaseContractById(int id);
}
