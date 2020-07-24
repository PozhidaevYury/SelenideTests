package com.socks.api.conditions;

import org.hamcrest.Matcher;

public class Conditions {

    private Conditions() {
    }

    public static StatusCodeCondition statusCode(int code) {
        return new StatusCodeCondition(code);
    }

    public static BodyFieldCondition body(String jsonPath, Matcher matcher) {
        return new BodyFieldCondition(jsonPath, matcher);
    }
}
