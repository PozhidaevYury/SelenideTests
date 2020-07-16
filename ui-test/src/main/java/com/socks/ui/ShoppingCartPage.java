package com.socks.ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartPage {

    public static ShoppingCartPage open() {
        Selenide.open("/basket.html");
        return Selenide.page(ShoppingCartPage.class);
    }

    public SelenideElement totalAmount() {
        return $("#orderGrandTotal");
    }

    public ShoppingCartPage deleteItem() {
        $("i.fa.fa-trash-o").click();
        return this;
    }

}
