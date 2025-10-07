package HWDemoWorkShop;

import HWDemoWorkShop.Utils.User;
import HWDemoWorkShop.Utils.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {
        setUpDriver();

        String uniqueEmail = getUniqueEmail();

        User user = new User()
                .setFirstName("Alex")
                .setLastName("Smith")
                .setEmail(uniqueEmail)
                .setPassword("TestTest007!");

        openRegistrationPage();
        fillRegistrationForm(user);
        submitRegistration();

        Assert.assertTrue(isElementPresent(By.cssSelector("input.register-continue-button")),
                "Кнопка Continue не найдена после регистрации");

        clickContinueButton();
        Assert.assertTrue(isLoggedIn(user.getEmail()), "Пользователь не вошёл после регистрации");

        tearDownDriver();
    }
}
