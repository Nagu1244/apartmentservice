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
    @ManyToOne
    @JoinColumn(name = "member_id")
    Member members;
}
