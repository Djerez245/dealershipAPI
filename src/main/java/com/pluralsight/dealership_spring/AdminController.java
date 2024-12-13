package com.pluralsight.dealership_spring;

import com.pluralsight.dealership_spring.dao.AdminUserDAO;
import com.pluralsight.dealership_spring.model.LeaseContract;
import com.pluralsight.dealership_spring.model.SalesContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {
    private AdminUserDAO aDao;

    @Autowired
    public AdminController(AdminUserDAO aDao) {
        this.aDao = aDao;
    }

    @GetMapping("/{id}")
    public List<SalesContract> searchForSalesContract(@RequestParam int id){
        return aDao.findSalesContractById(id);
    }

    @GetMapping("/addsales")
    public void addSalesContract(@RequestBody SalesContract sc){
        aDao.addSale(sc);
    }

    @GetMapping("/addlease")
    public void addLeaseContract(@RequestBody LeaseContract lc){
        aDao.addLease(lc);
    }

    @GetMapping("/{id}")
    public List<LeaseContract> searchForLeaseContract(@RequestParam int id){
        return aDao.findLeaseContractById(id);
    }


}
