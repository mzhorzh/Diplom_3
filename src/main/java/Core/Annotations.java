package Core;

import API.CreateUserRequest;
import Client.UserClient;
import Dataprovider.UserProvider;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class Annotations extends Driver {
    @Before
    public void setUp() {
        //Для тестов через Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        //Для тестов через Яндекс Браузер
        //System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver_mac64-2/chromedriver");
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        //driver = new ChromeDriver(chromeOptions);
        //Загружаем главную страницу сайта
        driver.get("https://stellarburgers.nomoreparties.site/");
        //Ждем 5 секунд, чтобы страница доскроллилась
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    //Закрываем браузер
    @After
    public void tearDown() {
        driver.quit();
    }
}
