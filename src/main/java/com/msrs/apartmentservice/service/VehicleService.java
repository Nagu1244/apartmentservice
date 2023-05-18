package com.msrs.apartmentservice.service;

import com.msrs.apartmentservice.model.Vehicle;
import com.msrs.apartmentservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    public Vehicle addVehicle(Vehicle vehicle) {
        Vehicle vehicleInfo = vehicleRepository.save(vehicle);
        return vehicleInfo;
    }
}
