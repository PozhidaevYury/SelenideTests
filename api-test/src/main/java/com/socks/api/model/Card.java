package com.socks.api.model;

import com.google.gson.annotations.SerializedName;

public class Card {

    @SerializedName("longNum")
    private String longNum;
    @SerializedName("expires")
    private String expires;
    @SerializedName("ccv")
    private String ccv;
    @SerializedName("userID")
    private String userID;

    public Card setExpires(String expires) {
        this.expires = expires;
        return this;
    }

    public String getExpires() {
        return expires;
    }

    public Card setLongNum(String longNum) {
        this.longNum = longNum;
        return this;
    }

    public String getLongNum() {
        return longNum;
    }

    public Card setCcv(String ccv) {
        this.ccv = ccv;
        return this;
    }

    public String getCcv() {
        return ccv;
    }

    public Card setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public String getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return
                "Card{" +
                        ",longNum = '" + longNum + '\'' +
                        "expires = '" + expires + '\'' +
                        ",ccv = '" + ccv + '\'' +
                        ",userID = '" + userID + '\'' +
                        "}";
    }
}
