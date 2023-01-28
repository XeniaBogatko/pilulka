package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junitpioneer.jupiter.RetryingTest;
import pages.MainPage;
@Epic("Search")
@Feature("Search a item by typing")
public class SearchTests extends TestBase {
    MainPage pilulkaPage = new MainPage();

    @RetryingTest(5)
    @Owner("Xenia Bogatko")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Search for Nurofen")
    void itemSearchTest() {
        pilulkaPage
                .openPage()
                .search("nurofen")
                .checkInSearchResults("Nurofen 200 mg 24 tablet");
    }
}