package configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${env}.properties"
})
public interface WebDriverConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowserName();

    @Key("version")
    @DefaultValue("122")
    String getBrowserVersion();

    @Key("remote")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String getRemoteWebDriver();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();
}
