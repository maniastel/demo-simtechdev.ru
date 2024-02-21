package tests;

import org.junit.jupiter.api.*;
import pages.HomePage;
import pages.OnlineStoreAdvancementPage;
import pages.components.CookiePopup;
import pages.components.MainMenu;
import pages.components.RequestForm;
import pages.components.TopBanner;

import static io.qameta.allure.Allure.step;

@Tag("homepage")
@DisplayName("Тесты для домашней страницы")
public class HomePageTests extends TestBase {
     MainMenu menu = new MainMenu();
     RequestForm form = new RequestForm();
     CookiePopup cookie = new CookiePopup();
     TopBanner  banner = new TopBanner();
     HomePage hp = new HomePage();
     OnlineStoreAdvancementPage page = new OnlineStoreAdvancementPage();

    @BeforeEach
    public void setUp() {
        step("Открываем домашнюю страницу", () ->
                hp.openHomePage());
    }

     @DisplayName("Принятие соглашение об использовании cookie")
     @Tag("smoke")
     @Test
     public void cookiePopupTest () {
         step("Проверяем отображение попапа cookie", () ->
                 cookie.checkCookiePopupDisplay());
         step("Принимаем cookie", () ->
                 cookie.acceptCookie());
     }

     @DisplayName("Отображение названий полей формы отправки запроса")
     @Tag("smoke")
     @Test
     public void formFieldShouldBeExpectedTest() {
         step("Нажимаем на кнопку Оставить заявку", () ->
                 menu.clickOnFormButton());
         step("Проверяем название заголовка формы", () ->
                 form.checkTitleForm());
         step("Проверяем поле Имя на наличие обязательных атрибутов", () ->
                 form.checkNameField());
         step("Проверяем поле Телефон на наличие обязательных атрибутов", () ->
                 form.checkPhoneField());
         step("Проверяем поле Email на наличие обязательных атрибутов", () ->
                 form.checkEmailField());
         step("Проверяем поле Компания/Сайт на наличие обязательных атрибутов", () ->
                 form.checkCompanyField());
         step("Проверяем поле Должность на наличие обязательных атрибутов", () ->
                 form.checkJobTitleField());
         step("Проверяем выпадающий список выбора услуги на наличие обязательных атрибутов", () ->
                 form.checkRequestTypeSelect());
         step("Проверяем поле Описание на наличие обязательных атрибутов", () ->
                 form.checkMessageField());
         step("Проверяем поле загрузки файла на наличие обязательных атрибутов", () ->
                 form.checkUploadFile());
         step("Проверяем кнопку Отправить на наличие обязательных атрибутов", () ->
                 form.checkSubmitButton());
     }

     @DisplayName("Отображение топ баннера с ссылкой")
     @Tag("smoke")
     @Test
     public void topBannerTest () {
         step("Проверяем отображение топ баннера", () ->
                 banner.checkTopBannerDisplay());
         step("Нажимаем на кнопку Получить руководство", () ->
                 banner.clickBannerButton());
         step("Проверяем открытие страницы Продвижение интернет-магазина", () ->
                 page.checkPageOpen());
         step("Проверяем название заголовка страницы", () ->
                 page.checkPageTitle());
         step("Проверяем поле Имя на наличие обязательных атрибутов", () ->
                 page.checkFirstNameField());
         step("Проверяем поле Фамилия на наличие обязательных атрибутов", () ->
                 page.checkLastNameField());
         step("Проверяем поле Email на наличие обязательных атрибутов", () ->
                 page.checkEmailField());
         step("Проверяем поле Компания на наличие обязательных атрибутов", () ->
                 page.checkCompanyField());
         step("Проверяем чекбокс подписки на наличие обязательных атрибутов", () ->
                 page.checkSubsCheckbox());
         step("Проверяем кнопку Отправить на наличие обязательных атрибутов", () ->
                 page.checkSubmitButton());
     }

}
