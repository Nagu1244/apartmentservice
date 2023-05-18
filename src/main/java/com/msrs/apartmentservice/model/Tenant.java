package com.msrs.apartmentservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int memberId;
    String tenantName;
    @JsonFormat(pattern = "dd-mm-yyyy")
    Date DOB;
    @JsonFormat(pattern = "dd-mm-yyyy")
    Date tenantInDate;
    String email;
    String mobileNumber;
    String aadharNumber;
    String panCardNumber;
    int totalMembers;
    String permanentAddress;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Apartment.class)
    @JoinColumn(name = "apartmentId_fk")
    private Apartment apartment;
}

