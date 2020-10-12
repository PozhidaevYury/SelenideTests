package com.socks.tests;

import com.github.javafaker.Faker;
import com.socks.api.ProjectConfig;
import com.socks.api.model.Addresses;
import com.socks.api.model.Card;
import com.socks.api.model.User;
import com.socks.api.services.UserApiService;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Locale;

import static com.socks.api.conditions.Conditions.*;
import static org.hamcrest.Matchers.*;


public class UsersTest {

    private final UserApiService userApiService = new UserApiService();
    private Faker faker;

    @BeforeClass
    public void setUp() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        faker = new Faker(new Locale(config.locale()));
        RestAssured.baseURI = config.baseUrl();
        RestAssured.port = 80;
    }

    @Test
    public void testCanRegisterNewUser() {
        User user = new User()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .username(faker.name().username())
                .email("test@gmail.com")
                .password("test123");

        userApiService.registerUser(user)
                .shouldHave(statusCode(200))
                .shouldHave(body("id", not(emptyString())));

        //  UserRegistrationResponse userRegistrationResponse = userApiService.registerUser(user)
        //           .shouldHave(statusCode(200))
        //           .asPojo(UserRegistrationResponse.class);
//
        //  userRegistrationResponse.getId();
    }

    @Test
    public void testCannotRegisterSameUserTwice() {
        User user = new User()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .username(faker.name().username())
                .email("test@gmail.com")
                .password("test123");

        userApiService.registerUser(user)
                .shouldHave(statusCode(200))
                .shouldHave(body("id", not(emptyString())));

        userApiService.registerUser(user)
                .shouldHave(statusCode(500));
    }

    @Test
    public void testReturnAllCustomers() {
        userApiService
                .getAllCustomers()
                .shouldHave(statusCode(200))
                .shouldHave(body("_embedded.customer", not(empty())));
    }

    @Ignore
    @Test
    public void testReturnCustomerById() {
        userApiService
                .getCustomerById()
                .shouldHave(statusCode(200))
                .shouldHave(body("username", not(emptyString())));
    }

    @Test
    public void testReturnAllCards() {
        userApiService
                .getAllCards()
                .shouldHave(statusCode(200))
                .shouldHave(body("_embedded.card", not(empty())));
    }

    @Test
    public void testCreateNewCard() {
        Card card = new Card()
                .setLongNum("1234567890")
                .setExpires("11/21")
                .setCcv("666")
                .setUserID("5f842de5ee11cb000154af21");

        userApiService.createNewCard(card)
                .shouldHave(statusCode(200))
                .shouldHave(body("id", not(emptyString())));
    }

    @Test
    public void testCreateNewAddress() {
        Addresses addresses = new Addresses()
                .setStreet("test")
                .setNumber("test")
                .setCountry("test")
                .setCity("test")
                .setPostcode("test")
                .setUserID("5f842de5ee11cb000154af21");

        userApiService.createNewAddresses(addresses)
                .shouldHave(statusCode(200))
                .shouldHave(body("id", not(emptyString())));
    }
}
