package com.socks.api.services;

import com.socks.api.ProjectConfig;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiService {

    protected RequestSpecification setup() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .filters(getFilters());
    }

    protected void setupTextPlainRequest() {
        RestAssured.registerParser("text/plain", Parser.JSON);
        given().filters(getFilters());
    }

    private List<Filter> getFilters() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        if (config.logging()) {
            return Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter(), new AllureRestAssured());
        } else {
            return Collections.singletonList(new AllureRestAssured());
        }
    }
}
