package Phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("gorlum007user@gmail.com")
                .setPassword("TestTest007!"));
        clickOnLoginButton();

        clickOnAddLink();
        fillContactForm(new Contact().setName("Alex")
                .setLastName("Smith")
                .setPhone("1234567890")
                .setEmail("aa@tt.com")
                .setAddress("Berlin")
                .setDescription("Lukas friend"));
        clickOnSaveButton();

    }

    @Test
    public void deleteContactTest() {
        int sizeBefore = sizeOfContacts();
        removeContact();
        pause(500);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }

}
