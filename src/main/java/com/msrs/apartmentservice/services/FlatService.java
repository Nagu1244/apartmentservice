package com.msrs.apartmentservice.services;

import com.msrs.apartmentservice.model.Flat;
import com.msrs.apartmentservice.repository.FlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlatService {
    @Autowired
    private FlatRepository flatRepository;
    public Flat saveFlatDetail(Flat flat) {
        Flat flatDetails = flatRepository.save(flat);
        return flatDetails;
    }
}
