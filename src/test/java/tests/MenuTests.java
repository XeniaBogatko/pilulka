package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junitpioneer.jupiter.RetryingTest;
import pages.PilulkaMainPage;

public class MenuTests extends TestBase {
    PilulkaMainPage pilulkaPage = new PilulkaMainPage();

    @RetryingTest(5)
    @Epic("Menu")
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
    @Epic("Menu")
    @Story("Footer menu")
    @Owner("Xenia Bogatko")
    @Severity(SeverityLevel.NORMAL)
    @ValueSource(strings = {"Kontakt", "O nás", "Pro firmy", "Pro média", "Pro investory", "Obchodní podmínky",
            "Ochrana osobních údajů", "Affiliate program", "Pracujte v Pilulce", "Prodávejte na Pilulka.cz"})
    @DisplayName("Checking footer selection")
    void checkMenuFooterTest(String testFooter) {
        pilulkaPage
                .openPage()
                .setCheckFooter(testFooter);
    }
}