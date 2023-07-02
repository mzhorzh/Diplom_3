import Core.Annotations;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

public class RegisterPageTest extends Annotations {
    @Test
    @DisplayName("Регистрация пользователя с корректными данными")
    @Description("Должна отобразиться страница для входа")
    public void registerSuccessTest() {
        HomePage objHomePage = new HomePage();
        objHomePage.loginButtonClick();
        LoginPage objLoginPage = new LoginPage();
        objLoginPage.registerButtonClick();
        RegisterPage objRegisterPage = new RegisterPage();
        objRegisterPage.fillName(RandomStringUtils.randomAlphanumeric(10));
        objRegisterPage.fillEmail(RandomStringUtils.randomAlphanumeric(8) + "gmail.com");
        objRegisterPage.fillPassword(RandomStringUtils.randomAlphanumeric(6));
        objRegisterPage.registerButtonClick();
        boolean isVisibleLoginPage = objLoginPage.visibleLoginPage();
        Assert.assertTrue(isVisibleLoginPage);
    }

    @Test
    @DisplayName("Регистрация с некорректным паролем")
    @Description("Должно отобразиться сообщение Некорректный пароль")
    public void passwordTooShortTest() {
        HomePage objHomePage = new HomePage();
        objHomePage.loginButtonClick();
        LoginPage objLoginPage = new LoginPage();
        objLoginPage.registerButtonClick();
        RegisterPage objRegisterPage = new RegisterPage();
        objRegisterPage.fillName(RandomStringUtils.randomAlphanumeric(10));
        objRegisterPage.fillEmail(RandomStringUtils.randomAlphanumeric(8) + "gmail.com");
        objRegisterPage.fillPassword(RandomStringUtils.randomAlphanumeric(5));
        objRegisterPage.registerButtonClick();
        boolean isPasswordErrorMessageVisible = objRegisterPage.passwordErrorMessageVisible();
        Assert.assertTrue(isPasswordErrorMessageVisible);
    }
}
