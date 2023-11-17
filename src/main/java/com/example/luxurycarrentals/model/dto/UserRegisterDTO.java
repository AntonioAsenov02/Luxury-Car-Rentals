package com.example.luxurycarrentals.model.dto;

import com.example.luxurycarrentals.model.validation.FieldMatch;
import com.example.luxurycarrentals.model.validation.UniqueUserEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords do not match."
)
public class UserRegisterDTO {

    @NotEmpty(message = "You should provide an email.")
    @Email(message = "The email should be valid.")
    @UniqueUserEmail(message = "The email should be unique.")
    private String email;
    @NotEmpty
    @Size(min = 2, max = 20, message = "First name should be between 2 and 20 symbols.")
    private String firstName;
    @NotEmpty
    @Size(min = 2, max = 20, message = "Last name should be between 2 and 20 symbols")
    private String lastName;
    @NotEmpty
    @Size(min = 5, message = "The password should contain at least 5 symbols.")
    private String password;
    @NotEmpty
    @Size(min = 5, message = "The password should contain at least 5 symbols.")
    private String confirmPassword;

    public UserRegisterDTO() {

    }


    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}