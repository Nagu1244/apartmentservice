package com.msrs.apartmentservice.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@SecondaryTables({
        @SecondaryTable(name = "flat", pkJoinColumns = @PrimaryKeyJoinColumn(name = "apartment_id"))
})
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apartmentId;
    private String apartmentName;
    private String address;
    private String apartmentOwner;
    private String contactNUmber;
    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL)
    @Column(table = "flat")
    private List<Flat> flats;
}
