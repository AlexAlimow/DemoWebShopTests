package Phonebook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void LoginPositiveTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail(UserData.email)
                .setPassword(UserData.password));
        clickOnLoginButton();
        Assert.assertTrue(isSignOutButtonPresent());

    }

    @Test
    public void LoginNegativeWhithoutEmailTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setPassword(UserData.password));
        clickOnLoginButton();
        Assert.assertTrue(isAlertPresent());
    }

}
