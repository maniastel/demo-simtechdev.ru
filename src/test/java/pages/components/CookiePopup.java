package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class CookiePopup {
    private final SelenideElement cookiePopup = $("#elementor-popup-modal-22363"),
                    acceptButton = $(byTagAndText("span", "Согласен"));

    public void checkCookiePopupDisplay () {
        cookiePopup.shouldBe(visible);
    }

    public void acceptCookie () {
        acceptButton.click();
        cookiePopup.shouldHave(attribute("style", "display: none;"));
    }
}
