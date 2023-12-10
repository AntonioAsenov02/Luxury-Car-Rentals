package com.example.luxurycarrentals.model.entity;

import com.example.luxurycarrentals.model.enums.FuelEnum;
import com.example.luxurycarrentals.model.enums.TransmissionEnum;
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
    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;
    @Column()
    private Integer rating;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FuelEnum fuel;
    @Column(nullable = false)
    private String imageUrl;
    @OneToOne(fetch = FetchType.EAGER)
    private Specification specifications;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Review> reviews;



    public String getBrand() {
        return brand;
    }

    public Car setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public Car setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Car setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getRating() {
        return rating;
    }

    public Car setRating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public Car setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public FuelEnum getFuel() {
        return fuel;
    }

    public Car setFuel(FuelEnum fuel) {
        this.fuel = fuel;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Car setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Specification getSpecifications() {
        return specifications;
    }

    public Car setSpecifications(Specification specifications) {
        this.specifications = specifications;
        return this;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public Car setReviews(List<Review> reviews) {
        this.reviews = reviews;
        return this;
    }
}
