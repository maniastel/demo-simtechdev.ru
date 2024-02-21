package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.TopBanner;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;

public class OnlineStoreAdvancementPage {

    SelenideElement titlePage = $(byTagAndText("h1", "Продвижение интернет‑магазина")),
            firstNameField = $("#form-field-first_name"),
            lastNameField = $("#form-field-last_name"),
            emailField = $("#form-field-email"),
            companyField = $("#form-field-company_name"),
            submitButton = $(".elementor-button.elementor-size-sm"),
            subsCheckbox = $("#form-field-checkbox-0");
    String pageUrl = "/prodvizhenie-internet-magazina/";

    public void checkPageOpen () {
        switchTo().window(1);
        webdriver().shouldHave(currentFrameUrl(baseUrl + pageUrl));
    }

    public void checkPageTitle () {
        titlePage.shouldHave(text("Продвижение интернет‑магазина"));
    }

    public void checkFirstNameField () {
        firstNameField.shouldHave(attribute("type", "text"))
                .shouldHave(attribute("placeholder", "Имя *"))
                .shouldHave(attribute("required"));
    }

    public void checkLastNameField () {
       lastNameField.shouldHave(attribute("type", "text"))
                .shouldHave(attribute("placeholder", "Фамилия *"))
                .shouldHave(attribute("required"));
    }

    public void checkEmailField () {
        emailField.shouldHave(attribute("type", "email"))
                .shouldHave(attribute("placeholder", "Email *"))
                .shouldHave(attribute("required"));
    }

    public void checkCompanyField () {
        companyField.shouldHave(attribute("type", "text"))
                .shouldHave(attribute("placeholder", "Компания"))
                .shouldNotHave(attribute("required"));
    }

    public void checkSubsCheckbox () {
        subsCheckbox.shouldHave(attribute("type", "checkbox"))
                .shouldHave(attribute("value", "Хочу получить бесплатную консультацию eCom-эксперта"))
                .shouldNotHave(attribute("required"))
                .shouldNotBe(checked);
    }

    public void checkSubmitButton () {
        submitButton.shouldHave(attribute("type", "submit"))
                .shouldHave(text("Получить руководство"));
    }

    public void closePage () {
        closeWindow();
        switchTo().window(0);
    }
}
