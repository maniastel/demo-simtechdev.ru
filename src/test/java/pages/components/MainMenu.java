package pages.components;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;

public class MainMenu {

    private final SelenideElement formButton = $(byTagAndText("span", "Оставить заявку"));
    private final String hdUrl = "https://helpdesk.simtechdev.com/index.php?dispatch=auth.login_form";

    public MainMenu checkMenuLinks (String menuLink) {
        $$("ul.elementskit-navbar-nav.elementskit-menu-po-left.submenu-click-on-icon").shouldHave(texts(menuLink));
        return this;
    }

    public MainMenu selectSubcategory (String category, String subcategory) {
        $(withTagAndText("a", category)).hover();
        $(withTagAndText("span", subcategory)).shouldBe(visible);
        $(withTagAndText("span", subcategory)).click();
        return this;
    }

    public MainMenu checkOpenCategoryPage(String title)  {
        $("h1").shouldHave(text(title));
        return this;
    }

    public MainMenu selectCategory (String category) {
        $(withTagAndText("a", category)).click();
        return this;
    }

    public void openHelpDeskPage () {
        switchTo().window(1);
        webdriver().shouldHave(urlStartingWith(hdUrl));
        $("h1").shouldHave(text("Sign in"));
    }

    public void clickOnFormButton () {
        formButton.click();
    }

}
