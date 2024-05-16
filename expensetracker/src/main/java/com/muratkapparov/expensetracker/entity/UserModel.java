package com.muratkapparov.expensetracker.entity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserModel {

    @NotBlank(message = "should not be empty")
    private String name;

    @Email(message = "please enter valid email")
    @NotNull(message = "please enter email")
    private String email;

    @NotNull(message = "Please enter password")
    @Size(min = 5, message = "password should be at least 5 chars")
    private String password;


    private Long age = 0L;
}
