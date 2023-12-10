package com.example.luxurycarrentals.model.dto;

import com.example.luxurycarrentals.model.enums.FuelEnum;
import com.example.luxurycarrentals.model.enums.TransmissionEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class CarAddDTO {

    private Long id;
    @NotEmpty(message = "You should provide a brand!")
    @Size(min = 2, max = 30, message = "Brand name should be between 2 and 30 characters!")
    private String brand;
    @NotEmpty(message = "You should provide a model!")
    @Size(min = 2, max = 30, message = "Model name should be between 2 and 30 characters!")
    private String model;
    @NotNull(message = "You should provide a year!")
    private Integer year;
    @NotEmpty(message = "You should provide a short description!")
    @Size(min = 50, message = "Description must be at least 50 characters!")
    private String description;
    @NotNull(message = "Choose a transmission type!")
    private TransmissionEnum transmission;
    @NotNull(message = "Choose fuel type!")
    private FuelEnum fuel;
    @NotEmpty(message = "You should put an imageUrl here!")
    private String imageUrl;
    @NotNull(message = "You should provide mileage in kilometers!")
    private Integer mileage;
    @NotNull(message = "You should provide number of seats!")
    @Min(value = 2, message = "Number of seats must be at least 2!")
    private Integer seats;
    @NotNull(message = "You should provide number of bags that can fit in the car!")
    private Integer luggageCapacity;
    @NotNull(message = "You should provide price for hourly rent!")
    private BigDecimal perHourPrice;
    @NotNull(message = "You should provide price for daily rent!")
    private BigDecimal perDayPrice;
    @NotNull(message = "You should provide price for monthly rent!")
    private BigDecimal perMonthPrice;



    public Long getId() {
        return id;
    }

    public CarAddDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CarAddDTO setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarAddDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public CarAddDTO setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CarAddDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public CarAddDTO setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public FuelEnum getFuel() {
        return fuel;
    }

    public CarAddDTO setFuel(FuelEnum fuel) {
        this.fuel = fuel;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CarAddDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public CarAddDTO setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public Integer getSeats() {
        return seats;
    }

    public CarAddDTO setSeats(Integer seats) {
        this.seats = seats;
        return this;
    }

    public Integer getLuggageCapacity() {
        return luggageCapacity;
    }

    public CarAddDTO setLuggageCapacity(Integer luggageCapacity) {
        this.luggageCapacity = luggageCapacity;
        return this;
    }

    public BigDecimal getPerHourPrice() {
        return perHourPrice;
    }

    public CarAddDTO setPerHourPrice(BigDecimal perHourPrice) {
        this.perHourPrice = perHourPrice;
        return this;
    }

    public BigDecimal getPerDayPrice() {
        return perDayPrice;
    }

    public CarAddDTO setPerDayPrice(BigDecimal perDayPrice) {
        this.perDayPrice = perDayPrice;
        return this;
    }

    public BigDecimal getPerMonthPrice() {
        return perMonthPrice;
    }

    public CarAddDTO setPerMonthPrice(BigDecimal perMonthPrice) {
        this.perMonthPrice = perMonthPrice;
        return this;
    }
}
