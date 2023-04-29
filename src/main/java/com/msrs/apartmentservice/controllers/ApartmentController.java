package com.msrs.apartmentservice.controllers;

import com.msrs.apartmentservice.model.Apartment;
import com.msrs.apartmentservice.model.Flat;
import com.msrs.apartmentservice.services.ApartmentService;
import com.msrs.apartmentservice.utllities.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(CommonConstants.APARTMENT_ENTRYPOINT)
@RestController
public class ApartmentController {
    public static final Logger LOG = LoggerFactory.getLogger(ApartmentController.class);
    @Autowired
    private ApartmentService apartmentService;

    @RequestMapping(value = "/addApartment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Apartment saveApartmentDetails(@RequestBody Apartment apartment) {
        Apartment apartmentDetails = null;
        if (apartment != null) {
            apartmentDetails = apartmentService.saveApartmentDetails(apartment);
        } else {
            LOG.error("Apartment Details found as null");
        }
        return apartmentDetails;
    }

    @RequestMapping(value = "/updateApartment/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateApartmentDetails(@RequestBody Apartment apartment, @PathVariable(name = "id") Long apartmentId) {
        String updateInfo =apartmentService.updateApartmentDetails(apartment, apartmentId);
        return updateInfo;
    }

    @RequestMapping(value = "/getFlats", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Apartment getAllFlatDetails(@RequestParam(name = "id") Long id) {
        Apartment apartmentFlats = apartmentService.getAllFlats(id);
        return apartmentFlats;
    }
}
