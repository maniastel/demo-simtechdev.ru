package tests;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.components.MainMenu;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@DisplayName("Проверка ссылок в главном меню")
public class MainMenuTests extends TestBase{
    MainMenu menu = new MainMenu();

    @BeforeEach
    public void setUp() {
        open("");
    }

    @ValueSource(strings = {
            "Решения", "Услуги", "CS-Cart", "Инфраструктура", "О компании", "Блог", "Helpdesk"
    })
    @ParameterizedTest(name = "Проверка наличия ссылки {0} в главном меню")
    @Tag("smoke")
    public void mainMenuLinksTest (String menuLink) {
        step("Проверяем название ссылки {0} в главном меню хедера", () ->
                menu.checkMenuLinks(menuLink));
    }

    @CsvFileSource(resources = "/test_data/data.csv")
    @ParameterizedTest(name = "Переход на страницу подкатегории {1} категории {0}")
    @Tag("smoke")
    public void openSubcategoryPageTest (String category, String subcategory, String title) {
        step("Выбираем подкатегорию", () ->
                menu.selectSubcategory(category, subcategory));
        step("Проверяем заголовок открытой страницы категории", () ->
                menu.checkOpenCategoryPage(title));
    }

    @ValueSource(strings = {"Helpdesk"})
    @ParameterizedTest(name = "Проверка открытия формы авторизации в Helpdesk")
    @Tag("smoke")
    public void openHelpDeskPageTest (String category) {
        step("Нажимаем на ссылку HelpDesk в главном меню", () ->
                menu.selectCategory(category));
        step("Проверяем открытие страница авторизации в HelpDesk", () ->
                menu.openHelpDeskPage());
    }


}
