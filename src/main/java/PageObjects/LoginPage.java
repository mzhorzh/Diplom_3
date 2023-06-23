package PageObjects;

import Core.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends Driver {
    private final By emailField = By.xpath(".//input[@name='name']");
    private final By passwordField = By.xpath(".//input[@name='Пароль']");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By registerButton = By.xpath(".//div/main/div/div/p[1]/a");
    private final By forgotPasswordButton = By.xpath(".//a[text()='Восстановить пароль']");
    private final By loginPageLocator = By.xpath(".//main[@class='App_componentContainer__2JC2W']");

    @Step("Заполнение формы входа")
    public void fillLoginForm(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Клик по кнопке Войти")
    public void loginButtonClick() {
        driver.findElement(loginButton).click();
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public void registerButtonClick() {
        driver.findElement(registerButton).click();
    }

    @Step("Клик по кнопке Восстановить пароль")
    public void forgotPasswordButtonClick() {
        driver.findElement(forgotPasswordButton).click();
    }

    @Step("Метод отображения страницы входа")
    public boolean visibleLoginPage() {
        return (driver.findElement(loginPageLocator).isDisplayed());
    }
}
