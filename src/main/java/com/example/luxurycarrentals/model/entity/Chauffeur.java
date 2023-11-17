package com.example.luxurycarrentals.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chauffeurs")
public class Chauffeur extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private String gender;
    @Column
    private Integer rating;
    @Column(nullable = false)
    private String imageUrl;
    @OneToOne
    private Offer offer;



    public String getName() {
        return name;
    }

    public Chauffeur setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Chauffeur setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Chauffeur setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Chauffeur setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Integer getRating() {
        return rating;
    }

    public Chauffeur setRating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Chauffeur setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Offer getOffer() {
        return offer;
    }

    public Chauffeur setOffer(Offer offer) {
        this.offer = offer;
        return this;
    }
}
