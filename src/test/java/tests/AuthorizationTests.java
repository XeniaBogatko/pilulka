package tests;

import config.Auth;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junitpioneer.jupiter.RetryingTest;
import pages.PilulkaMainPage;

public class AuthorizationTests extends TestBase {
    PilulkaMainPage pilulkaPage = new PilulkaMainPage();

    @RetryingTest(5)
    @Owner("Xenia Bogatko")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Unsuccessful authorization")
    @DisplayName("Authorization with wrong credentials test")
    void authorizationTestNegative() {
        pilulkaPage
                .openPage()
                .loginWithError(Auth.config.login(), Auth.config.pass());
    }
}