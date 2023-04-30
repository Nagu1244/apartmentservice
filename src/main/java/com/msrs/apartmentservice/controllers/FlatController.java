package com.msrs.apartmentservice.controllers;

import com.msrs.apartmentservice.model.Flat;
import com.msrs.apartmentservice.services.FlatService;
import com.msrs.apartmentservice.utils.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping(value = "/getFlats", method = RequestMethod.GET, produces = "application/json")
    public List<Flat> getAllFlats() {
        List<Flat> flatDtoResponse = flatService.getAllFlatDetails();
        return flatDtoResponse;
    }
}
