package com.msrs.apartmentservice.controllers;

import com.msrs.apartmentservice.model.Vehicle;
import com.msrs.apartmentservice.services.VehicleService;
import com.msrs.apartmentservice.utllities.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CommonConstants.VEHICLE)
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value = "/addVehicle", method = RequestMethod.POST, consumes = "application/json")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle){
        Vehicle vehicleInfo = vehicleService.addVehicle(vehicle);
        return vehicleInfo;
    }
}
