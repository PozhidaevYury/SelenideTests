package com.socks.ui.tests;

import com.codeborne.selenide.Selenide;
import com.socks.ui.CatalogPage;
import com.socks.ui.ShoppingCartPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;

public class ShoppingCartTest extends BaseUITest {

    @Test
    public void userCanAddItemToCart() {
        CatalogPage.open()
                .addItemByIndex(0)
                .goToCart();

        at(ShoppingCartPage.class).totalAmount().shouldHave(text("$104.98"));
    }

    // add api tests and cookies / 1:55
    @Test
    public void userCanDeleteItemFromCart() {
        CatalogPage.open()
                .addItemByIndex(0)
                .goToCart();

        at(ShoppingCartPage.class).totalAmount().shouldHave(text("$104.98"));
        at(ShoppingCartPage.class).deleteItem().totalAmount().shouldHave(text("$0.00"));
    }

    @AfterMethod
    public void tearDown() {
        Selenide.clearBrowserCookies();
    }
}
