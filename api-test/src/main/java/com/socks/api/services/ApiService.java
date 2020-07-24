package com.socks.api.services;

import com.socks.api.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ApiService {

    protected RequestSpecification setup() {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .filters(getFilters());
    }

    private List<Filter> getFilters() {
        ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());
        if (config.logging()) {
            return Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter());
        } else {
            return Collections.emptyList();
        }
    }
}
