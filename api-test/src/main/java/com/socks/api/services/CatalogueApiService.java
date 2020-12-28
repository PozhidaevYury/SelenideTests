package com.socks.api.services;

import com.socks.api.assertions.AssertableResponse;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.get;

public class CatalogueApiService extends ApiService {

    @Step("Get all catalogue")
    public AssertableResponse getAllCatalogue() {
        setupTextPlainRequest();
        Allure.step(get("catalogue").body().prettyPrint());
        return new AssertableResponse(get("catalogue"));
    }

    @Step("Get size of catalogue")
    public AssertableResponse getSizeOfCatalogue() {
        setupTextPlainRequest();
        Allure.step(get("catalogue/size").body().prettyPrint());
        return new AssertableResponse(get("catalogue/size"));
    }
}
