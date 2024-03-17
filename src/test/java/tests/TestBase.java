package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configs.WebDriverConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.util.Arrays;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


public class TestBase {
    @BeforeAll
    static void beforeAll() {
        WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

        Configuration.baseUrl = webDriverConfig.baseUrl();
        Configuration.browser = webDriverConfig.browser();
        Configuration.browserVersion = webDriverConfig.browserVersion();
        Configuration.browserSize = webDriverConfig.browserSize();
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 3000;

        if (webDriverConfig.isRemote()) {
            Configuration.remote = String.valueOf(webDriverConfig.remoteUrl());
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true,
                    "env", Arrays.asList("LANG=ru_RU.UTF-8", "LANGUAGE=ru:ru", "LC_ALL=ru_RU.UTF=8")
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open("");
    }


    @AfterEach
    void addAttachment() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
