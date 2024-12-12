package dao;



import pluralsight.Dealership;

import java.util.List;

public interface DealershipDAO {

    Dealership findDealerShipById(int id);
    List<Dealership> findAllDealerships();
}
