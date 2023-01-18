package tests.ui;

import config.Auth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junitpioneer.jupiter.RetryingTest;
import pages.PilulkaPages;
import tests.TestBase;

public class PilulkaTests extends TestBase {
    PilulkaPages pilulkaPage = new PilulkaPages();

    @RetryingTest(5)
    @DisplayName("Check menu items name")
    void checkMenuItems() {
        pilulkaPage
                .openPage()
                .checkMenuItems();
    }

    @RetryingTest(5)
    @DisplayName("Search for Nurofen")
    void itemSearchTest() {
        pilulkaPage
                .openPage()
                .search("nurofen")
                .checkInSearchResults("Nurofen 200 mg 24 tablet");
    }
    @Test
    @DisplayName("Check empty basket after opening the site")
    void emptyBasketTest() {
        pilulkaPage
                .openPage()
                .checkEmptyBasket();
    }

    @Test
    @DisplayName("Open Sales from the basket")
    void openSaleFromBasketTest() {
        pilulkaPage
                .openPage()
                .openSales();
    }

    @RetryingTest(5)
    @DisplayName("Add and remove item in the basket")
    void addItemToBasketTest() {
        pilulkaPage
                .openPage()
                .addItemInBasket();
    }

    @ValueSource(strings = {"Kontakt", "O nás", "Pro firmy", "Pro média", "Pro investory", "Obchodní podmínky",
            "Ochrana osobních údajů", "Affiliate program", "Pracujte v Pilulce", "Prodávejte na Pilulka.cz"})
    @ParameterizedTest(name = "Footer Test")
    @DisplayName("Checking footer selection")
    void countrySearchTest(String testFooter) {
        pilulkaPage
                .openPage()
                .setCheckFooter(testFooter);
    }

    @RetryingTest(5)
    @DisplayName("Authorization account test")
    void authorizationTestNegative() {
        pilulkaPage
                .openPage()
                .loginWithError(Auth.config.login(), Auth.config.pass());
    }
}