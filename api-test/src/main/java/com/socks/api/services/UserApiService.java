package com.socks.api.services;

import com.socks.api.assertions.AssertableResponse;
import com.socks.api.model.Addresses;
import com.socks.api.model.Card;
import com.socks.api.model.User;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.get;

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
        setupTextPlainRequest();
        return new AssertableResponse(get("customers"));
    }

    @Step("Get customer by id")
    public AssertableResponse getCustomerById() {
        setupTextPlainRequest();
        return new AssertableResponse(get("customers/5f82da66ee11cb0001617fef"));
    }

    @Step("Get all card")
    public AssertableResponse getAllCards() {
        setupTextPlainRequest();
        return new AssertableResponse(get("cards"));
    }

    @Step("Create new Card")
    public AssertableResponse createNewCard(Card card) {
        return new AssertableResponse(
                setup()
                        .body(card)
                        .when()
                        .post("cards")
        );
    }

    @Step("Create new addresses")
    public AssertableResponse createNewAddresses(Addresses addresses) {
        return new AssertableResponse(
                setup()
                .body(addresses)
                .when()
                .post("addresses")
        );
    }
}
