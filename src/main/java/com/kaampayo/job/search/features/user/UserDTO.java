package com.kaampayo.job.search.features.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDTO {
    @NotBlank
            (message="Enter your email")
    @Email
            (message="Enter a valid email")
    private String email;
    @NotBlank
            (message="Enter your password")
    private String password;
    @NotBlank(message="Re-enter your password")
    private String rpassword;
    @NotBlank(message="Enter your name")
    private String name;

    public UserDTO() {

    }

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

    public String getRpassword() {
        return rpassword;
    }

    public void setRpassword(String rpassword) {
        this.rpassword = rpassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rpassword='" + rpassword + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

