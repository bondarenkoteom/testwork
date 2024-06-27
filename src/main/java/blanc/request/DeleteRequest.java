package blanc.request;

import blanc.conf.Configuration;
import blanc.service.ResponseWrapper;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static blanc.request.RequestsSpecifications.specification;

@Slf4j
public class DeleteRequest {

    Configuration configuration = new Configuration();

    @Step("Отправляем запрос /user/{user}")
    public ResponseWrapper deleteUser(String userName, String url) {
        Response response = specification()
                .baseUri(configuration.getUri())
                .accept("application/json")
                .pathParam("user", userName)
                .delete("%s/{user}".formatted(url));
        log.info("Отправляем запрос - %s%s c pathParam '%s'".formatted(configuration.getUri(), url, userName));
        return ResponseWrapper.of(response);
    }
}
