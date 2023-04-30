package com.msrs.apartmentservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flat_id")
    private Long flatId;
    private int florNumber;
    private String blockNumber;
    private String flatNumber;
    @ManyToOne
    @JoinColumn(name = "apartment_id", referencedColumnName = "apartmentId")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Apartment apartment;
    private String flatType;
    private String numberOfRooms;
    private int numOfBathRooms;
    private BigDecimal flatRentPrice;
    private int squareFeets;
    @OneToMany(mappedBy = "flat")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Member> members;
    @OneToMany(mappedBy = "flat")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Set<Vehicle> vehicle;
    boolean isFlatAvailable;
    String remarks;
}
