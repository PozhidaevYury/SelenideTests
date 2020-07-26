package com.socks.ui.tests;

import com.socks.ui.LoggedUserPage;
import com.socks.ui.MainPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;

public class TestLogin extends BaseUITest {



    @Test
    public void userCanLoginWithValidData() {
        // create api tests

        MainPage.open()
                .loginAs("hello", "test123");

        LoggedUserPage loggedUserPage = at(LoggedUserPage.class);

        loggedUserPage.logoutBtn().shouldHave(text("Logout"));
        loggedUserPage.userName().shouldHave(text("Logged in as"));
    }
}
