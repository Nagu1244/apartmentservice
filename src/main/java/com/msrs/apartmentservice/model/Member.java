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
public class Member {
    @Id
    int memberId;
    String fullName;
    @JsonFormat(pattern = "dd-mm-yyyy")
    Date DOB;
    String mobileNumber;
    String aadharNumber;
    String panCardNumber;
    int numberOfMemberStaying;
    @ManyToOne
    @JoinColumn(name = "flat_Id")
    Flat flat;
    public Member(Member members) {
        this.memberId = members.memberId;
        this.fullName = members.fullName;
        this.DOB = members.DOB;
        this.mobileNumber = members.mobileNumber;
        this.panCardNumber = members.panCardNumber;
        this.aadharNumber = members.aadharNumber;
        this.numberOfMemberStaying = members.numberOfMemberStaying;
        this.flat = members.flat;
    }
}

