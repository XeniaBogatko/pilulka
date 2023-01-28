package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
@Epic("Basket")
public class BasketTests extends TestBase {
    MainPage pilulkaPage = new MainPage();

    @Test
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
    @Story("Sales in the basket")
    @Owner("Xenia Bogatko")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Open Sales from the basket")
    void openSaleFromBasketTest() {
        pilulkaPage
                .openPage()
                .checkSalesInBasket();
    }

   // @RetryingTest(5)
    @Test
    @Story("Adding item to the basket")
    @Owner("Xenia Bogatko")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Add item into the basket")
    void addItemToBasketTest() {
        pilulkaPage
                .openPage()
                .addItemInBasket();
    }
}