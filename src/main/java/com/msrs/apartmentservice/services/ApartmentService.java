package com.msrs.apartmentservice.services;

import com.msrs.apartmentservice.model.Apartment;
import com.msrs.apartmentservice.model.Flat;
import com.msrs.apartmentservice.repository.ApartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApartmentService {
    private static final Logger LOG = LoggerFactory.getLogger(ApartmentService.class);
    @Autowired
    private ApartmentRepository apartmentRepository;

    public Apartment saveApartmentDetails(Apartment apartment) {
        Apartment apartmentDetails = null;
        try {
            apartmentDetails = apartmentRepository.save(apartment);
        } catch (Exception e) {
            LOG.error("FlatNumber {} details not saved", e.getMessage());
        }
        LOG.info("ApartmentDetails {} saved Successfully", apartmentDetails);
        return apartmentDetails;
    }

    public String updateApartmentDetails(Apartment apartment, Long apartmentId) {
       String details = null;
       Optional<Apartment> apartmentDetails = apartmentRepository.findById(apartmentId);
       if(apartmentDetails.isPresent()) {
           Apartment existingDetails = apartmentDetails.get();
           existingDetails.setApartmentOwner(apartment.getApartmentOwner());
           existingDetails.setContactNUmber(apartment.getContactNUmber());
           existingDetails.setApartmentName(apartment.getApartmentName());
           existingDetails.setAddress(apartment.getAddress());
           apartmentRepository.save(existingDetails);
           details = "Apartment Details with ID:"+apartmentId+" updated successfully";
           LOG.info("Apartment Details {} updated successfully", existingDetails);
       } else{
           details = "Apartment Details with ID:"+apartmentId+" not found";
       }
       return details;
    }

    public Apartment getAllFlats(Long id) {
        Apartment apartment;
        //TO DO
        Optional<Apartment> flatList = apartmentRepository.findById(id);
        if (flatList.isPresent()) {
            apartment = flatList.get();
        }
        else {
           apartment = null;
        }
        return apartment;
    }
}
