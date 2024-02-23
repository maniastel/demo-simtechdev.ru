package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class RequestForm {
    private final SelenideElement formTitle = $(byTagAndText("span", "Обсудим ваш проект?")),
                    nameField = $("#form-field-first_name"),
                    phoneField = $("#form-field-phone_number"),
                    emailField = $("#form-field-email"),
                    companyField = $("#form-field-field_b8ab37c"),
                    jobTitleField = $("#form-field-jon_title"),
                    requestTypeSelect = $("#form-field-type_of_request"),
                    messageField = $("#form-field-message"),
                    uploadFile = $("#form-field-field_6894ad8"),
                    submitButton = $("#submit_cta_btn");

    public void checkTitleForm () {
        formTitle.shouldHave(text("Обсудим ваш проект?"));
    }

    public void checkNameField () {
        nameField.shouldHave(attribute("type", "text"))
                .shouldHave(attribute("placeholder", "Имя *"))
                .shouldHave(attribute("required"));
    }

    public void checkPhoneField () {
        phoneField.shouldHave(attribute("type", "tel"))
                .shouldHave(attribute("placeholder", "Телефон *"))
                .shouldHave(attribute("required"));
    }

    public void checkEmailField () {
        emailField.shouldHave(attribute("type", "email"))
                .shouldHave(attribute("placeholder", "Email *"))
                .shouldHave(attribute("required"));
    }

    public void checkCompanyField () {
        companyField.shouldHave(attribute("type", "text"))
                .shouldHave(attribute("placeholder", "Компания / Сайт *"))
                .shouldHave(attribute("required"));
    }

    public void checkJobTitleField () {
        jobTitleField.shouldHave(attribute("type", "text"))
                .shouldHave(attribute("placeholder", "Должность"))
                .shouldNotHave(attribute("required"));
    }

    public void checkRequestTypeSelect () {
        requestTypeSelect.shouldHave(attribute("required"))
                .$$("option").first().shouldHave(text("Выберите услугу *"));
    }

    public void checkMessageField () {
        messageField.shouldHave(attribute("placeholder", "Опишите свою идею"))
                .shouldNotHave(attribute("required"));
    }

    public void checkUploadFile () {
        uploadFile.shouldHave(attribute("type", "file"))
                .shouldNotHave(attribute("required"));
    }

    public void checkSubmitButton () {
        submitButton.shouldHave(attribute("type", "submit"))
                .shouldHave(text("Отправить"));
    }






}
