package com.socks.api.services;

import com.socks.api.assertions.AssertableResponse;
import com.socks.api.model.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UserApiService {

    public AssertableResponse registerUser(User user) {
        return new AssertableResponse(RestAssured
                .given().contentType(ContentType.JSON).log().all()
                .body(user)
                .when().post("register"));
    }
}
