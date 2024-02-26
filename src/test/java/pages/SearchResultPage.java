package pages;

import com.codeborne.selenide.CollectionCondition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {


    public SearchResultPage checkSearchResult (String searchQuery) {
        $("h1").shouldHave(text(searchQuery));
        $$("article").shouldHave(CollectionCondition.sizeGreaterThan(0));
        return this;
    }

    public void openFirstArticlePage () {
        $$("h3").first().click();
    }

    public void checkArticlePage () {
        $(byAttribute("data-elementor-type", "single-post")).shouldBe(visible);
    }


}
