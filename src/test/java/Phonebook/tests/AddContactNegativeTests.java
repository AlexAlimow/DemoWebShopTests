package Phonebook.tests;

import Phonebook.core.TestBase;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactNegativeTests extends TestBase {

    @BeforeMethod
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

    @Test
    public void addContactWithInvalidPhoneTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(
                new Contact().setName("Alex")
                        .setLastName("Smith")
                        .setPhone("123456789")
                        .setEmail("aa@tt.com")
                        .setAddress("Berlin")
                        .setDescription("Lukas friend"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isAlertPresent());
    }


}
