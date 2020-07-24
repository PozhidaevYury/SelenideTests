package com.socks.api.assertions;

import com.socks.api.conditions.Condition;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class AssertableResponse {

    private final Response response;

    public AssertableResponse(Response register) {
        this.response = register;
    }

    public AssertableResponse shouldHave(Condition condition) {
        condition.check(response);
        return this;
    }

    public <T> T asPojo(Class<T> tClass) {
        return response.as(tClass);
    }

    public Headers headers() {
        return response.getHeaders();
    }
}
