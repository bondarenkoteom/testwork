package blanc.request;


import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RequestsSpecifications {

    public static RequestSpecification specification() {
        return given().relaxedHTTPSValidation();
    }
}
