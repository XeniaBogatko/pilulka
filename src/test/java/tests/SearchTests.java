package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junitpioneer.jupiter.RetryingTest;
import pages.PilulkaMainPage;

public class SearchTests extends TestBase {
    PilulkaMainPage pilulkaPage = new PilulkaMainPage();

    @RetryingTest(5)
    @Epic("Search")
    @Owner("Xenia Bogatko")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Search a item by typing")
    @DisplayName("Search for Nurofen")
    void itemSearchTest() {
        pilulkaPage
                .openPage()
                .search("nurofen")
                .checkInSearchResults("Nurofen 200 mg 24 tablet");
    }
}