package data;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    public String email = faker.internet().emailAddress();
}
