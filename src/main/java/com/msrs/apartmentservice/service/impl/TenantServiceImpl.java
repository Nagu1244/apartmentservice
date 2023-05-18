package com.msrs.apartmentservice.service.impl;

import com.msrs.apartmentservice.dtos.TenantDtoResponse;
import com.msrs.apartmentservice.exceptions.FlatNumberNotFoundException;
import com.msrs.apartmentservice.model.Apartment;
import com.msrs.apartmentservice.model.Tenant;
import com.msrs.apartmentservice.repository.ApartmentRepository;
import com.msrs.apartmentservice.repository.TenantRepository;
import com.msrs.apartmentservice.service.TenantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantRepository tenantRepository;
    @Autowired
    private ApartmentRepository apartmentRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public TenantDtoResponse assignApartment(Tenant tenant, String flatNumber) {
        Apartment apartmentResponse = Optional.ofNullable(apartmentRepository.findByFlatNumber(flatNumber)).orElseThrow(() -> new FlatNumberNotFoundException("Flat Number not found:" + flatNumber));
        TenantDtoResponse tenantDtoResponse = null;
        if (apartmentResponse != null) {
            //TODO make flat is non available if the flat is already occupied
            apartmentResponse.setFlatStatus("Occupied");
            apartmentRepository.save(apartmentResponse);

            tenant.setApartment(apartmentResponse);
            Tenant tenantResponse = tenantRepository.save(tenant);
            tenantDtoResponse = modelMapper.map(tenantResponse, TenantDtoResponse.class);
        }
        return tenantDtoResponse;
    }
}
