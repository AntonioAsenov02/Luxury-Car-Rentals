package com.example.luxurycarrentals.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "reviews")
public class Review extends BaseEntity {


    @Column(nullable = false)
    private Integer rating;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate postedOn;
    @ManyToOne
    private UserEntity user;
    @ManyToOne
    private Car car;


    public Integer getRating() {
        return rating;
    }

    public Review setRating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public String getText() {
        return text;
    }

    public Review setText(String text) {
        this.text = text;
        return this;
    }

    public LocalDate getPostedOn() {
        return postedOn;
    }

    public Review setPostedOn(LocalDate postedOn) {
        this.postedOn = postedOn;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public Review setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public Car getCar() {
        return car;
    }

    public Review setCar(Car car) {
        this.car = car;
        return this;
    }
}
