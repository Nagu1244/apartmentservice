package com.msrs.apartmentservice.repository;

import com.msrs.apartmentservice.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
