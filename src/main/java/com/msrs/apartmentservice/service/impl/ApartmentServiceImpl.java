package com.msrs.apartmentservice.service.impl;

import com.msrs.apartmentservice.dtos.ApartmentDtoResponse;
import com.msrs.apartmentservice.dtos.TenantDtoResponse;
import com.msrs.apartmentservice.exceptions.ApartmentNotFoundException;
import com.msrs.apartmentservice.model.Apartment;
import com.msrs.apartmentservice.model.Tenant;
import com.msrs.apartmentservice.repository.ApartmentRepository;
import com.msrs.apartmentservice.service.ApartmentService;
import org.apache.commons.collections4.ListUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private static final Logger LOG = LoggerFactory.getLogger(ApartmentService.class);
    @Autowired
    private ApartmentRepository apartmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ApartmentDtoResponse saveApartmentDetails(Apartment apartment) {
        Apartment apartmentDetails = null;
        ApartmentDtoResponse apartmentResponse = null;
        try {
            apartmentDetails = apartmentRepository.save(apartment);
            apartmentResponse = modelMapper.map(apartmentDetails, ApartmentDtoResponse.class);
            LOG.debug("apartment response received as : {}", apartmentDetails);
        } catch (Exception e) {
            LOG.error("FlatNumber {} details not saved", e.getMessage());
        }
        LOG.info("ApartmentDetails {} saved Successfully", apartmentDetails);
        return apartmentResponse;
    }

    @Override
    public void updateApartmentDetails(Apartment apartment, Long apartmentId) {
        Apartment updateExistingDetails = apartmentRepository.findById(apartmentId).orElseThrow(() -> new ApartmentNotFoundException("Apartment ID " + apartmentId + " not found"));
        if (updateExistingDetails != null) {
            try {
                updateExistingDetails.setFloorNumber(apartment.getFloorNumber());
                updateExistingDetails.setBlockNumber(apartment.getBlockNumber());
                updateExistingDetails.setFlatNumber(apartment.getFlatNumber());
                updateExistingDetails.setFlatType(apartment.getFlatType());
                updateExistingDetails.setNumOfWashRooms(apartment.getNumOfWashRooms());
                updateExistingDetails.setFlatRentPrice(apartment.getFlatRentPrice());
                updateExistingDetails.setAdvancePayment(apartment.getAdvancePayment());
                updateExistingDetails.setMaintenanceAmount(apartment.getMaintenanceAmount());
                updateExistingDetails.setFlatStatus(apartment.getFlatStatus());
                apartmentRepository.save(updateExistingDetails);
                LOG.info("Apartment details updated successfully");
            } catch (Exception ex) {
                throw new IllegalArgumentException("Something went wrong while updated apartment details");
            }

        }
    }

    @Override
    public List<ApartmentDtoResponse> getListApartments() {
        List<ApartmentDtoResponse> dtoResponseList = new ArrayList<>();
        try {
            List<Apartment> apartmentList = apartmentRepository.findAll();
            apartmentList = ListUtils.emptyIfNull(apartmentList.stream().
                    filter(Objects::nonNull).sorted(Comparator.comparing(Apartment::getBlockNumber)
                            .thenComparing(Comparator.comparing(Apartment::getFloorNumber)
                            .thenComparing(Comparator.comparing(Apartment::getFlatNumber)))).collect(Collectors.toList()));
            if (apartmentList != null) {
                for (Apartment list : apartmentList) {
                    ApartmentDtoResponse apartmentDtoResponse = modelMapper.map(list, ApartmentDtoResponse.class);
                    dtoResponseList.add(apartmentDtoResponse);
                }
            } else {
                LOG.error("records founded as :{}", apartmentList);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("opps!! Something went wrong while fetching apartment details");
        }
        return dtoResponseList;
    }

   /* public TenantDtoResponse getTenantDetailsByFlatNumber(String flatNumber) {
        Tenant response = apartmentRepository.findByFlatNumber(flatNumber);
        TenantDtoResponse tenantDtoResponse = modelMapper.map(response, TenantDtoResponse.class);
        return tenantDtoResponse;
    }*/
}
