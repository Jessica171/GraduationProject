package com.example.GradProject.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.*;

@Document
public class Users {
    @Id
    @Email
    @NotNull
    @NotBlank(message = "Email Can't be Blank")
    private String email;

    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{6,}$", message = "Password must contain at least one uppercase letter, one lowercase letter, and one digit.")
    @Size(min = 8, message = "Password must be Valid")
    private String password;

    @NotBlank
    private String fullname;

    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "Phone number must be 12 digits")
    private String phonenumber;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
