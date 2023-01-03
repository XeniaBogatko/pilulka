package tests;

import config.Auth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.PilulkaPages;

import static com.codeborne.selenide.Selenide.sleep;

public class PilulkaTests extends TestBase {
    PilulkaPages pilulkaPage = new PilulkaPages();

    @Test
    @DisplayName("Check menu items name")
    void checkMenuItems() {
        pilulkaPage
                .openPage()
                .checkMenuItems();
        sleep(3000);
    }

    @Test
    @DisplayName("Search for Nurofen")
    void cleanerSearchTest() {
        pilulkaPage
                .openPage()
                .search("nurofen")
                .checkInSearchResults("Nurofen 200 mg 24 tablet");
        sleep(3000);
    }

    @Test
    @DisplayName("Add and remove item in the basket")
    void basketTest() {
        pilulkaPage
                .openPage()
                .addItemInBasket();
        sleep(3000);
    }

    @ValueSource(strings = {"Kontakt", "O nás", "Pro firmy", "Pro média", "Pro investory", "Obchodní podmínky",
            "Ochrana osobních údajů", "Affiliate program", "Pracujte v Pilulce", "Prodávejte na Pilulka.cz"})
    @ParameterizedTest(name = "Footer Test")
    @DisplayName("Checking footer selection")
    void countrySearchTest(String testFooter) {
        pilulkaPage
                .openPage()
                .setCheckFooter(testFooter);
        sleep(3000);
    }

    @Test
    @DisplayName("Authorization account test")
    void authorizationTestNegative() {
        pilulkaPage
                .openPage()
                .loginWithError(Auth.config.login(), Auth.config.pass());
        sleep(3000);
    }
}