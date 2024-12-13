package com.pluralsight.dealership_spring;

import com.pluralsight.dealership_spring.dao.VehiclesDAOMySqlImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.pluralsight.dealership_spring.model.Vehicle;

import java.util.List;

@RestController
@RequestMapping(path = "/vehicle")
public class VehicleController {
    private VehiclesDAOMySqlImpl vDao;


    @Autowired
    public VehicleController(VehiclesDAOMySqlImpl vDao) {
        this.vDao = vDao;
    }

    // read
    @GetMapping
    public List<Vehicle> getAll(){
        return vDao.findAllVehicle();
    }

    // Create
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Vehicle addVehicle(@RequestBody Vehicle vehicle){
        vDao.addVehicle(vehicle);
        return vehicle;
    }

    // Delete
    @RequestMapping(method = RequestMethod.DELETE,path = "/delete/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable(name = "id") Integer vin){
        vDao.removeVehicle(vin);
    }

    // Search for a vehicle with parameters
    @GetMapping("/search")
    public List<Vehicle> searchByAll(@RequestParam(required = false) String make,
                                     @RequestParam(required = false) String model,
                                     @RequestParam(required = false) String type,
                                     @RequestParam(required = false) String color,
                                     @RequestParam(required = false) Integer year,
                                     @RequestParam(required = false) Integer vin,
                                     @RequestParam(required = false) Double minPrice,
                                     @RequestParam(required = false) Double maxPrice,
                                     @RequestParam(required = false, defaultValue = "0") Integer minMileage,
                                     @RequestParam(required = false, defaultValue = "99999999") Integer maxMileage){
        List<Vehicle> vehicleList = vDao.findAllVehicle();
        return vehicleList.stream()
                .filter(vehicle -> vin == null || vin == vehicle.getVin())
                .filter(vehicle -> make == null || make.equalsIgnoreCase(vehicle.getMake()))
                .filter(vehicle -> model == null || model.equalsIgnoreCase(vehicle.getModel()))
                .filter(vehicle -> type == null || type.equalsIgnoreCase(vehicle.getVehicleType()))
                .filter(vehicle -> color == null || color.equalsIgnoreCase(vehicle.getColor()))
                .filter(vehicle -> year == null || year == vehicle.getYear())
                .filter(vehicle -> minPrice == null || minPrice <= vehicle.getPrice())
                .filter(vehicle -> maxPrice == null || maxPrice >= vehicle.getPrice())
                .filter(vehicle -> minMileage == null || minMileage <= vehicle.getOdometer())
                .filter(vehicle -> maxMileage == null || maxMileage >= vehicle.getOdometer()).toList();
    }

}
