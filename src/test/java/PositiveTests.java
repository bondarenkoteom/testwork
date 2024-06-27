import blanc.request.DeleteRequest;
import blanc.request.GetRequest;
import blanc.request.PostRequest;
import blanc.request.PutRequest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static blanc.utils.FileReader.readTemplate;

public class PositiveTests {

    PostRequest postRequest = new PostRequest();
    GetRequest getRequest = new GetRequest();
    DeleteRequest deleteRequest = new DeleteRequest();
    PutRequest putRequest = new PutRequest();

    @Test
    @Description("Позитивный тест для post запроса user")
    public void positivePostStatusCode() {

        String id = "123154";
        String userName = "randomUserName";
        String firstName = "randomFirstName";
        String lastName = "randomLastName";
        String email = "randomEmail";
        String password = "randomPassword";
        String phone = "randomPhone";
        String url = "user";

        String body = readTemplate("createUser.json")
                .set("id", id)
                .set("username", userName)
                .set("firstName", firstName)
                .set("lastName", lastName)
                .set("email", email)
                .set("password", password)
                .set("phone", phone)
                .text();

        postRequest.postUser(body, url)
                .validator()
                .statusCode(200);
    }

    @Test
    @Description("Позитивный тест для get запроса user")
    public void positiveGetStatusCode() {

        String id = "123154124";
        String userName = "randomUserGet";
        String firstName = "randomFirstGet";
        String lastName = "randomLastGet";
        String email = "randomEmailGet";
        String password = "randomPasswordGet";
        String phone = "randomPhoneGet";
        String urlPost = "user";
        String urlGet = "/user/login";

        String body = readTemplate("createUser.json")
                .set("id", id)
                .set("username", userName)
                .set("firstName", firstName)
                .set("lastName", lastName)
                .set("email", email)
                .set("password", password)
                .set("phone", phone)
                .text();

        postRequest.postUser(body, urlPost)
                .validator()
                .statusCode(200);

        getRequest.getUserLogin(userName, password, urlGet)
                .validator()
                .statusCode(200);
    }

    @Test
    @Description("Позитивный тест для delete запроса user")
    public void positiveDeleteStatusCode() {

        String id = "154124";
        String userName = "randomUserDelete";
        String firstName = "randomFirstDelete";
        String lastName = "randomLastDelete";
        String email = "randomEmailDelete";
        String password = "randomPasswordDelete";
        String phone = "randomPhoneDelete";
        String urlPost = "user";

        String body = readTemplate("createUser.json")
                .set("id", id)
                .set("username", userName)
                .set("firstName", firstName)
                .set("lastName", lastName)
                .set("email", email)
                .set("password", password)
                .set("phone", phone)
                .text();

        postRequest.postUser(body, urlPost)
                .validator()
                .statusCode(200);

        deleteRequest.deleteUser(userName, urlPost)
                .validator()
                .statusCode(200);
    }

    @Test
    @Description("Позитивный тест для put запроса user")
    public void positivePutStatusCode() {

        String id = "123154";
        String userName = "randomUserName";
        String firstName = "randomFirstName";
        String lastName = "randomLastName";
        String email = "randomEmail";
        String password = "randomPassword";
        String phone = "randomPhone";
        String urlPost = "user";

        String idSecond = "152165412367";
        String userNameSecond = "randomUserPut";
        String firstNameSecond = "randomFirstPut";
        String lastNameSecond = "randomLastPut";
        String emailSecond = "randomEmailPut";
        String passwordSecond = "randomPasswordPut";
        String phoneSecond = "randomPhonePut";

        String body = readTemplate("createUser.json")
                .set("id", id)
                .set("username", userName)
                .set("firstName", firstName)
                .set("lastName", lastName)
                .set("email", email)
                .set("password", password)
                .set("phone", phone)
                .text();

        postRequest.postUser(body, urlPost)
                .validator()
                .statusCode(200);

        String bodySecond = readTemplate("createUser.json")
                .set("id", idSecond)
                .set("username", userNameSecond)
                .set("firstName", firstNameSecond)
                .set("lastName", lastNameSecond)
                .set("email", emailSecond)
                .set("password", passwordSecond)
                .set("phone", phoneSecond)
                .text();

        putRequest.putUser(bodySecond, userName, urlPost)
                .validator()
                .statusCode(200);
    }
}
