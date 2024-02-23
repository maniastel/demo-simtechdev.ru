package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SubscriptionBar {
    private final SelenideElement emailInput = $(".b-unisender-field__input"),
                                  submitButton = $(".b-unisender-form__submit-button"),
                                  successMessage = $(".b-unisender-form__messages"),
                                  errorMessage = $(".b-unisender-form__message.b-unisender-form__message_validation-error-text.b-unisender-form__message_error");

    public SubscriptionBar setEmail (String email) {
        emailInput.setValue(email);
        return this;
    }

    public void subscribeEmail() {
        submitButton.click();
    }

    public void checkSubscription() {
        successMessage.shouldHave(text("Спасибо за подписку!"));
    }

    public void checkSubscriptionError() {
        errorMessage.shouldHave(text("Поле содержит ошибку. Пожалуйста, проверьте и попробуйте снова"));
    }
}
