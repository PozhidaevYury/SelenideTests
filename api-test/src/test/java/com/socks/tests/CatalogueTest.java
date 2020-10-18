package com.socks.tests;

import com.socks.api.services.CatalogueApiService;
import org.testng.annotations.Test;
import static com.socks.api.conditions.Conditions.*;
import static org.hamcrest.Matchers.*;

public class CatalogueTest extends BaseTest {

    private final CatalogueApiService catalogueApiService = new CatalogueApiService();

    @Test
    public void testReturnAllCatalogue() {
        catalogueApiService
                .getAllCatalogue()
                .shouldHave(statusCode(200))
                .shouldHave(body("", not(empty())));
    }

    @Test
    public void testReturnSizeOfCatalogue() {
        catalogueApiService
                .getSizeOfCatalogue()
                .shouldHave(statusCode(200))
                .shouldHave(body("size", not(emptyString())));
    }
}
