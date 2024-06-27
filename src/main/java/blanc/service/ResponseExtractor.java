package blanc.service;

import io.restassured.response.Response;

import static blanc.utils.PathReader.convertToString;
import static blanc.utils.PathReader.jsonPathRead;

public class ResponseExtractor {

    private final Response response;

    public ResponseExtractor(Response response) {
        this.response = response;
    }

    public String jsonPath(String path) {
        String json = getBody();
        return convertToString(jsonPathRead(json,path));

    }

    private synchronized String getBody() {
        return response.getBody().asString();
    }

    @Override
    public String toString() {
        return getBody();
    }
}
