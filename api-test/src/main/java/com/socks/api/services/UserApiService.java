package com.socks.api.services;

import com.socks.api.assertions.AssertableResponse;
import com.socks.api.model.Addresses;
import com.socks.api.model.Card;
import com.socks.api.model.User;
import io.qameta.allure.Step;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;


public class UserApiService extends ApiService {

    @Step("Register user")
    public AssertableResponse registerUser(User user) {
        return new AssertableResponse(
                setup()
                        .body(user)
                        .when()
                        .post("register"));
    }

    @Step("Get all customers")
    public AssertableResponse getAllCustomers() {
        return new AssertableResponse(RestAssured.get("customers"));
    }

    @Step("Get customer by id")
    public AssertableResponse getCustomerById() {
        return new AssertableResponse(RestAssured.get("customers/5f82da66ee11cb0001617fef"));
    }

    @Step("Get all card")
    public AssertableResponse getAllCards() {
        return new AssertableResponse(RestAssured.get("cards"));
    }

    @Step("Create new Card")
    public AssertableResponse createNewCard(Card card) {
        setupTextPlainRequest();
        return new AssertableResponse(
                given()
                        .body(card)
                        .when()
                        .post("cards")
        );
    }

    @Step("Create new addresses")
    public AssertableResponse createNewAddresses(Addresses addresses) {
        setupTextPlainRequest();
        return new AssertableResponse(
                given()
                        .body(addresses)
                        .when()
                        .post("addresses")
        );
    }
}
