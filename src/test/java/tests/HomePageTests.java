package tests;

import data.TestData;
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
     TestData data = new TestData();

    @BeforeEach
    public void setUp() {
        step("Открываем домашнюю страницу", () ->
                hp.openHomePage());
    }

     @DisplayName("Принятие соглашение об использовании cookie")
     @Test
     public void cookiePopupTest () {
         step("Проверяем отображение попапа cookie", () ->
                 cookie.checkCookiePopupDisplay());
         step("Принимаем cookie", () ->
                 cookie.acceptCookie());
     }

     @DisplayName("Отправка формы с заполнением всех полей")
     @Test
     public void successfulFormSendTest() {
         step("Нажимаем на кнопку Оставить заявку", () ->
                 menu.clickOnFormButton());
         step("Проверяем название заголовка формы", () ->
                 form.checkTitleForm());
         step("Заполняем поле Имя", () ->
                 form.fillNameField(data.name));
         step("Заполняем поле Телефон", () ->
                 form.fillPhoneField(data.phone));
         step("Заполняем поле Email", () ->
                 form.fillEmailField(data.email));
         step("Заполняем поле Компания/Сайт", () ->
                 form.fillCompanyField(data.company));
         step("Заполняем поле Должность", () ->
                 form.fillJobTitleField(data.jobTitle));
         step("Выбираем значение из выпадающего списка выбора услуги", () ->
                 form.selectRequestType(data.requestType));
         step("Заполняем поле Описание", () ->
                 form.fillMessageField(data.message));
         step("Загружаем файл", () ->
                 form.uploadFile("pdf-test.pdf"));
         step("Нажимаем на кнопку Отправить", () ->
                 form.sendForm());
         step("Проверяем сообщение об успешной отправке формы", () ->
                 form.checkSendForm());
     }

     @DisplayName("Проверка отображение топ баннера с ссылкой на страницу Продвижение интернет-магазина с формой обратной связи")
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
         step("Заполняем поле Имя", () ->
                 page.fillFirstNameField(data.firstName));
         step("Заполняем поле Фамилия", () ->
                 page.fillLastNameField(data.lastName));
         step("Заполняем поле Email", () ->
                 page.fillEmailField(data.email));
         step("Заполняем поле Компания", () ->
                 page.fillCompanyField(data.company));
         step("Нажимаем на кнопку Отправить", () ->
                 page.sendForm());
         step("Проверяем сообщение об успешной отправке формы", () ->
                 page.checkSendForm());
     }

}
