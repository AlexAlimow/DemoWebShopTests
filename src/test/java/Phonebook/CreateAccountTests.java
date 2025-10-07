package Phonebook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {


    @Test
    public void newUserRegisterPositiveTest() {
        // int i = (int) ((System.currentTimeMillis()/1000)%3600);
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("gorlum007user@gmail.com")
                .setPassword("TestTest007!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isSignOutButtonPresent());
    }


    @Test
    public void existedUserRegisterNegativeTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("gorlum007user@gmail.com")
                .setPassword("TestTest007!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isAlertPresent());
    }
}
