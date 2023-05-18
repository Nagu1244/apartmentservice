package com.msrs.apartmentservice.service;

import com.msrs.apartmentservice.dtos.ApartmentDtoResponse;
import com.msrs.apartmentservice.model.Apartment;

public interface ApartmentService {
    ApartmentDtoResponse saveApartmentDetails(Apartment apartment);
    Apartment updateApartmentDetails(Apartment apartment, Long apartmentId);
    Apartment getAllFlats(Long id);
}
