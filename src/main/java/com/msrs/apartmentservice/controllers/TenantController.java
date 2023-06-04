package com.msrs.apartmentservice.controllers;

import com.msrs.apartmentservice.dtos.TenantDtoResponse;
import com.msrs.apartmentservice.model.Tenant;
import com.msrs.apartmentservice.service.TenantService;
import com.msrs.apartmentservice.service.impl.TenantServiceImpl;
import com.msrs.apartmentservice.utils.CommonConstants;
import com.msrs.apartmentservice.utils.CustomResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CommonConstants.TENANT)
public class TenantController {
    @Autowired
    TenantService tenantService;

    @Autowired
    private TenantServiceImpl tenantServiceImpl;
    @RequestMapping(value = "/addTenant", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> assignApartmentToTenant(@RequestBody  @Valid Tenant tenant, @RequestParam(name = "flatNumber") String flatNumber) {
        TenantDtoResponse response = tenantService.assignApartment(tenant, flatNumber);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CustomResponse.successResponse("success", "Tenant Details added successfully", response));
    }

    @RequestMapping(value = "/getTenant/{flatNumber}")
    public ResponseEntity<TenantDtoResponse> getTenantDetailsByFlatNumber(@PathVariable(name = "flatNumber") String flatNumber) {
        TenantDtoResponse response = tenantServiceImpl.getTenantDetailsByFlatNumber(flatNumber);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }
}
