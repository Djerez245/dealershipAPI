package com.pluralsight.dealership_spring;

import com.pluralsight.dealership_spring.dao.AdminUserDAO;
import com.pluralsight.dealership_spring.model.LeaseContract;
import com.pluralsight.dealership_spring.model.SalesContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/vehicle/admin")
public class AdminController {
    private AdminUserDAO aDao;

    @Autowired
    public AdminController(AdminUserDAO aDao) {
        this.aDao = aDao;
    }

    @GetMapping("/sales/{id}")
    public List<SalesContract> searchForSalesContract(@RequestParam int id){
        return aDao.findSalesContractById(id);
    }

    @PostMapping("/addsales")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addSalesContract(@RequestBody SalesContract sc){
        aDao.addSale(sc);
    }

    @PostMapping("/addlease")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addLeaseContract(@RequestBody LeaseContract lc){
        aDao.addLease(lc);
    }

    @GetMapping("/lease/{id}")
    public List<LeaseContract> searchForLeaseContract(@RequestParam int id){
        return aDao.findLeaseContractById(id);
    }


}
