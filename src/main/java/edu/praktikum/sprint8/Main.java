package edu.praktikum.sprint8;

import com.github.javafaker.Faker;
import edu.praktikum.sprint8.api.models.Courier;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        fakerExamples();
        lombokExamples();
    }

    private static void fakerExamples() {
        Faker faker = new Faker(Locale.forLanguageTag("ru"));

        System.out.println(faker.name().fullName());
        System.out.println(faker.name().username());

        System.out.println(faker.number().digit());
        System.out.println(faker.number().randomDigitNotZero());
        System.out.println(faker.number().numberBetween(20, 100));

        System.out.println(faker.phoneNumber().phoneNumber());
        System.out.println(faker.phoneNumber().cellPhone());

        System.out.println(faker.address().fullAddress());
        System.out.println(faker.address().secondaryAddress());

        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.internet().safeEmailAddress());

        System.out.println(faker.internet().password(4, 12));

        System.out.println(faker.letterify("Tg: ????-????"));
        System.out.println(faker.numerify("Phone: +7 (###) ###-##-##"));
        System.out.println(faker.bothify("Tg: ????-????, Phone: +7 (###) ###-##-##"));

        System.out.println(faker.lebowski().quote());
        System.out.println(faker.chuckNorris().fact());
    }

    private static void lombokExamples() {
        Faker faker = new Faker();

        Courier courier = Courier.builder()
                .login(faker.name().username())
                .password(faker.internet().password(8, 20))
                .firstName(faker.name().firstName())
                .build();

        System.out.println(courier.getLogin());
        System.out.println(courier.getPassword());
        System.out.println(courier.getFirstName());
    }
}
