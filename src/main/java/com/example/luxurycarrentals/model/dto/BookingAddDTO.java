package com.example.luxurycarrentals.model.dto;

import com.example.luxurycarrentals.model.entity.Car;
import com.example.luxurycarrentals.model.entity.Chauffeur;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class BookingAddDTO {

    private Long id;
    @NotEmpty(message = "You must set a pick-up Location")
    private String pickUpLocation;
    @NotEmpty(message = "You must set a drop-off Location")
    private String dropOffLocation;
    @NotNull(message = "You should select a pick-up Date")
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime pickUpDate;
    @NotNull(message = "You should select a drop-off Date")
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dropOffDate;
    @NotNull(message = "You should select a Car!")
    private Car car;
    private Chauffeur chauffeur;



    public Long getId() {
        return id;
    }

    public BookingAddDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public BookingAddDTO setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
        return this;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public BookingAddDTO setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
        return this;
    }

    public LocalDateTime getPickUpDate() {
        return pickUpDate;
    }

    public BookingAddDTO setPickUpDate(LocalDateTime pickUpDate) {
        this.pickUpDate = pickUpDate;
        return this;
    }

    public LocalDateTime getDropOffDate() {
        return dropOffDate;
    }

    public BookingAddDTO setDropOffDate(LocalDateTime dropOffDate) {
        this.dropOffDate = dropOffDate;
        return this;
    }

    public Car getCar() {
        return car;
    }

    public BookingAddDTO setCar(Car car) {
        this.car = car;
        return this;
    }

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public BookingAddDTO setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
        return this;
    }

    //    public String getCarBrand() {
//        return carBrand;
//    }
//
//    public BookingAddDTO setCarBrand(String carBrand) {
//        this.carBrand = carBrand;
//        return this;
//    }
//
//    public String getCarModel() {
//        return carModel;
//    }
//
//    public BookingAddDTO setCarModel(String carModel) {
//        this.carModel = carModel;
//        return this;
//    }
//
//    public String getChauffeurName() {
//        return chauffeurName;
//    }
//
//    public BookingAddDTO setChauffeurName(String chauffeurName) {
//        this.chauffeurName = chauffeurName;
//        return this;
//    }
//
//    public String getChauffeurSurname() {
//        return chauffeurSurname;
//    }
//
//    public BookingAddDTO setChauffeurSurname(String chauffeurSurname) {
//        this.chauffeurSurname = chauffeurSurname;
//        return this;
//    }
}
