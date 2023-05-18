package com.msrs.apartmentservice.controllers;

import com.msrs.apartmentservice.dtos.TenantDtoResponse;
import com.msrs.apartmentservice.model.Tenant;
import com.msrs.apartmentservice.service.TenantService;
import com.msrs.apartmentservice.utils.CommonConstants;
import com.msrs.apartmentservice.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CommonConstants.TENANT)
public class TenantController {
    @Autowired
    TenantService memberService;
    @RequestMapping(value = "/addTenant", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> assignApartmentToTenant(@RequestBody Tenant tenant, @RequestParam(name = "flatNumber") String flatNumber) {
        TenantDtoResponse response = memberService.assignApartment(tenant, flatNumber);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CustomResponse.successResponse("success", "Tenant Details added successfully", response));
    }
}
