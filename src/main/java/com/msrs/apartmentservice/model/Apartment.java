package com.msrs.apartmentservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@Entity
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "floorNumber should not be null or empty")
    private String floorNumber;
    @NotBlank(message = "blockNumber should not be null or empty")
    private String blockNumber;
    @NotBlank(message = "flatNumber should not be empty or null")
    private String flatNumber;
    @NotBlank(message = "flatType should not be empty or null")
    private String flatType;
    @NotNull(message = "washRooms should not be null")
    private int numOfWashRooms;
    @NotNull(message = "flatRentPrice should not be null")
    private BigDecimal flatRentPrice;
    @NotNull(message = "advancePayment should not be null")
    private BigDecimal advancePayment;
    @NotNull(message = "please provide maintenance amount")
    private BigDecimal maintenanceAmount;
    @NotBlank(message = "flatStatus should not be null or empty")
    private String flatStatus;
    private boolean isForRent;
    private boolean isForSale;
}
