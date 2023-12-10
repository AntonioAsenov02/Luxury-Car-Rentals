package com.example.luxurycarrentals.model.dto;

import com.example.luxurycarrentals.model.enums.FuelEnum;
import com.example.luxurycarrentals.model.enums.TransmissionEnum;

import java.math.BigDecimal;

public class CarDetailsDTO {

    private Long id;
    private String brand;
    private String model;
    private String description;
    private BigDecimal pricePerHour;
    private BigDecimal pricePerDay;
    private BigDecimal pricePerMonth;
    private String imageUrl;
    private Integer rating;
    private TransmissionEnum transmission;
    private Integer mileage;
    private Integer seats;
    private Integer luggageCapacity;
    private FuelEnum fuel;


    public Long getId() {
        return id;
    }

    public CarDetailsDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CarDetailsDTO setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarDetailsDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CarDetailsDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPricePerHour() {
        return pricePerHour;
    }

    public CarDetailsDTO setPricePerHour(BigDecimal pricePerHour) {
        this.pricePerHour = pricePerHour;
        return this;
    }

    public BigDecimal getPricePerDay() {
        return pricePerDay;
    }

    public CarDetailsDTO setPricePerDay(BigDecimal pricePerDay) {
        this.pricePerDay = pricePerDay;
        return this;
    }

    public BigDecimal getPricePerMonth() {
        return pricePerMonth;
    }

    public CarDetailsDTO setPricePerMonth(BigDecimal pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CarDetailsDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getRating() {
        return rating;
    }

    public CarDetailsDTO setRating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public CarDetailsDTO setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public CarDetailsDTO setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public Integer getSeats() {
        return seats;
    }

    public CarDetailsDTO setSeats(Integer seats) {
        this.seats = seats;
        return this;
    }

    public Integer getLuggageCapacity() {
        return luggageCapacity;
    }

    public CarDetailsDTO setLuggageCapacity(Integer luggageCapacity) {
        this.luggageCapacity = luggageCapacity;
        return this;
    }

    public FuelEnum getFuel() {
        return fuel;
    }

    public CarDetailsDTO setFuel(FuelEnum fuel) {
        this.fuel = fuel;
        return this;
    }
}
