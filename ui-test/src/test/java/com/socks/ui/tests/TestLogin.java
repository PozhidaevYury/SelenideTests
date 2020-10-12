package com.socks.ui.tests;

import com.socks.api.conditions.Conditions;
import com.socks.api.model.User;
import com.socks.api.services.UserApiService;
import com.socks.ui.LoggedUserPage;
import com.socks.ui.MainPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;

public class TestLogin extends BaseUITest {

    private final UserApiService userApiService = new UserApiService();

    @Test
    public void userCanLoginWithValidData() {

        User user = new User()
                .username(faker.name().firstName())
                .password(faker.random().hex())
                .email("test3@gmail.com");

        userApiService.registerUser(user)
                .shouldHave(Conditions.statusCode(200));

        MainPage.open()
                .loginAs(user.getUsername(), user.getPassword());

        LoggedUserPage loggedUserPage = at(LoggedUserPage.class);

        loggedUserPage.logoutBtn().shouldHave(text("Logout"));
        loggedUserPage.userName().shouldHave(text("Logged in as"));
    }
}
