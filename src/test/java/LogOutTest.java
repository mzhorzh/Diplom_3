import API.CreateUserRequest;
import Client.UserClient;
import Core.Annotations;
import Dataprovider.UserProvider;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.PersonalAreaPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;

public class LogOutTest extends Annotations {
    private UserClient userClient;
    private String accessToken;
    private CreateUserRequest createUserRequest;

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Должна отобразиться страница входа")
    public void logOutFromPersonalAreaTest() {
        userClient = new UserClient();
        createUserRequest = UserProvider.getRandomUser();
        ValidatableResponse response = userClient.createUser(createUserRequest);
        accessToken = response.extract().path("accessToken");
        HomePage objHomePage = new HomePage();
        objHomePage.loginButtonClick();
        LoginPage objLoginPage = new LoginPage();
        objLoginPage.fillLoginForm(createUserRequest.getEmail(), createUserRequest.getPassword());
        objLoginPage.loginButtonClick();
        objHomePage.personalAreaButtonClick();
        PersonalAreaPage objPersonalAreaPage = new PersonalAreaPage();
        objPersonalAreaPage.logOutButtonClick();
        boolean isVisibleLoginPage = objLoginPage.visibleLoginPage();
        Assert.assertTrue(isVisibleLoginPage);
        userClient.deleteUser(accessToken);
    }
}
