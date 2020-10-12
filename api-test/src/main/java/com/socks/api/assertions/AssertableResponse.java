package com.socks.api.assertions;

import com.socks.api.conditions.Condition;
import io.qameta.allure.Step;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AssertableResponse {

    private final Response response;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AssertableResponse.class);

    public AssertableResponse(Response response) {
        this.response = response;
    }

    @Step("Api response should have {0}")
    public AssertableResponse shouldHave(Condition condition) {
        log.info("About to check condition {}", condition);
        condition.check(response);
        return this;
    }

    @Step
    public <T> T asPojo(Class<T> tClass) {
        return response.as(tClass);
    }

    public Headers headers() {
        return response.getHeaders();
    }
}
