package dao;


import pluralsight.LeaseContract;
import pluralsight.SalesContract;

public interface AdminUserDAO {
    void addSale(SalesContract salesContract);
    void addLease(LeaseContract leaseContract);
}
