package com.msrs.apartmentservice.controllers;

import com.msrs.apartmentservice.model.Flat;
import com.msrs.apartmentservice.services.FlatService;
import com.msrs.apartmentservice.utllities.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CommonConstants.FLAT_ENTRYPOINT)
public class FlatController {
    @Autowired
    private FlatService flatService;

    @RequestMapping(value = "/addFlat", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Flat addFlatDetails(@RequestBody Flat flatDetails) {
        Flat flatInfo = flatService.saveFlatDetail(flatDetails);
        return flatInfo;
    }
}
