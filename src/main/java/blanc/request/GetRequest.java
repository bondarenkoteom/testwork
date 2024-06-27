package blanc.request;

import blanc.conf.Configuration;
import blanc.service.ResponseWrapper;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static blanc.request.RequestsSpecifications.specification;

@Slf4j
public class GetRequest {

    Configuration configuration = new Configuration();

    @Step("Отправляем запрос /user/login")
    public ResponseWrapper getUserLogin(String userName, String password, String url) {
        Response response = specification()
                .baseUri(configuration.getUri())
                .accept("application/json")
                .queryParam("username", userName)
                .queryParam("password", password)
                .get("%s".formatted(url));
        log.info("Отправляем запрос - %s%s c queryParam '%s' и '%s'".formatted(configuration.getUri(), url, userName, password));
        return ResponseWrapper.of(response);
    }
}
