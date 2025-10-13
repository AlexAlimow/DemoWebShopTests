package Phonebook.tests;

import Phonebook.core.TestBase;
import com.phonebook.models.User;
import com.phonebook.data.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

//    @Test(priority = 1)
//    public void loginPositiveTest() {
//        app.getUser().clickOnLoginLink();
//        app.getUser().fillLoginRegisterForm(new User()
//                .setEmail(UserData.email)
//                .setPassword(UserData.password));
//        app.getUser().clickOnLoginButton();
//        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
//    }


    @Parameters({"email","password"})
    @Test(priority = 1)
    public void loginPositiveTest(String email, String password) {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(email)
                .setPassword(password));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setPassword(UserData.password));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
