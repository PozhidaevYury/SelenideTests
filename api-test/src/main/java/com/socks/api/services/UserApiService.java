package com.socks.api.services;

import com.socks.api.assertions.AssertableResponse;
import com.socks.api.model.User;

public class UserApiService extends ApiService {
    public AssertableResponse registerUser(User user) {
        return new AssertableResponse(
                setup()
                .body(user)
                .when().post("register"));
    }
}
