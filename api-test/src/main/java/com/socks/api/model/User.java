package com.socks.api.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("password")
    private String password;

    @SerializedName("email")
    private String email;

    @SerializedName("username")
    private String username;

    @SerializedName("firstName")
    private String firstName;

    @SerializedName("lastName")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public User lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User password(String password) {
        this.password = password;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User username(String username) {
        this.username = username;
        return this;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return
                "User{" +
                        "password = '" + password + '\'' +
                        ",email = '" + email + '\'' +
                        ",username = '" + username + '\'' +
                        "}";
    }
}