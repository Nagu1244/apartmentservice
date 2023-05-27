package com.msrs.apartmentservice.service;

import com.msrs.apartmentservice.dtos.ApartmentDtoResponse;
import com.msrs.apartmentservice.model.Apartment;
import jakarta.validation.Valid;

public interface ApartmentService {
    ApartmentDtoResponse saveApartmentDetails(@Valid Apartment request);
    Apartment updateApartmentDetails(Apartment apartment, Long apartmentId);
    Apartment getAllFlats(Long id);
}
