package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverProvider {
    static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static void config() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = WebDriverProvider.config.baseUrl();
        Configuration.browser = WebDriverProvider.config.browser();
        Configuration.browserVersion = WebDriverProvider.config.browserVersion();
        Configuration.browserSize = WebDriverProvider.config.browserSize();

        String remoteUrl = WebDriverProvider.config.remote();

        if (remoteUrl != null) {
            Configuration.remote = remoteUrl;
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }
    }
}