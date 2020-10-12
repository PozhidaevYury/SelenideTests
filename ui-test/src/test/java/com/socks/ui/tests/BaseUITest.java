package com.socks.ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import com.socks.api.ProjectConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeSuite;

import java.util.Locale;

public class BaseUITest {

    protected Faker faker;

    @BeforeSuite
    public void setUp() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());

        RestAssured.baseURI = config.baseUrl();
        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = "com.socks.ui.SelenoidDriverProvider";
        faker = new Faker(new Locale("ru"));
        //Configuration.browser = "firefox";
    }

    protected <T> T at(Class<T> pageClass) {
        return Selenide.page(pageClass);
    }
}
