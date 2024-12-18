package com.nsa.ano.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table

public class RegisterRequest {
@Id
@SequenceGenerator(
        name = "register_sequence",
        sequenceName = "register_sequence",
        allocationSize = 1
)

@GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "register_sequence"
)
    private String email;
    private String password;
    private String lastName;
    private String firstName;

    // Getters and Setters


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }
    public void getLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void getFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getConfirmPassword() {
        return password;
    }
}

