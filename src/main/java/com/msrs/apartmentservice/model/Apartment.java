package com.msrs.apartmentservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String floorNumber;
    private String blockNumber;
    private String flatNumber;
    private String flatType;
    private int numOfWashRooms;
    private BigDecimal flatRentPrice;
    private BigDecimal advancePayment;
    private BigDecimal maintenanceAmount;
    private String flatStatus;
    private boolean isForRent;
    private boolean isForSale;
}
