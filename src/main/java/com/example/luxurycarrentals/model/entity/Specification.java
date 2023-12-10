package com.example.luxurycarrentals.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "specifications")
public class Specification extends BaseEntity {

    @Column(nullable = false)
    private Integer mileage;
    @Column(nullable = false)
    private Integer seats;
    @Column(nullable = false)
    private Integer luggageCapacity;
    @Column(nullable = false)
    private BigDecimal perHourPrice;
    @Column(nullable = false)
    private BigDecimal perDayPrice;
    @Column(nullable = false)
    private BigDecimal perMonthPrice;
    @OneToOne()
    private Car car;


    public Integer getMileage() {
        return mileage;
    }

    public Specification setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public Integer getSeats() {
        return seats;
    }

    public Specification setSeats(Integer seats) {
        this.seats = seats;
        return this;
    }

    public Integer getLuggageCapacity() {
        return luggageCapacity;
    }

    public Specification setLuggageCapacity(Integer luggageCapacity) {
        this.luggageCapacity = luggageCapacity;
        return this;
    }


    public BigDecimal getPerHourPrice() {
        return perHourPrice;
    }

    public Specification setPerHourPrice(BigDecimal perHourPrice) {
        this.perHourPrice = perHourPrice;
        return this;
    }

    public BigDecimal getPerDayPrice() {
        return perDayPrice;
    }

    public Specification setPerDayPrice(BigDecimal perDayPrice) {
        this.perDayPrice = perDayPrice;
        return this;
    }

    public BigDecimal getPerMonthPrice() {
        return perMonthPrice;
    }

    public Specification setPerMonthPrice(BigDecimal perMonthPrice) {
        this.perMonthPrice = perMonthPrice;
        return this;
    }

    public Car getCar() {
        return car;
    }

    public Specification setCar(Car car) {
        this.car = car;
        return this;
    }
}
