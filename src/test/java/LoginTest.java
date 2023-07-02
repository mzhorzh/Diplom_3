import API.CreateUserRequest;
import Client.UserClient;
import Core.Annotations;
import Dataprovider.UserProvider;
import PageObjects.ForgotPasswordPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends Annotations {
    private UserClient userClient;
    private String accessToken;
    private CreateUserRequest createUserRequest;

    @Test
    @DisplayName("Вход через кнопку Войти в аккаунт в середине сайта")
    @Description("После упешной авторизации должен произойти редирект на главную страницу")
    public void loginWithLoginButtonTest() {
        userClient = new UserClient();
        createUserRequest = UserProvider.getRandomUser();
        ValidatableResponse response = userClient.createUser(createUserRequest);
        accessToken = response.extract().path("accessToken");
        HomePage objHomePage = new HomePage();
        objHomePage.loginButtonClick();
        LoginPage objLoginPage = new LoginPage();
        objLoginPage.fillLoginForm(createUserRequest.getEmail(), createUserRequest.getPassword());
        objLoginPage.loginButtonClick();
        boolean isVisibleHomePage = objHomePage.visibleHomePage();
        Assert.assertTrue(isVisibleHomePage);
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    @Description("После упешной авторизации должен произойти редирект на главную страницу")
    public void loginWithPersonalAreaButtonTest() {
        userClient = new UserClient();
        createUserRequest = UserProvider.getRandomUser();
        ValidatableResponse response = userClient.createUser(createUserRequest);
        accessToken = response.extract().path("accessToken");
        HomePage objHomePage = new HomePage();
        objHomePage.personalAreaButtonClick();
        LoginPage objLoginPage = new LoginPage();
        objLoginPage.fillLoginForm(createUserRequest.getEmail(), createUserRequest.getPassword());
        objLoginPage.loginButtonClick();
        boolean isVisibleHomePage = objHomePage.visibleHomePage();
        Assert.assertTrue(isVisibleHomePage);
    }

    @Test
    @DisplayName("Вход через кнопку Войти на странице ррегистрации")
    @Description("После упешной авторизации должен произойти редирект на главную страницу")
    public void loginWithRegisterFormButtonTest() {
        userClient = new UserClient();
        createUserRequest = UserProvider.getRandomUser();
        ValidatableResponse response = userClient.createUser(createUserRequest);
        accessToken = response.extract().path("accessToken");
        HomePage objHomePage = new HomePage();
        objHomePage.loginButtonClick();
        LoginPage objLoginPage = new LoginPage();
        objLoginPage.registerButtonClick();
        RegisterPage objRegisterPage = new RegisterPage();
        objRegisterPage.loginButtonClick();
        objLoginPage.fillLoginForm(createUserRequest.getEmail(), createUserRequest.getPassword());
        objLoginPage.loginButtonClick();
        boolean isVisibleHomePage = objHomePage.visibleHomePage();
        Assert.assertTrue(isVisibleHomePage);
    }

    @Test
    @DisplayName("Вход через кнопку Войти на странице восстановления пароля")
    @Description("После упешной авторизации должен произойти редирект на главную страницу")
    public void loginWithForgotPasswordFormButtonTest() {
        userClient = new UserClient();
        createUserRequest = UserProvider.getRandomUser();
        ValidatableResponse response = userClient.createUser(createUserRequest);
        accessToken = response.extract().path("accessToken");
        HomePage objHomePage = new HomePage();
        objHomePage.loginButtonClick();
        LoginPage objLoginPage = new LoginPage();
        objLoginPage.forgotPasswordButtonClick();
        ForgotPasswordPage objForgotPasswordPage = new ForgotPasswordPage();
        objForgotPasswordPage.loginButtonClick();
        objLoginPage.fillLoginForm(createUserRequest.getEmail(), createUserRequest.getPassword());
        objLoginPage.loginButtonClick();
        boolean isVisibleHomePage = objHomePage.visibleHomePage();
        Assert.assertTrue(isVisibleHomePage);
    }

    @After
    public void deleteUer() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
    }
}
