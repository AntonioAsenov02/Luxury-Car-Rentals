package com.example.luxurycarrentals.model.dto;

import java.time.LocalDate;

public class ReviewInfoDTO {

    private Long id;
    private Integer rating;
    private String text;
    private LocalDate postedOn;
    private String firstName;
    private String lastName;
    private String imageUrl;



    public Long getId() {
        return id;
    }

    public ReviewInfoDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getRating() {
        return rating;
    }

    public ReviewInfoDTO setRating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public String getText() {
        return text;
    }

    public ReviewInfoDTO setText(String text) {
        this.text = text;
        return this;
    }

    public LocalDate getPostedOn() {
        return postedOn;
    }

    public ReviewInfoDTO setPostedOn(LocalDate postedOn) {
        this.postedOn = postedOn;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ReviewInfoDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ReviewInfoDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ReviewInfoDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
