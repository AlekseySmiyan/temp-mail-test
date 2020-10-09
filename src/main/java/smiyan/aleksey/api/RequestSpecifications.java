package smiyan.aleksey.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import smiyan.aleksey.util.Config;

public class RequestSpecifications {

    private static final Config config = Config.DEFAULT;

    public static RequestSpecification getTempMailSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri("https://" + config.getRapidApiHost() + "/request/")
                .addHeader("X-RapidAPI-Host", config.getRapidApiHost())
                .addHeader("x-rapidapi-key", config.getRapidApiKey())
                .build();
    }
}
