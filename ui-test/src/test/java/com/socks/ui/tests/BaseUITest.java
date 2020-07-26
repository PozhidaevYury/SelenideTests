package com.socks.ui.tests;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;

public class BaseUITest {

    @BeforeSuite
    public void setUp() {
        baseUrl = "http://46.101.203.68";
        browser = "com.socks.ui.SelenoidDriverProvider";
       // browser = "firefox";
    }

    protected <T> T at(Class<T> pageClass) {
        return Selenide.page(pageClass);
    }
}
