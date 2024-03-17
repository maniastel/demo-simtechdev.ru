package configs;

import org.aeonbits.owner.Config;


@Config.Sources({
        "classpath:${env}.properties"
})
public interface WebDriverConfig extends Config {
    @Key("browser")
    @DefaultValue("CHROME")
    String browser();

    @Key("browserVersion")
    @DefaultValue("120.0")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("baseUrl")
    @DefaultValue("https://simtechdev.ru/")
    String baseUrl();

    @Key("remoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String remoteUrl();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();
}
