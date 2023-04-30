package com.msrs.apartmentservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
//@SecondaryTables({
//        @SecondaryTable(name = "flat", pkJoinColumns = @PrimaryKeyJoinColumn(name = "apartment_id"))
//})
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apartmentId;
    private String apartmentName;
    private String address;
    private String apartmentOwner;
    private String contactNUmber;
    @OneToMany(mappedBy = "apartment")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Flat> flats;
}
