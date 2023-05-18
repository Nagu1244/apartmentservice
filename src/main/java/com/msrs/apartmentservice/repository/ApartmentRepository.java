package com.msrs.apartmentservice.repository;

import com.msrs.apartmentservice.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    Apartment findByFlatNumber(String flatNumber);
}
