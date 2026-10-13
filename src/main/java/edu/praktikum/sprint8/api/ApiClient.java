package edu.praktikum.sprint8.api;

import edu.praktikum.sprint8.api.models.Courier;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class ApiClient {

    private static final String API_V1_COURIER = "/api/v1/courier";

    public ApiClient() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru/";
    }

    public Response createCourier(Courier courier) {
        return given().log().all()
                .contentType(JSON)
                .body(courier)
                .post(API_V1_COURIER)
                .prettyPeek();
    }
}
