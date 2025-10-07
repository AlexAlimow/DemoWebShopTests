package Phonebook;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("gorlum007user@gmail.com")
                .setPassword("TestTest007!"));
        clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        clickOnAddLink();
        fillContactForm(
                new Contact().setName("Alex")
                        .setLastName("Smith")
                        .setPhone("1234567890")
                        .setEmail("aa@tt.com")
                        .setAddress("Berlin")
                        .setDescription("Lukas friend"));
        clickOnSaveButton();
        Assert.assertTrue(isContactCreatedByText("Alex"));
    }

    @AfterMethod
    public void postCondition() {
        //click on card
        removeContact();
    }

}

