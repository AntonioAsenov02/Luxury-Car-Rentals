package com.example.luxurycarrentals.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    @Column(nullable = false)
    private BigDecimal perHourPrice;
    @Column(nullable = false)
    private BigDecimal perDayPrice;
    @Column(nullable = false)
    private BigDecimal perMonthPrice;
    @ManyToOne
    private UserEntity userEntity;
    @ManyToOne
    private Car cars;
    @OneToOne
    private Chauffeur chauffeurs;



    public BigDecimal getPerHourPrice() {
        return perHourPrice;
    }

    public Offer setPerHourPrice(BigDecimal perHourPrice) {
        this.perHourPrice = perHourPrice;
        return this;
    }

    public BigDecimal getPerDayPrice() {
        return perDayPrice;
    }

    public Offer setPerDayPrice(BigDecimal perDayPrice) {
        this.perDayPrice = perDayPrice;
        return this;
    }

    public BigDecimal getPerMonthPrice() {
        return perMonthPrice;
    }

    public Offer setPerMonthPrice(BigDecimal perMonthPrice) {
        this.perMonthPrice = perMonthPrice;
        return this;
    }

    public UserEntity getUser() {
        return userEntity;
    }

    public Offer setUser(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public Car getCars() {
        return cars;
    }

    public Offer setCars(Car cars) {
        this.cars = cars;
        return this;
    }

    public Chauffeur getChauffeurs() {
        return chauffeurs;
    }

    public Offer setChauffeurs(Chauffeur chauffeurs) {
        this.chauffeurs = chauffeurs;
        return this;
    }
}
