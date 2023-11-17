package com.example.luxurycarrentals.model.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private Integer year;
    @Column()
    private Integer rating;
    @Column(nullable = false)
    private String imageUrl;
    @OneToOne
    private Offer offer;



    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Car setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public Car setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getRating() {
        return rating;
    }

    public Car setRating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Car setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Offer getOffer() {
        return offer;
    }

    public Car setOffer(Offer offer) {
        this.offer = offer;
        return this;
    }
}
