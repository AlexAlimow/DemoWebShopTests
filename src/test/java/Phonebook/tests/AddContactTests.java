package Phonebook.tests;

import Phonebook.core.TestBase;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("gorlum007user@gmail.com")
                .setPassword("TestTest007!"));
        app.getUser().clickOnLoginButton();
    }

    @Test(groups = "smoky")
    public void addContactPositiveTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(
                new Contact().setName("Alex")
                        .setLastName("Smith")
                        .setPhone("1234567890")
                        .setEmail("aa@tt.com")
                        .setAddress("Berlin")
                        .setDescription("Lukas friend"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreatedByText("Alex"));
    }

    @AfterMethod
    public void postCondition() {
        //click on card
        app.getContact().removeContact();
    }

}

