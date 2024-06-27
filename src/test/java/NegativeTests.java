import blanc.request.DeleteRequest;
import blanc.request.GetRequest;
import blanc.request.PostRequest;
import blanc.request.PutRequest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static blanc.utils.FileReader.readTemplate;

public class NegativeTests {

    PostRequest postRequest = new PostRequest();
    GetRequest getRequest = new GetRequest();
    DeleteRequest deleteRequest = new DeleteRequest();
    PutRequest putRequest = new PutRequest();

    @Test
    @Description("Негативный тест для post запроса user")
    public void negativePostStatusCode() {

        String id = "123154";
        String userName = "randomUserName";
        String firstName = "randomFirstName";
        String lastName = "randomLastName";
        String email = "randomEmail";
        String password = "randomPassword";
        String phone = "randomPhone";
        String url = "user1";

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
                .statusCode(404);
    }

    @Test
    @Description("Негативный тест для get запроса user")
    public void negativeGetStatusCode() {

        String id = "123174";
        String userName = "randomUserNameGet";
        String firstName = "randomFirstNameGet";
        String lastName = "randomLastNameGet";
        String email = "randomEmailGet";
        String password = "randomPasswordGet";
        String phone = "randomPhoneGet";
        String urlPost = "user";
        String urlGet = "/user/logi";

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
                .statusCode(404);
    }

    @Test
    @Description("Негативный тест для delete запроса user")
    public void negativeDeleteStatusCode() {

        String id = "16514";
        String userName = "randomDelete";
        String firstName = "randomDelete";
        String lastName = "randomDelete";
        String email = "randomDelete";
        String password = "randomDelete";
        String phone = "randomDelete";
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

        deleteRequest.deleteUser(userName, urlPost)
                .validator()
                .statusCode(404);
    }

    @Test
    @Description("Негативный тест для put запроса user")
    public void negativePutStatusCode() {

        String id = "1231151356";
        String userName = "randomNameUser";
        String firstName = "randomNameFirst";
        String lastName = "randomNameLast";
        String email = "еmailRandom";
        String password = "passwordRandom";
        String phone = "phoneRandom";
        String urlPost = "user";

        String idSecond = "152412367";
        String userNameSecond = "randomPutUser";
        String firstNameSecond = "randomPutFirst";
        String lastNameSecond = "randomPutLast";
        String emailSecond = "randomPutEmail";
        String passwordSecond = "randomPutPassword";
        String phoneSecond = "randomPutPhone";

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

        String bodySecond = readTemplate("createUserError.json")
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
                .statusCode(400);
    }
}
