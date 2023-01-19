package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.RetryingTest;
import pages.PilulkaMainPage;

public class BasketTests extends TestBase {
    PilulkaMainPage pilulkaPage = new PilulkaMainPage();

    @Test
    @Epic("Basket")
    @Story("Empty basket")
    @Owner("Xenia Bogatko")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Check empty basket after opening the site for the first time")
    void emptyBasketTest() {
        pilulkaPage
                .openPage()
                .checkEmptyBasket();
    }

    @Test
    @Epic("Basket")
    @Story("Sales in the basket")
    @Owner("Xenia Bogatko")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Open Sales from the basket")
    void openSaleFromBasketTest() {
        pilulkaPage
                .openPage()
                .openSales();
    }

   // @RetryingTest(5)
    @Test
    @Epic("Basket")
    @Story("Adding item to the basket")
    @Owner("Xenia Bogatko")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Add and remove item in the basket")
    void addItemToBasketTest() {
        pilulkaPage
                .openPage()
                .addItemInBasket();
    }
}