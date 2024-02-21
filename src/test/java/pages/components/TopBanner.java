package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class TopBanner {
    SelenideElement banner = $(".elementor-sticky--effects.elementor-sticky--active.elementor-section--handles-inside"),
                    bannerButton = $(byTagAndText("div", "Получить руководство"));

    public void checkTopBannerDisplay () {
        banner.shouldBe(visible);
    }

    public void clickBannerButton () {
        bannerButton.click();
    }
}
