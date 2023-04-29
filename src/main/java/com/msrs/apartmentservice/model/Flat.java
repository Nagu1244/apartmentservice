package com.msrs.apartmentservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flatId;
    private int florNumber;
    private String blockNumber;
    private String flatNumber;
    @ManyToOne
    @JoinColumn(name = "apartment_Id")
    private Apartment apartment;
    private String flatType;
    private String numberOfRooms;
    private int numOfBathRooms;
    private BigDecimal flatRentPrice;
    private int squareFeets;
    @OneToMany(mappedBy = "flat")
    private List<Member> members;
    boolean isFlatAvailable;
    String remarks;
}
