package com.socks.tests;

import com.github.javafaker.Faker;
import com.socks.api.model.User;
import com.socks.api.response.UserRegistrationResponse;
import com.socks.api.services.UserApiService;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

import static com.socks.api.conditions.Conditions.*;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.not;


public class UsersTest {

    private final UserApiService userApiService = new UserApiService();
    private final Faker faker = new Faker(new Locale("ru"));

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://46.101.203.68";
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
                .email("test@gmail.com");

        userApiService.registerUser(user)
                .shouldHave(statusCode(200))
                .shouldHave(body("id", not(emptyString())));

        userApiService.registerUser(user)
                .shouldHave(statusCode(500));
    }
}
