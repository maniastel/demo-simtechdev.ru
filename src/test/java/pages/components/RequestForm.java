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
                    submitButton = $("#submit_cta_btn"),
                    successfulMessage = $(".elementor-message.elementor-message-success");

    public void checkTitleForm () {
        formTitle.shouldHave(text("Обсудим ваш проект?"));
    }

    public void fillNameField (String name) {
        nameField.setValue(name);
    }

    public void fillPhoneField (String phone) {
        phoneField.setValue(phone);
    }

    public void fillEmailField (String email) {
        emailField.setValue(email);
    }

    public void fillCompanyField (String company) {
        companyField.setValue(company);
    }

    public void fillJobTitleField (String jobTitle) {
        jobTitleField.setValue(jobTitle);
    }

    public void selectRequestType (String option) {
        requestTypeSelect.selectOptionByValue(option);
    }

    public void fillMessageField (String message) {
        messageField.setValue(message);
    }

    public void uploadFile (String file) {
        uploadFile.uploadFromClasspath(file);
    }

    public void sendForm () {
        submitButton.click();
    }

    public void checkSendForm () {
        successfulMessage.shouldHave(text("Спасибо! Мы получили ваше сообщение"));
    }
}
