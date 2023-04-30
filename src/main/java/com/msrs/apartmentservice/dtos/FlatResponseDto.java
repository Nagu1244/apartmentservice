package com.msrs.apartmentservice.dtos;

import java.math.BigDecimal;

public class FlatResponseDto {
    private int florNumber;
    private String blockNumber;
    private String flatNumber;
    private String flatType;
    private String numberOfRooms;
    private int numOfBathRooms;
    private BigDecimal flatRentPrice;
    private int squareFeets;
    boolean isFlatAvailable;
    String remarks;

    public int getFlorNumber() {
        return florNumber;
    }

    public void setFlorNumber(int florNumber) {
        this.florNumber = florNumber;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getFlatType() {
        return flatType;
    }

    public void setFlatType(String flatType) {
        this.flatType = flatType;
    }

    public String getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumOfBathRooms() {
        return numOfBathRooms;
    }

    public void setNumOfBathRooms(int numOfBathRooms) {
        this.numOfBathRooms = numOfBathRooms;
    }

    public BigDecimal getFlatRentPrice() {
        return flatRentPrice;
    }

    public void setFlatRentPrice(BigDecimal flatRentPrice) {
        this.flatRentPrice = flatRentPrice;
    }

    public int getSquareFeets() {
        return squareFeets;
    }

    public void setSquareFeets(int squareFeets) {
        this.squareFeets = squareFeets;
    }

    public boolean isFlatAvailable() {
        return isFlatAvailable;
    }

    public void setFlatAvailable(boolean flatAvailable) {
        isFlatAvailable = flatAvailable;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
