package tests;

import config.Auth;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junitpioneer.jupiter.RetryingTest;
import pages.MainPage;
@Epic("Login")
public class AuthorizationTests extends TestBase {
    MainPage pilulkaPage = new MainPage();

    @RetryingTest(5)
    @Owner("Xenia Bogatko")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Unsuccessful authorization")
    @DisplayName("Authorization with wrong credentials test")
    void authorizationTestNegative() {
        pilulkaPage
                .openPage()
                .loginWithError(Auth.config.username(), Auth.config.password());
    }
}