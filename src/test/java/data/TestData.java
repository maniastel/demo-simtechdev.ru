package data;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    public String email = faker.internet().emailAddress();
    public String name = faker.name().fullName();
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String phone = faker.phoneNumber().subscriberNumber(10);
    public String company = faker.company().name();
    public String jobTitle = faker.job().title();
    public String message = faker.company().profession();

    public String requestType = faker.options().option("Запуск нового магазина/маркетплейса",
            "Доработка текущего магазина/маркетплейса",
            "Интеграция внешних сервисов",
            "Миграция на CS-Cart/Multi-Vendor",
            "Хостинг и инфраструктура для CS-Cart",
            "Другое");
}
