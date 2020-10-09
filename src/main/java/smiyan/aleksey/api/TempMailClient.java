package smiyan.aleksey.api;

import io.restassured.specification.RequestSpecification;
import smiyan.aleksey.pojo.Mail;

import java.util.List;

import static io.restassured.RestAssured.given;

public class TempMailClient {

    private final RequestSpecification requestSpecification;

    public TempMailClient(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    private <T> List<T> getResources(String path, Class<T> resource) {
        return given()
                .spec(requestSpecification)
                .when()
                .get(path)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("", resource);
    }

    public List<String> getDomains() {
        return getResources("domains/", String.class);
    }

    public List<Mail> getMails(String emailHash) {
        return getResources("mail/id/" + emailHash + "/", Mail.class);
    }
}
