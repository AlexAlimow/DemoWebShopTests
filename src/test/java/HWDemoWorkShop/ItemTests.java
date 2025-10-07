package HWDemoWorkShop;

import HWDemoWorkShop.Utils.User;
import HWDemoWorkShop.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemTests extends TestBase {

    @Test
    public void addItemToCartTest() {
        setUpDriver();

        // создаем пользователя и регистрируемся
        String uniqueEmail = getUniqueEmail();
        User user = new User()
                .setFirstName("Alex")
                .setLastName("Smith")
                .setEmail(uniqueEmail)
                .setPassword("TestTest007!");

        // Регистрация
        openRegistrationPage();
        fillRegistrationForm(user);
        submitRegistration();
        clickContinueButton();
        Assert.assertTrue(isLoggedIn(user.getEmail()), "Регистрация не прошла");

        // Добавление товара в корзину и получение его имени
        String addedProductName = addSecondItemToCart(); // возвращает название добавленного товара
        openShoppingCart();

        // Получение названия товара из корзины
        String productNameInCart = getProductNameFromCart();

        // Проверка по имени
        Assert.assertEquals(productNameInCart, addedProductName, "Добавленный товар не найден в корзине");

        System.out.println("Добавленный товар: " + productNameInCart);

        //tearDownDriver();
    }

}