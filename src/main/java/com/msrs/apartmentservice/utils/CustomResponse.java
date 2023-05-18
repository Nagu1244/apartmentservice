package com.msrs.apartmentservice.utils;

import com.msrs.apartmentservice.dtos.FailResponse;
import com.msrs.apartmentservice.dtos.SuccessResponse;

public class CustomResponse {
    public static SuccessResponse successResponse(String status,String message, Object data) {
        return new SuccessResponse(status,message, data);
    }
    public static FailResponse failResponse(String message){
        return new FailResponse(message);
    }
}
