package PageObjects;

import Core.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PersonalAreaPage extends Driver {
    private final By logoutButton = By.xpath(".//button[text()='Выход']");
    private final By textInPersonalAreaPage = By.xpath(".//p[contains(text(),'В этом разделе вы можете изменить свои персональные данные')]");
    private By constructorButton =By.xpath(".//p[contains(text(),'Конструктор')]");
    private By logo = By.className("AppHeader_header__logo__2D0X2");

    @Step("Клик по кнопке Выход")
    public void  logOutButtonClick() {
        driver.findElement(logoutButton).click();
    }

    @Step("Метод отображения текста об изменении данных")
    public boolean isDisplayedText() {
        return driver.findElement(textInPersonalAreaPage).isDisplayed();
    }

    @Step("Клик по кнопке Конструктор")
    public void constructorButtonClick() {
        driver.findElement(constructorButton).click();
    }

    @Step("Клик по Логотипу")
    public void logoClick() {
        driver.findElement(logo).click();
    }
}
