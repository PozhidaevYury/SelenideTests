package com.socks.tests;

import com.github.javafaker.Faker;
import com.socks.api.ApiConfig;
import com.socks.api.model.User;
import com.socks.api.services.UserApiService;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

import static com.socks.api.conditions.Conditions.*;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.not;


public class UsersTest {

    private final UserApiService userApiService = new UserApiService();
    private Faker faker;

    @BeforeClass
    public void setUp() {
        ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());
        faker = new Faker(new Locale(config.locale()));
        RestAssured.baseURI = config.baseUrl();
    }

    @Test
    public void testCanRegisterNewUser() {
        User user = new User()
                .username(faker.name().username())
                .email("test@gmail.com")
                .password("test123");

        userApiService.registerUser(user)
                .shouldHave(statusCode(200))
                .shouldHave(body("id", not(emptyString())));


        // UserRegistrationResponse userRegistrationResponse = userApiService.registerUser(user)
        //          .shouldHave(statusCode(200))
        //          .asPojo(UserRegistrationResponse.class);
//
        // userRegistrationResponse.getId();
    }

    @Test
    public void testCantRegisterSameUserTwice() {
        User user = new User()
                .username(faker.name().username())
                .email("test@gmail.com")
                .password("test123");

        userApiService.registerUser(user)
                .shouldHave(statusCode(200))
                .shouldHave(body("id", not(emptyString())));

        userApiService.registerUser(user)
                .shouldHave(statusCode(500));
    }
}
