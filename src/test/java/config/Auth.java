package config;

import org.aeonbits.owner.ConfigFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Auth {
    public static AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());

    static {
        assertThat(config.username());
        assertThat(config.password());
    }
}
