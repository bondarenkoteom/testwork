package blanc.request;

import blanc.conf.Configuration;
import blanc.service.ResponseWrapper;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static blanc.request.RequestsSpecifications.specification;

@Slf4j
public class PostRequest {

    Configuration configuration = new Configuration();

    @Step("Отправляем запрос /user")
    public ResponseWrapper postUser(String body, String url) {
        Response response = specification()
                .baseUri(configuration.getUri())
                .accept("application/json")
                .contentType(ContentType.JSON)
                .body(body)
                .post("%s".formatted(url));
        log.info("Отправляем запрос - %s%s c телом : \n %s".formatted(configuration.getUri(), "/user", body));
        return ResponseWrapper.of(response);
    }
}
