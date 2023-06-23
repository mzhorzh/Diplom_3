import Core.Annotations;
import PageObjects.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorTest extends Annotations {
    private String actualResult;
    @Test
    @DisplayName("Кейс проверки корректного перехода на вкладку Булки")
    @Description("Текст внутри конструктора должен соответствовать названию секции")
    public void goToBlockBunsInConstructor() {
        HomePage objHomePage = new HomePage();
        objHomePage.fillingsButtonClick();
        objHomePage.bunsButtonClick();
        actualResult = objHomePage.getTextBunsBlock();
        Assert.assertEquals("Булки", actualResult);
    }

    @Test
    @DisplayName("Кейс проверки корректного перехода на вкладку Соусы")
    @Description("Текст внутри конструктора должен соответствовать названию секции")
    public void goToBlockSaucesInConstructor() {
        HomePage objHomePage = new HomePage();
        objHomePage.saucesButtonClick();
        actualResult = objHomePage.getTextSaucesBlock();
        Assert.assertEquals("Соусы", actualResult);
    }

    @Test
    @DisplayName("Кейс проверки корректного перехода на вкладку Начинки")
    @Description("Текст внутри конструктора должен соответствовать названию секции")
    public void goToFillingsBlockInConstructor() {
        HomePage objHomePage = new HomePage();
        objHomePage.fillingsButtonClick();
        actualResult = objHomePage.getTextFillingsBlock();
        Assert.assertEquals("Начинки", actualResult);
    }
}
