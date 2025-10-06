package HWDemoWorkShop;

import HWDemoWorkShop.Utils.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @Test
    public void newUserRegistrationPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        String email = "gorlum007user" + i + "@gmail.com";

        click(By.cssSelector("a[href='/register']")); //click registration
        type(By.name("FirstName"), "Alex"); //enter first name
        type(By.name("LastName"), "Smith"); //enter last name
        type(By.name("Email"), email); // enter email
        type(By.name("Password"), "TestTest007!"); // enter password
        type(By.name("ConfirmPassword"), "TestTest007!"); // enter password

        click(By.name("register-button")); // click on 'Register' button


        Assert.assertTrue(isElementVisible(By.cssSelector("input.register-continue-button")), "Кнопка Continue не отображается");

        click(By.cssSelector("input.register-continue-button")); // Click the 'Continue' button to go to the main page

        Assert.assertTrue(isElementVisible(By.xpath("//a[text()='Log out']")), "Кнопка 'Log out' не отображается");
        Assert.assertEquals(getText(By.cssSelector("a.account")), email, "Email пользователя не совпадает");
    }

}
