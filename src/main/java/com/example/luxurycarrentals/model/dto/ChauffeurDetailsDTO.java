package com.example.luxurycarrentals.model.dto;

import java.math.BigDecimal;

public class ChauffeurDetailsDTO {

    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String gender;
    private Integer rating;
    private String imageUrl;
    private BigDecimal pricePerHour;



    public Long getId() {
        return id;
    }

    public ChauffeurDetailsDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }


    public ChauffeurDetailsDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public ChauffeurDetailsDTO setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public ChauffeurDetailsDTO setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public ChauffeurDetailsDTO setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Integer getRating() {
        return rating;
    }

    public ChauffeurDetailsDTO setRating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ChauffeurDetailsDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public BigDecimal getPricePerHour() {
        return pricePerHour;
    }

    public ChauffeurDetailsDTO setPricePerHour(BigDecimal pricePerHour) {
        this.pricePerHour = pricePerHour;
        return this;
    }
}
