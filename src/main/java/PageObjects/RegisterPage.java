package PageObjects;

import Core.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class RegisterPage extends Driver {
    private final By nameField = By.xpath(".//fieldset[1]/div/div/input");
    private final By emailField = By.xpath(".//fieldset[2]/div/div/input");
    private final By passwordField = By.xpath(".//fieldset[3]/div/div/input");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By loginButton = By.xpath(".//a[text()='Войти']");
    private final By passwordErrorMessage = By.xpath(".//p[text()='Некорректный пароль']");

    @Step("Клик и заполнение поля Имя")
    public void fillName(String name) {
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Клик и заполнение поля Email")
    public void fillEmail(String email) {
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Клик и заполнение поля Пароль")
    public void fillPassword(String password) {
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public void registerButtonClick() {
        driver.findElement(registerButton).click();
    }

    @Step("Клик по кнопке Войти")
    public void loginButtonClick() {
        driver.findElement(loginButton).click();
    }

    @Step("Метод отображения сообщения об ошибке")
    public boolean passwordErrorMessageVisible() {
        return (driver.findElement(passwordErrorMessage).isDisplayed());
    }
}
