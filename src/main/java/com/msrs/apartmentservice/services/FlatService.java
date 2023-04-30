package com.msrs.apartmentservice.services;

import com.msrs.apartmentservice.dtos.MapperService;
import com.msrs.apartmentservice.model.Flat;
import com.msrs.apartmentservice.model.Member;
import com.msrs.apartmentservice.model.Vehicle;
import com.msrs.apartmentservice.repository.FlatRepository;
import com.msrs.apartmentservice.repository.MembersReposiory;
import com.msrs.apartmentservice.repository.VehicleRepository;
import org.apache.commons.collections4.ListUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FlatService {
    @Autowired
    private FlatRepository flatRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MapperService mapperService;
    @Autowired
    private MembersReposiory membersReposiory;
    @Autowired
    private VehicleRepository vehicleRepository;

    public Flat saveFlatDetail(Flat flat) {
        List<Member> member = Optional.ofNullable(flat.getMembers()).orElse(null);
        //Check whether member already exist
        List<Member> existingMembers = membersReposiory.findAll();
        if (existingMembers != null) {
            for (Member existingMember : existingMembers) {
                for (Member newMember : member) {
                    if (existingMember.equals(newMember)) {
                        membersReposiory.saveAll(member);
                    }
                    //To DO
                }
            }
        }
        Set<Vehicle> vehicle = flat.getVehicle();
        vehicleRepository.saveAll(vehicle);
        Flat flatDetails = flatRepository.save(flat);
        return flatDetails;
    }

    public List<Flat> getAllFlatDetails() {
        List<Flat> flatList = flatRepository.findAll();
        List<Flat> sortedList = ListUtils.emptyIfNull(flatList).stream().sorted(Comparator.comparing(Flat::getBlockNumber)).sorted(Comparator.comparing(Flat::getFlorNumber)).collect(Collectors.toList());
        return sortedList;
    }
}
