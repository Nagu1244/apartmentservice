package com.msrs.apartmentservice.service.impl;

import com.msrs.apartmentservice.dtos.TenantDtoResponse;
import com.msrs.apartmentservice.exceptions.FaltOccupiedException;
import com.msrs.apartmentservice.exceptions.FlatNumberNotFoundException;
import com.msrs.apartmentservice.model.Apartment;
import com.msrs.apartmentservice.model.Tenant;
import com.msrs.apartmentservice.repository.ApartmentRepository;
import com.msrs.apartmentservice.repository.TenantRepository;
import com.msrs.apartmentservice.service.TenantService;
import com.msrs.apartmentservice.utils.CommonConstants;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TenantServiceImpl implements TenantService {

    private static final Logger log = LoggerFactory.getLogger(TenantServiceImpl.class);
    @Autowired
    private TenantRepository tenantRepository;
    @Autowired
    private ApartmentRepository apartmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TenantDtoResponse assignApartment(Tenant tenant, String flatNumber) throws FaltOccupiedException {
        Apartment apartmentResponse = Optional.ofNullable(apartmentRepository.findByFlatNumber(flatNumber)).orElseThrow(() -> new FlatNumberNotFoundException("Flat Number not found:" + flatNumber));
        TenantDtoResponse tenantDtoResponse = null;
        if (apartmentResponse != null) {
            //don't assign flat to tenant if the flat is not Vacant
            if (StringUtils.isNotBlank(apartmentResponse.getFlatStatus()) && apartmentResponse.getFlatStatus().equals(CommonConstants.RoomStatus.VACANT.toString())) {
                apartmentResponse.setFlatStatus("Occupied");
                apartmentRepository.save(apartmentResponse);

                tenant.setApartment(apartmentResponse);
                tenant = tenantRepository.save(tenant);
            } else {
                log.warn("The flatnumber: {} you provided is: {}", flatNumber, apartmentResponse.getFlatStatus());
                throw new FaltOccupiedException("The flat Nubber you provided one is already booked");
            }

            tenantDtoResponse = modelMapper.map(tenant, TenantDtoResponse.class);
        }
        return tenantDtoResponse;
    }

    public TenantDtoResponse getTenantDetailsByFlatNumber(String flatNumber) {
        TenantDtoResponse tenantDtoResponse=null;
            Tenant response = tenantRepository.findByFlatNumber(flatNumber);
            if(response != null) {
                tenantDtoResponse = modelMapper.map(response, TenantDtoResponse.class);
            }
            else {
                log.error("flatNumber: {} not found", flatNumber);
                throw new FlatNumberNotFoundException("Entered flatNumber [" + flatNumber + "] is not found");
            }
            return tenantDtoResponse;
    }
}
