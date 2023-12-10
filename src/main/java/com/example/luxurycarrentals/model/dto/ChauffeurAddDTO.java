package com.example.luxurycarrentals.model.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class ChauffeurAddDTO {

    private Long id;
    @NotEmpty(message = "First Name must not be empty!")
    @Size(min = 2, max = 30, message = "First Name should be between 2 and 30 symbols.")
    private String name;
    @NotEmpty(message = "Surname must not be empty!")
    @Size(min = 2, max = 30, message = "Surname must be between 2 and 30 characters!")
    private String surname;
    @NotNull(message = "You should provide age!")
    @Min(value = 18, message = "Age must be over 18 years!")
    private Integer age;
    @NotEmpty(message = "You should choose a gender!")
    private String gender;
    @NotEmpty(message = "You should put an imageUrl here!")
    private String imageUrl;
    @NotNull(message = "You should provide an hourly rate!")
    private BigDecimal pricePerHour;



    public Long getId() {
        return id;
    }

    public ChauffeurAddDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ChauffeurAddDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public ChauffeurAddDTO setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public ChauffeurAddDTO setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public ChauffeurAddDTO setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ChauffeurAddDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public BigDecimal getPricePerHour() {
        return pricePerHour;
    }

    public ChauffeurAddDTO setPricePerHour(BigDecimal pricePerHour) {
        this.pricePerHour = pricePerHour;
        return this;
    }
}
