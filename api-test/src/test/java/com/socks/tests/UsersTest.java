package com.socks.tests;

import com.socks.api.model.Addresses;
import com.socks.api.model.Card;
import com.socks.api.model.User;
import com.socks.api.services.UserApiService;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static com.socks.api.conditions.Conditions.*;
import static org.hamcrest.Matchers.*;


public class UsersTest extends BaseTest {

    private final UserApiService userApiService = new UserApiService();

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
                .setLongNum(faker.number().toString())
                .setExpires("11/21")
                .setCcv("666")
                .setUserID("57a98d98e4b00679b4a830af");

        userApiService.createNewCard(card)
                .shouldHave(statusCode(200))
                .shouldHave(body("id", not(emptyString())));
    }

    @Test
    public void testCreateNewAddress() {
        Addresses addresses = new Addresses()
                .setStreet(faker.address().streetAddress())
                .setNumber(faker.number().digit())
                .setCountry(faker.country().name())
                .setCity(faker.country().capital())
                .setPostcode(faker.code().asin())
                .setUserID("5f8c1e75ee11cb00011b1d6b");

        userApiService.createNewAddresses(addresses)
                .shouldHave(statusCode(200))
                .shouldHave(body("id", emptyString()));
    }
}
