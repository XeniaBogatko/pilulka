package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junitpioneer.jupiter.RetryingTest;
import pages.MainPage;
@Epic("Menu")
public class MenuTests extends TestBase {
    MainPage pilulkaPage = new MainPage();
    @Test
    @Order(1)
    @Story("Cookies")
    @Owner("Xenia Bogatko")
    @DisplayName("Check that cookies can be rejected")
    void checkCookiesRejection() {
        pilulkaPage
                .openPage()
                .closeCookiesMessage();
    }
    @RetryingTest(5)
    @Story("Main menu")
    @Owner("Xenia Bogatko")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Check menu items name")
    void checkMenuItems() {
        pilulkaPage
                .openPage()
                .checkMenuItems();
    }

    @ParameterizedTest(name = "Footer Test")
    @Story("Footer menu")
    @Owner("Xenia Bogatko")
    @Severity(SeverityLevel.NORMAL)
    @ValueSource(strings = {"Kontakt", "O nás", "Pro firmy", "Pro média", "Pro investory", "Obchodní podmínky",
            "Ochrana osobních údajů", "Affiliate program", "Pracujte v Pilulce", "Prodávejte na Pilulka.cz"})
    @DisplayName("Checking footer selection")
    void checkMenuFooter(String testFooter) {
        pilulkaPage
                .openPage()
                .checkFooter(testFooter);
    }
}