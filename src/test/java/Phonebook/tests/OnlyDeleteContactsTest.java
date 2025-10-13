package Phonebook.tests;

import Phonebook.core.TestBase;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OnlyDeleteContactsTest extends TestBase {
    @BeforeMethod
    public void precondition(){
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
    public void deleteContactTest() {
        int sizeBefore = app.getContact().sizeOfContacts();
        app.getContact().removeContact();
        app.getContact().pause(500);
        app.getContact().removeContact();
        app.getContact().pause(500);
        app.getContact().removeContact();
        app.getContact().pause(500);
        app.getContact().removeContact();
        app.getContact().pause(500);
        int sizeAfter = app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }

    @Test
    public void deleteAllContactsTest() {
        while (app.getContact().sizeOfContacts() > 0) {
            int sizeBefore = app.getContact().sizeOfContacts();
            app.getContact().removeContact();
            app.getContact().pause(500);  // небольшой таймаут, чтобы страница успела обновиться
            int sizeAfter = app.getContact().sizeOfContacts();
            Assert.assertEquals(sizeAfter, sizeBefore - 1, "Контакт не был удален!");
        }
        // Проверка, что контактов больше нет
        Assert.assertEquals(app.getContact().sizeOfContacts(), 0, "Контакты не удалились полностью!");
    }

}
