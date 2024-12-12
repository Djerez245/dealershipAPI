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
    @RequestMapping(method = RequestMethod.PUT, path = "/addvehicle")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Vehicle addVehicle(@RequestBody Vehicle vehicle){
        vDao.addVehicle(vehicle);
        return vehicle;
    }

    // Delete
    @RequestMapping(method = RequestMethod.DELETE,path = "/deleteid/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable(name = "id") Integer vin){
        vDao.removeVehicle(vin);
    }

    // Search for a vehicle with parameters
    // TODO results come up blank
    @GetMapping(path = "/search/vin/{vin}")
    public List<Vehicle> searchByVin(@PathVariable(name = "id") Integer vin){
        return vDao.findVehicleByVin(vin);
    }

    @GetMapping(path = "/search/{make}")
    public List<Vehicle> searchByMake(@PathVariable(name = "make") String make){
        return vDao.findVehicleByMake(make);
    }

    @GetMapping(path = "/search/{model}")
    public List<Vehicle> searchByModel(@PathVariable(name = "model") String model){
        return vDao.findVehicleByModel(model);
    }

    @GetMapping(path = "/search/{type}")
    public List<Vehicle> searchByType(@PathVariable(name = "type") String type){
        return vDao.findVehiclesByType(type);
    }

    @GetMapping(path = "/search/{color}")
    public List<Vehicle> searchByColor(@PathVariable(name = "color") String color){
        return vDao.findVehiclesByType(color);
    }

    @GetMapping(path = "/search/{year}")
    public List<Vehicle> searchByYear(@PathVariable(name = "year") Integer year){
        return vDao.findVehicleByYear(year);
    }

    @GetMapping(path = "/search/price")
    public List<Vehicle> searchByPrice(@RequestParam(value = "minPrice") Double minPrice, @RequestParam(value = "maxPrice") Double maxPrice){
        return vDao.findVehiclesByPriceRange(minPrice, maxPrice);
    }

    @GetMapping(path = "/search/mileage")
    public List<Vehicle> searchByMileage(@RequestParam(value = "minMileage") Integer minMileage, @RequestParam(value = "maxMileage") Integer maxMileage){
        return vDao.findVehiclesByMileage(minMileage, maxMileage);
    }



}
