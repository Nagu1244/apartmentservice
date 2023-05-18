package com.msrs.apartmentservice.service;

import com.msrs.apartmentservice.dtos.TenantDtoResponse;
import com.msrs.apartmentservice.model.Tenant;
import com.msrs.apartmentservice.repository.ApartmentRepository;
import com.msrs.apartmentservice.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface TenantService {
    public TenantDtoResponse assignApartment(Tenant tenant, String flatNumber);
}
