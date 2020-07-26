package com.socks.api.services;

import com.socks.api.assertions.AssertableResponse;
import com.socks.api.model.User;
import io.qameta.allure.Step;

public class UserApiService extends ApiService {

    @Step
    public AssertableResponse registerUser(User user) {
        return new AssertableResponse(
                setup()
                .body(user)
                .when().post("register"));
    }
}
