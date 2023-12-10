package com.example.luxurycarrentals.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ReviewAddDTO {

    private Long id;
    @NotNull(message = "You should select between 1 and 5 stars!")
    private Integer rating;
    @NotEmpty(message = "You need to provide a comment")
    @Size(min = 2)
    private String text;



    public Long getId() {
        return id;
    }

    public ReviewAddDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getRating() {
        return rating;
    }

    public ReviewAddDTO setRating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public String getText() {
        return text;
    }

    public ReviewAddDTO setText(String text) {
        this.text = text;
        return this;
    }
}
