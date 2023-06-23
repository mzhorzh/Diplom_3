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

public class OpenPersonalAccountTest extends Annotations {
    private UserClient userClient;
    private String accessToken;
    private CreateUserRequest createUserRequest;

    @Test
    @DisplayName("Переход в Личный кабинет")
    @Description("Должна отобразиться страница Личного кабинета")
    public void goToPersonalAccountPageFromHomePage() {
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
        PersonalAreaPage objPersonalArea= new PersonalAreaPage();
        boolean isDisplayedTextInPersonalAreaPage = objPersonalArea.isDisplayedText();
        Assert.assertTrue(isDisplayedTextInPersonalAreaPage);
        userClient.deleteUser(accessToken);
    }

    @Test
    @DisplayName("Переход на главную страницу в раздел Конструктор через кнопку Конструктор в хедере страницы")
    @Description("Должен отобразиться конструктор Главной странице")
    public void goToConstructorFromPersonalAccountPage() {
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
        PersonalAreaPage objPersonalArea= new PersonalAreaPage();
        objPersonalArea.constructorButtonClick();
        boolean isDisplayedConstructor = objHomePage.isDisplayedConstructor();
        Assert.assertTrue(isDisplayedConstructor);
        userClient.deleteUser(accessToken);
    }

    @Test
    @DisplayName("Переход на главную страницу  через кнопку Логотипа в хедере страницы")
    @Description("Должна отобразиться Главная страница")
    public void goToHomePageByLogoClick() {
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
        PersonalAreaPage objPersonalArea= new PersonalAreaPage();
        objPersonalArea.logoClick();
        boolean isDisplayedHomePage = objHomePage.visibleHomePage();
        Assert.assertTrue(isDisplayedHomePage);
        userClient.deleteUser(accessToken);
    }
}
