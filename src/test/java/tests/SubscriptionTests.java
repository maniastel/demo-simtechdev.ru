package tests;

import data.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.BlogPage;
import pages.components.SubscriptionBar;

import static io.qameta.allure.Allure.step;

@Tag("subscription")
@DisplayName("Тесты для проверки подписки на странице Блог")
public class SubscriptionTests extends TestBase {
    BlogPage blog = new BlogPage();
    SubscriptionBar subs = new SubscriptionBar();
    TestData data = new TestData();
    @BeforeEach
    public void setUp() {
        step("Открываем страницу блога", () ->
                blog.openBlogPage());
    }

    @Test
    @DisplayName("Подписка на новости компании")
    public void subscribeEmailTest() {
        step("Вводим почту пользователя", () ->
                subs.setEmail(data.email));
        step("Нажимаем кнопку Подписаться", () ->
                subs.subscribeEmail());
        step("Проверяем отображение уведомления об успешной подписке", () ->
                subs.checkSubscription());
    }

    @Test
    @DisplayName("Отправка почты неверного формата")
    public void subscribeNotCorrectEmailTest() {
        step("Вводим почту пользователя", () ->
                subs.setEmail("test@"));
        step("Нажимаем кнопку Подписаться", () ->
                subs.subscribeEmail());
        step("Проверяем отображение об ошибке", () ->
                subs.checkSubscriptionError());
    }

}
