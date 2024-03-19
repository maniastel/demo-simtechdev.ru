package configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${env}.properties",
})
public interface WebDriverConfig extends Config {
    @Key("baseUrl")
   // @DefaultValue("https://simtechdev.ru")
    String getBaseUrl();

    @Key("browser.name")
  //  @DefaultValue("chrome")
    String getBrowserName();

    @Key("version")
//    @DefaultValue("122.0")
    String getBrowserVersion();

    @Key("browserSize")
//    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("remoteUrl")
//    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String getRemoteUrl();

    @DefaultValue("false")
    boolean isRemote();
}
