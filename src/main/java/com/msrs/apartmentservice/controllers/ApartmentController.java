package com.msrs.apartmentservice.controllers;

import com.msrs.apartmentservice.dtos.ApartmentDtoResponse;
import com.msrs.apartmentservice.model.Apartment;
import com.msrs.apartmentservice.service.ApartmentService;
import com.msrs.apartmentservice.utils.CommonConstants;
import com.msrs.apartmentservice.utils.CustomResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(CommonConstants.APARTMENT_ENTRYPOINT)
@RestController
public class ApartmentController {
    public static final Logger LOG = LoggerFactory.getLogger(ApartmentController.class);
    @Autowired
    private ApartmentService apartmentService;

    @RequestMapping(value = "/addApartment", method = {RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public ResponseEntity<?> saveApartmentDetails(@RequestBody @Valid Apartment apartmentRequest) {
        ApartmentDtoResponse apartmentResponse = null;
            apartmentResponse = apartmentService.saveApartmentDetails(apartmentRequest);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(CustomResponse.successResponse("success", "flat details added", apartmentResponse));
    }

    @RequestMapping(value = "/updateApartment/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateApartmentDetails(@RequestBody Apartment apartment, @PathVariable(name = "id") Long apartmentId) {
        Apartment updatedInfo =apartmentService.updateApartmentDetails(apartment, apartmentId);
        return ResponseEntity.ok().build();
    }
}
