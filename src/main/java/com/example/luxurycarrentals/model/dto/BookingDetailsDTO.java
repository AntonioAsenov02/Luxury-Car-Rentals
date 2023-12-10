package com.example.luxurycarrentals.model.dto;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingDetailsDTO {

    private String bookingNumber;
    private String pickUpLocation;
    private String dropOffLocation;
    private LocalDateTime pickUpDate;
    private LocalDateTime dropOffDate;
    private String carBrand;
    private String carModel;
    private String chauffeurName;
    private String chauffeurSurname;
    private BigDecimal price;



    public String getBookingNumber() {
        return bookingNumber;
    }

    public BookingDetailsDTO setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
        return this;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public BookingDetailsDTO setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
        return this;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public BookingDetailsDTO setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
        return this;
    }

    public LocalDateTime getPickUpDate() {
        return pickUpDate;
    }

    public BookingDetailsDTO setPickUpDate(LocalDateTime pickUpDate) {
        this.pickUpDate = pickUpDate;
        return this;
    }

    public LocalDateTime getDropOffDate() {
        return dropOffDate;
    }

    public BookingDetailsDTO setDropOffDate(LocalDateTime dropOffDate) {
        this.dropOffDate = dropOffDate;
        return this;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public BookingDetailsDTO setCarBrand(String carBrand) {
        this.carBrand = carBrand;
        return this;
    }

    public String getCarModel() {
        return carModel;
    }

    public BookingDetailsDTO setCarModel(String carModel) {
        this.carModel = carModel;
        return this;
    }

    public String getChauffeurName() {
        return chauffeurName;
    }

    public BookingDetailsDTO setChauffeurName(String chauffeurName) {
        this.chauffeurName = chauffeurName;
        return this;
    }

    public String getChauffeurSurname() {
        return chauffeurSurname;
    }

    public BookingDetailsDTO setChauffeurSurname(String chauffeurSurname) {
        this.chauffeurSurname = chauffeurSurname;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BookingDetailsDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
