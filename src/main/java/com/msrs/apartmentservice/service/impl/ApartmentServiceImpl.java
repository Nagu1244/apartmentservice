package com.msrs.apartmentservice.service.impl;

import com.msrs.apartmentservice.dtos.ApartmentDtoResponse;
import com.msrs.apartmentservice.exceptions.ApartmentNotFoundException;
import com.msrs.apartmentservice.model.Apartment;
import com.msrs.apartmentservice.repository.ApartmentRepository;
import com.msrs.apartmentservice.service.ApartmentService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

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
    public Apartment updateApartmentDetails(Apartment apartment, Long apartmentId) {
            Apartment apartmentExistingDetails = apartmentRepository.findById(apartmentId).orElseThrow(() -> new ApartmentNotFoundException("Apartment ID " + apartmentId + " not found"));
            if (apartmentExistingDetails != null) {
                apartmentExistingDetails.setFloorNumber(apartment.getFloorNumber() == null ? apartmentExistingDetails.getFloorNumber():apartment.getFloorNumber());
                apartmentExistingDetails.setBlockNumber(apartment.getBlockNumber() == null ? apartmentExistingDetails.getBlockNumber():apartment.getBlockNumber());
                apartmentExistingDetails.setFlatNumber(apartment.getFlatNumber() == null ? apartmentExistingDetails.getFlatNumber():apartment.getFlatNumber());
                apartmentExistingDetails.setFlatType(apartment.getFlatType() == null ? apartmentExistingDetails.getFlatType():apartment.getFlatType());
                apartmentExistingDetails.setNumOfWashRooms(Objects.equals(apartment.getNumOfWashRooms(),0) ? apartmentExistingDetails.getNumOfWashRooms():apartment.getNumOfWashRooms());
                //apartmentExistingDetails.setNumOfBathRooms(Objects.equals(apartment.getNumOfBathRooms(),0) ? apartmentExistingDetails.getNumOfBathRooms():apartment.getNumOfBathRooms());
                apartmentExistingDetails.setFlatRentPrice(Objects.equals(apartment.getFlatRentPrice(),null)? apartmentExistingDetails.getFlatRentPrice():apartment.getFlatRentPrice());
                apartmentExistingDetails.setAdvancePayment(Objects.equals(apartment.getAdvancePayment(), null)?apartmentExistingDetails.getAdvancePayment():apartment.getAdvancePayment());
                apartmentExistingDetails.setMaintenanceAmount(Objects.equals(apartment.getMaintenanceAmount(), null)?apartmentExistingDetails.getMaintenanceAmount():apartment.getMaintenanceAmount());
                apartmentExistingDetails.setFlatStatus(apartment.getFlatStatus() == null ? apartmentExistingDetails.getFlatStatus():apartment.getFlatStatus());
                apartmentExistingDetails = apartmentRepository.save(apartmentExistingDetails);
            }
        return apartmentExistingDetails;
    }

    @Override
    public Apartment getAllFlats(Long id) {
        Apartment apartment;
        //TO DO
        Optional<Apartment> flatList = apartmentRepository.findById(id);
        if (flatList.isPresent()) {
            apartment = flatList.get();
        } else {
            apartment = null;
        }
        return apartment;
    }
}
