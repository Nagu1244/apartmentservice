package com.msrs.apartmentservice.service;

import com.msrs.apartmentservice.dtos.ApartmentDtoResponse;
import com.msrs.apartmentservice.model.Apartment;
import jakarta.validation.Valid;

import java.util.List;

public interface ApartmentService {
    ApartmentDtoResponse saveApartmentDetails(@Valid Apartment request);
    void updateApartmentDetails(Apartment apartment, Long apartmentId);
    List<ApartmentDtoResponse> getListApartments();
}
