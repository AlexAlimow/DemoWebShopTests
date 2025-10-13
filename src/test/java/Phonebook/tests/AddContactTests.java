package Phonebook.tests;

import Phonebook.core.TestBase;
import Phonebook.utils.MyDataProviders;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

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


    @Test(dataProvider = "addNewContact", dataProviderClass = MyDataProviders.class)
    public void addContactPositiveFromDataProviderTest(String name, String lastName,
                                                       String phone, String email,
                                                       String address, String desc) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(
                new Contact().setName(name)
                        .setLastName(lastName)
                        .setPhone(phone)
                        .setEmail(email)
                        .setAddress(address)
                        .setDescription(desc));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreatedByName(name));
    }


    @Test(dataProvider = "addNewContactFormCsv", dataProviderClass = MyDataProviders.class)
    public void addContactPositiveFromDataProviderWithFileTest(Contact contact) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreatedByPhone(contact.getPhone()));
    }


    @AfterMethod
    public void postCondition() {
        //click on card
        app.getContact().removeContact();
    }


}

