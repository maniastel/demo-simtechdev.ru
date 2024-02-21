package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.SearchResultPage;
import pages.components.SearchBar;


import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@DisplayName("Проверка поиска на странице Блог")
public class SearchBlogTests extends TestBase{

    SearchResultPage search = new SearchResultPage();
    SearchBar searchBar = new SearchBar();

    @BeforeEach
    public void setUp() {
        open("/blog");
    }

    @ValueSource(strings = {"товары", "маркетплейс"} )
    @ParameterizedTest(name = "Поиск {0} на странице Блог")
    @Tag("smoke")
    public void searchOnBlogPageTest (String searchQuery) {
        step("Вводим поисковое значение в поле поиска", () ->
                searchBar.setSearchQuery(searchQuery));
        step("Проверяем, что результат поиска больше 0", () ->
                search.checkSearchResult(searchQuery));
    }

    @ValueSource(strings = {"продукт"})
    @ParameterizedTest(name = "Открытие статьи на странице результата поиска статей по: {0}")
    @Tag("smoke")
    public void openBlogArticleOnSearchResultPageTest (String searchQuery) {
        step("Вводим поисковое значение в поле поиска", () ->
                searchBar.setSearchQuery(searchQuery));
        step("Проверяем, что результат поиска больше 0", () ->
                search.checkSearchResult(searchQuery));
        step("Нажимаем на первую статью в списке результата поиска", () ->
                search.openFirstArticlePage());
        step("Проверяем открытие страницы статьи", () ->
                search.checkArticlePage());
    }

}
