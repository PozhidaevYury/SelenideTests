package com.socks.api.services;

import com.socks.api.assertions.AssertableResponse;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.get;

public class CatalogueApiService extends ApiService {

    @Step("Get all catalogue")
    public AssertableResponse getAllCatalogue() {
        setupTextPlainRequest();
        return new AssertableResponse(get("catalogue"));
    }

    @Step("Get size of catalogue")
    public AssertableResponse getSizeOfCatalogue() {
        setupTextPlainRequest();
        return new AssertableResponse(get("catalogue/size"));
    }
}
