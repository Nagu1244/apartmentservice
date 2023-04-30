package com.msrs.apartmentservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Vehicle {
    @Id
    Long id;
    String vehicleNumber;
    String vehicleType;
    String vehicleName;
    String parkingNumber;
    @OneToOne
    @JoinColumn(name = "flat_Id")
    Flat flat;

    public Vehicle(Vehicle vehicle) {
        this.id = vehicle.id;
        this.vehicleNumber = vehicle.vehicleNumber;
        this.vehicleType = vehicle.vehicleType;
        this.vehicleName = vehicle.vehicleName;
        this.parkingNumber = vehicle.parkingNumber;
    }
}
