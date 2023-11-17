package com.example.luxurycarrentals.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String bookingNumber;
    @Column(nullable = false)
    private String pickUpLocation;
    @Column(nullable = false)
    private String dropOffLocation;
    @Column(nullable = false)
    private LocalDate pickUpDate;
    @Column(nullable = false)
    private LocalDate dropOffDate;
    @ManyToOne
    private UserEntity userEntity;
    @ManyToOne
    private Car car;
    @ManyToOne
    private Chauffeur chauffeur;



    public String getBookingNumber() {
        return bookingNumber;
    }

    public Booking setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
        return this;
    }

    public UserEntity getUser() {
        return userEntity;
    }

    public Booking setUser(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public Booking setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
        return this;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public Booking setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
        return this;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public Booking setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
        return this;
    }

    public LocalDate getDropOffDate() {
        return dropOffDate;
    }

    public Booking setDropOffDate(LocalDate dropOffDate) {
        this.dropOffDate = dropOffDate;
        return this;
    }

    public Car getCar() {
        return car;
    }

    public Booking setCar(Car car) {
        this.car = car;
        return this;
    }

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public Booking setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
        return this;
    }
}
