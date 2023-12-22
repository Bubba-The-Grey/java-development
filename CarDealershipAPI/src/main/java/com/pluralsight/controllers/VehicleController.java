package com.pluralsight.controllers;

import com.pluralsight.daos.DealershipDAO;
import com.pluralsight.daos.Sales_contractsDAO;
import com.pluralsight.daos.VehicleDAO;
import com.pluralsight.models.Dealership;
import com.pluralsight.models.Sales_contracts;
import com.pluralsight.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class VehicleController {
    private final VehicleDAO vehicleDAO;
    private final DealershipDAO dealershipDAO;
    private final Sales_contractsDAO salesContractsDAO;
    @Autowired
    public VehicleController(VehicleDAO vehicleDAO, DealershipDAO dealershipDAO, Sales_contractsDAO salesContractsDAO) {
        this.vehicleDAO = vehicleDAO;
        this.dealershipDAO = dealershipDAO;
        this.salesContractsDAO = salesContractsDAO;
    }

    @RequestMapping(path="/vehicles", method= RequestMethod.GET)
    public HashMap<Integer, Vehicle> allVehicles(){return vehicleDAO.getAll();}

    @RequestMapping(path="/vehicles/searchByPrice", method=RequestMethod.GET)
    public HashMap<Integer, Vehicle> searchByPrice(@RequestParam double min, @RequestParam double max){
        return vehicleDAO.searchByPrice(min, max);
    }

    @RequestMapping(path="/vehicles/searchByMake", method = RequestMethod.GET)
    public HashMap<Integer, Vehicle> searchByMake(@RequestParam String make){
        return vehicleDAO.searchByMake(make);
    }
    @RequestMapping(path="/vehicles/searchByModel", method = RequestMethod.GET)
    public HashMap<Integer, Vehicle> searchByModel(@RequestParam String model){
        return vehicleDAO.searchByModel(model);
    }
    @RequestMapping(path="/vehicles/searchByType", method = RequestMethod.GET)
    public HashMap<Integer, Vehicle> searchByType(@RequestParam String type){
        return vehicleDAO.searchByType(type);
    }
    @RequestMapping(path="/vehicles/searchByColor", method = RequestMethod.GET)
    public HashMap<Integer, Vehicle> searchByColor(@RequestParam String color){
        return vehicleDAO.searchByColor(color);
    }
    @RequestMapping(path="/vehicles/searchByYear", method = RequestMethod.GET)
    public HashMap<Integer, Vehicle> searchByYear(@RequestParam int minYear, @RequestParam int maxYear){
        return vehicleDAO.searchByYear(minYear, maxYear);
    }

    @RequestMapping(path="/vehicles/searchByMileage", method = RequestMethod.GET)
    public HashMap<Integer, Vehicle> searchByMake(@RequestParam int min, @RequestParam int max){
        return vehicleDAO.searchByMileage(min, max);
    }

    @RequestMapping(path="/vehicles/insert", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody Vehicle vehicle){
        vehicleDAO.add(vehicle);
    }
    @RequestMapping(path="/vehicles/delete", method = RequestMethod.GET)
    public void delete(@RequestParam int vin){
        vehicleDAO.delete(vin);
    }

    @RequestMapping(path="/vehicles/update", method = RequestMethod.GET)
    public void update(@RequestParam int vin, @RequestBody Vehicle vehicle){
        vehicleDAO.update(vin, vehicle);
    }
    @RequestMapping(path="/dealerships", method = RequestMethod.GET)
    public HashMap<Integer, Dealership> getAllDealerships(){
        return dealershipDAO.getAll();
    }
    @RequestMapping(path="/dealerships/{id}", method = RequestMethod.GET)
    public HashMap<Integer, Vehicle> getAllDealerships(@PathVariable int id){
        return dealershipDAO.getAllFromID(id);
    }
    @RequestMapping(path="/sales", method = RequestMethod.GET)
    public HashMap<Integer, Sales_contracts> getAllSales(){
        return salesContractsDAO.getAll();
    }
    @RequestMapping(path="/sales/add", method = RequestMethod.GET)
    public void addSale(@RequestBody Sales_contracts sale){
        salesContractsDAO.addSale(sale);
    }
}
