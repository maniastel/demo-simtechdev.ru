package configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
})

public interface WebDriverConfig extends Config {

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowserName();

    @Key("version")
    @DefaultValue("120.0")
    String getBrowserVersion();

    @Key("remote")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String getRemoteWebDriver();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();
}
