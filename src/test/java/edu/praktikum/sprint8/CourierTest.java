package edu.praktikum.sprint8;

import com.github.javafaker.Faker;
import edu.praktikum.sprint8.api.ApiClient;
import edu.praktikum.sprint8.api.models.Courier;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.awaitility.Awaitility.await;

public class CourierTest {

    @Test
    public void createCourierTest() {
        Faker faker = new Faker();
        ApiClient apiClient = new ApiClient();

        Courier courier = Courier.builder()
                .login(faker.name().username())
                .password(faker.internet().password(8, 20))
                .firstName(faker.name().firstName())
                .build();

        await()
                .timeout(Duration.ofSeconds(2))
                .pollInterval(Duration.ofMillis(100))
                .until(() -> {
                    Response response = apiClient.createCourier(courier);
                    return response.statusCode() == 201;
                });
    }
}
