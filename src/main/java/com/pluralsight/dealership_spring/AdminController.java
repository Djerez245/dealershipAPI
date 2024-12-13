package com.pluralsight.dealership_spring;

import com.pluralsight.dealership_spring.dao.AdminUserDAO;
import com.pluralsight.dealership_spring.model.SalesContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}
