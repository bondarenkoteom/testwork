package blanc.request;

import blanc.conf.Configuration;
import blanc.service.ResponseWrapper;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static blanc.request.RequestsSpecifications.specification;

@Slf4j
public class PutRequest {

    Configuration configuration = new Configuration();

    @Step("Отправляем запрос user/{user}")
    public ResponseWrapper putUser(String body, String userName, String url) {
        Response response = specification()
                .baseUri(configuration.getUri())
                .accept("application/json")
                .contentType(ContentType.JSON)
                .pathParam("user", userName)
                .body(body)
                .put("%s/{user}".formatted(url));
        log.info("Отправляем запрос - %s%s c pathParam '%s' c телом : \n %s".formatted(configuration.getUri(), "/user", userName, body));
        return ResponseWrapper.of(response);
    }
}
