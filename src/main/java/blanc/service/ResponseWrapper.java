package blanc.service;

import io.restassured.response.Response;

public class ResponseWrapper {

    private final Response response;

    private ResponseWrapper(Response response) {
        this.response = response;
    }

    public static ResponseWrapper of(Response response) {
        return new ResponseWrapper(response);
    }

    public ResponseValidator validator() {
        return new ResponseValidator(response);
    }

    public ResponseExtractor extractor() {
        return new ResponseExtractor(response);
    }

    private synchronized String getBody(){
        return response.getBody().asString();
    }

    @Override
    public String toString() {
        return getBody();
    }
}
