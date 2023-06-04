package com.msrs.apartmentservice.dtos;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
