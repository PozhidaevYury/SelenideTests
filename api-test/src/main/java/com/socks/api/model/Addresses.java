package com.socks.api.model;

import com.google.gson.annotations.SerializedName;

public class Addresses {

    @SerializedName("number")
    private String number;
    @SerializedName("country")
    private String country;
    @SerializedName("city")
    private String city;
    @SerializedName("street")
    private String street;
    @SerializedName("postcode")
    private String postcode;
    @SerializedName("userID")
    private String userID;

    public Addresses setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public Addresses setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Addresses setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Addresses setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Addresses setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public String getPostcode() {
        return postcode;
    }

    public Addresses setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public String getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return
                "Addresses{" +
                        "number = '" + number + '\'' +
                        ",country = '" + country + '\'' +
                        ",city = '" + city + '\'' +
                        ",street = '" + street + '\'' +
                        ",postcode = '" + postcode + '\'' +
                        ",userID = '" + userID + '\'' +
                        "}";
    }
}
