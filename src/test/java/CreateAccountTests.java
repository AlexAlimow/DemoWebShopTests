import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccountTests extends TestBase {


    @Test
    public void newUserRegisterPositiveTest() {
        // int i = (int) ((System.currentTimeMillis()/1000)%3600);
        //click on Login link
        click(By.cssSelector("[href='/login']"));
        //enter email
        type(By.name("email"), "gorlum007user@gmail.com");
        //enter password
        type(By.name("password"), "TestTest007!");

        //click on Registration button
        click(By.name("registration"));
        //assert Sign Out button presents
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));

    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }


    @Test
    public void existedUserRegisterNegativeTest() {
        //click on Login link
        click(By.cssSelector("[href='/login']"));
        //enter email
        type(By.name("email"), "gorlum007user@gmail.com");
        //enter password
        type(By.name("password"), "TestTest007!");

        //click on Registration button
        click(By.name("registration"));
        //assert alert appears
        Assert.assertTrue(isAlertPresent());

    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            return true;
        }
    }

    
}
