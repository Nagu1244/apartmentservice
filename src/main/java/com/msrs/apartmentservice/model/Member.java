package com.msrs.apartmentservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Member {
    @Id
    int memberId;
    String fullName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    Date DOB;
    String mobileNumber;
    String aadharNumber;
    String panCardNumber;
    int numberOfMemberStaying;
    @ManyToOne
    @JoinColumn(name = "flat_id")
    Flat flat;
    @OneToMany(mappedBy = "members")
    Set<Vehicle> vehicles;
}

