package PageObjects;

import Core.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage extends Driver {
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By personalAreaButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By constructorList = By.className("BurgerIngredients_ingredients__menuContainer__Xu3Mo");
    private final By bunsButton = By.xpath(".//div[@style]/div[1]");
    private final By saucesButton = By.xpath(".//div[@style]/div[2]");
    private final By fillingsButton = By.xpath(".//div[@style]/div[3]");
    private final By homePageLocator = By.xpath(".//main[@class='App_componentContainer__2JC2W']");

    @Step("Клик по кнопке Войти в аккаунт")
    public void loginButtonClick() {
        driver.findElement(loginButton).click();
    }

    @Step("Клик по кнопке Личный кабинет")
    public void personalAreaButtonClick() {
        driver.findElement(personalAreaButton).click();
    }

    @Step("Метод отображения списка ингредиентов в конструкторе")
    public boolean isDisplayedConstructor() {
        return driver.findElement(constructorList).isDisplayed();
    }

    @Step("Клик по кнопке Булки")
    public void bunsButtonClick() {
        driver.findElement(bunsButton).click();
    }

    @Step("Клик по кнопке Соусы")
    public void saucesButtonClick() {
        driver.findElement(saucesButton).click();
    }

    @Step("Клик по кнопке Начинки")
    public void fillingsButtonClick() {
        driver.findElement(fillingsButton).click();
    }

    @Step("Получить атрибут класса Булки")
    public String getAttributeBuns() {
        return driver.findElement(bunsButton).getAttribute("class");
    }

    @Step("Получить атрибут класса Соусы")
    public String getAttributeSauces() {
        return driver.findElement(saucesButton).getAttribute("class");
    }

    @Step("Получить атрибут класса Начинки")
    public String getAttributeFillings() {
        return driver.findElement(fillingsButton).getAttribute("class");
    }

    @Step("Метод отображения главной страницы")
    public boolean visibleHomePage() {
        return (driver.findElement(homePageLocator).isDisplayed());
    }
}
