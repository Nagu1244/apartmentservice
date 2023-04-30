package com.msrs.apartmentservice.dtos;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.msrs.apartmentservice.model.Flat;
import org.hibernate.annotations.Comment;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapperService {
    public FlatResponseDto getFlatResponseDto(List<Flat> flatList) {
        FlatResponseDto flatResponseDto = new FlatResponseDto();
        BeanUtils.copyProperties(flatList, flatResponseDto);
        return flatResponseDto;
    }
}
