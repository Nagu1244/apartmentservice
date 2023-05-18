package com.msrs.apartmentservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApartmentDtoResponse {
    private String floorNumber;
    private String blockNumber;
    private String flatNumber;
    private String flatType;
    private int numOfWashRooms;
    private BigDecimal flatRentPrice;
    private BigDecimal advancePayment;
    private BigDecimal maintenanceAmount;
    String flatStatus;
}
