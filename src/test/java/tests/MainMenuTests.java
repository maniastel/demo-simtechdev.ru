package tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.HomePage;
import pages.components.MainMenu;

import static io.qameta.allure.Allure.step;

@Tag("main_menu")
@DisplayName("Проверка ссылок в главном меню")
public class MainMenuTests extends TestBase{
    MainMenu menu = new MainMenu();
    HomePage hp = new HomePage();

    @BeforeEach
    public void setUp() {
        step("Открываем домашнюю страницу", () ->
                hp.openHomePage());
    }

    @ValueSource(strings = {
            "Решения", "Услуги", "CS-Cart", "Инфраструктура", "О компании", "Блог", "Helpdesk"
    })
    @ParameterizedTest(name = "Проверка наличия ссылки {0} в главном меню")
    public void mainMenuLinksTest (String menuLink) {
        step("Проверяем название ссылки {0} в главном меню хедера", () ->
                menu.checkMenuLinks(menuLink));
    }

    @CsvFileSource(resources = "/test_data/data.csv")
    @ParameterizedTest(name = "Переход на страницу подкатегории {1} категории {0}")
    public void openSubcategoryPageTest (String category, String subcategory, String title) {
        step("Выбираем подкатегорию", () ->
                menu.selectSubcategory(category, subcategory));
        step("Проверяем заголовок открытой страницы категории", () ->
                menu.checkOpenCategoryPage(title));
    }

    @DisplayName("Проверка открытия формы авторизации в Helpdesk")
    public void openHelpDeskPageTest (String category) {
        step("Нажимаем на ссылку HelpDesk в главном меню", () ->
                menu.selectCategory("HelpDesk"));
        step("Проверяем открытие страница авторизации в HelpDesk", () ->
                menu.openHelpDeskPage());
    }


}
