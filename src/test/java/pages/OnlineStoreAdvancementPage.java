package pages;

import com.codeborne.selenide.SelenideElement;

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
            successfulMessage = $(".elementor-message.elementor-message-success");
    String pageUrl = "/prodvizhenie-internet-magazina/";

    public void checkPageOpen () {
        switchTo().window(1);
        webdriver().shouldHave(currentFrameUrl(baseUrl + pageUrl));
    }

    public void checkPageTitle () {
        titlePage.shouldHave(text("Продвижение интернет‑магазина"));
    }

    public void fillFirstNameField (String firstName) {
        firstNameField.setValue(firstName);
    }

    public void fillLastNameField (String lastName) {
       lastNameField.setValue(lastName);
    }

    public void fillEmailField (String email) {
        emailField.setValue(email);
    }

    public void fillCompanyField (String company) {
        companyField.setValue(company);
    }

    public void sendForm () {
        submitButton.click();
    }

    public void checkSendForm () {
        successfulMessage.shouldHave(text("Спасибо! Мы отправили руководство по продвижению интернет-магазина на вашу электронную почту."));
    }
}
