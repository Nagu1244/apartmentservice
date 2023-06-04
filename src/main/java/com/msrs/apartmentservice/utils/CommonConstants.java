package com.msrs.apartmentservice.utils;

public interface CommonConstants {
    public static final String APARTMENT = "/apartment";
    public static final String FLAT_ENTRYPOINT = "/apartment/flat";
    public static final String TENANT = "/apartment/tenant";
    public static final String VEHICLE = "/flat/vehicle";
    public static final String USER = "/user/";
    enum RoomStatus {
        VACANT("Vacant"),
        OCCUPIED("Occupied");
        public String status;
        RoomStatus(String message) {
            status = message;
        }
    }
}
