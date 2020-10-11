package smiyan.aleksey.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import smiyan.aleksey.util.Config;

public class RequestSpecifications {

    public static RequestSpecification getTempMailSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri("https://" + Config.getRapidApiHost() + "/request/")
                .addHeader("X-RapidAPI-Host", Config.getRapidApiHost())
                .addHeader("x-rapidapi-key", Config.getRapidApiKey())
                .build();
    }
}
