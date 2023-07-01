import Core.Annotations;
import PageObjects.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import static org.hamcrest.core.StringContains.containsString;

public class ConstructorTest extends Annotations {
    private String actualResult;

    @Test
    @DisplayName("Кейс проверки корректного перехода на вкладку Булки")
    @Description("Кнопка перехода в секцию Булки должна быть активной")
    public void goToBlockBunsInConstructor() {
        HomePage objHomePage = new HomePage();
        objHomePage.fillingsButtonClick();
        objHomePage.bunsButtonClick();
        actualResult = objHomePage.getAttributeBuns();
        MatcherAssert.assertThat(actualResult, containsString("current"));
    }

    @Test
    @DisplayName("Кейс проверки корректного перехода на вкладку Соусы")
    @Description("Кнопка перехода в секцию Соусы должна быть активной")
    public void goToBlockSaucesInConstructor() {
        HomePage objHomePage = new HomePage();
        objHomePage.saucesButtonClick();
        actualResult = objHomePage.getAttributeSauces();
        MatcherAssert.assertThat(actualResult, containsString("current"));
    }

    @Test
    @DisplayName("Кейс проверки корректного перехода на вкладку Начинки")
    @Description("Кнопка перехода в секцию Начинки должна быть активной")
    public void goToFillingsBlockInConstructor() {
        HomePage objHomePage = new HomePage();
        objHomePage.fillingsButtonClick();
        actualResult = objHomePage.getAttributeFillings();
        MatcherAssert.assertThat(actualResult, containsString("current"));
    }
}
