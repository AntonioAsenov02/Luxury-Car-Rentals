package com.example.luxurycarrentals.model.dto;

import java.math.BigDecimal;

public class CarDetailsDTO {

    private String brand;
    private String model;
    private BigDecimal pricePerHour;
    private BigDecimal pricePerDay;
    private BigDecimal pricePerMonth;
    private String imageUrl;



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
}
