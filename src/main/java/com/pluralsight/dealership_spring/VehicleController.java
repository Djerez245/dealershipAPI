package com.pluralsight.dealership_spring;

import dao.VehiclesDAOMySqlImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pluralsight.Vehicle;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/vehicle")
public class VehicleController {
    private VehiclesDAOMySqlImpl vDao;


    @Autowired
    public VehicleController(VehiclesDAOMySqlImpl vDao) {
        this.vDao = vDao;
    }

    // Create

    // read
    @GetMapping
    public List<Vehicle> getAll(){
        return vDao.findAllVehicle();
    }

    // Delete
}
