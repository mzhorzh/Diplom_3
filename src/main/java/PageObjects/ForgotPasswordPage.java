package PageObjects;

import Core.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ForgotPasswordPage extends Driver {
    private final By loginButton = By.xpath(".//a[text() = 'Войти']");

    @Step("Клик по кнопке Войти")
    public void  loginButtonClick() {
        driver.findElement(loginButton).click();
    }
}
