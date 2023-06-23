package Client;

import API.CreateUserRequest;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient extends BaseClient {
    public static final String CREATE_URI="/api/auth/register";
    public static final String USER_DATA_URI ="/api/auth/user ";

    @Step("Создание пользователя")
    public ValidatableResponse createUser(CreateUserRequest createUserRequest){
        return  given()
                .spec(getSpec())
                .body(createUserRequest)
                .when()
                .post(CREATE_URI)
                .then();

    }

    @Step("Удаление пользователя")
    public void deleteUser(String accessToken){
        given()
                .header("authorization",accessToken)
                .spec(getSpec())
                .when()
                .delete(USER_DATA_URI);
    }
}
