package blanc.service;

import io.restassured.response.Response;

import static blanc.utils.AssertionsUtils.equalInteger;

public class ResponseValidator {

    public final Response response;

    public ResponseValidator(Response response) {
        this.response = response;
    }

    public ResponseValidator statusCode(int statusCode) {
        equalInteger(response.statusCode(), statusCode, "Статус код совпадает");

        return this;
    }

}
