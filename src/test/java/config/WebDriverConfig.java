package config;

import org.aeonbits.owner.Config;

public interface WebDriverConfig extends Config {

    @DefaultValue("https://www.pilulka.cz/")
    String baseUrl();

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("100")
    String browserVersion();

    @DefaultValue("1920x1080")
    String browserSize();

    String remote();
}