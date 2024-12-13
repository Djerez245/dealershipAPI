package com.pluralsight.dealership_spring.dao;



import com.pluralsight.dealership_spring.model.LeaseContract;
import com.pluralsight.dealership_spring.model.SalesContract;

import java.util.List;

public interface AdminUserDAO {
    void addSale(SalesContract salesContract);
    void addLease(LeaseContract leaseContract);
    SalesContract findSalesContractById(int id);
    LeaseContract findLeaseContractById(int id);
}
