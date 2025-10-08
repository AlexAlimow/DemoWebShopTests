package HWDemoWorkShop;

import HWDemoWorkShop.Utils.User;
import HWDemoWorkShop.Utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        setUpDriver();

        // Логин под существующим пользователем
        User user = new User()
                .setEmail("gorlum007user712@gmail.com")
                .setPassword("TestTest007!");
        login(user);

        Assert.assertTrue(isLogoutVisible(), "Не удалось войти в систему");
    }

    @Test
    public void addItemToCartTest() {

        // Добавление товара в корзину и получение его имени
        String addedProductName = addSecondItemToCart(); // возвращает название добавленного товара
        openShoppingCart();

        // Получение названия товара из корзины
        String productNameInCart = getProductNameFromCart();

        // Проверка по имени
        Assert.assertEquals(productNameInCart, addedProductName, "Добавленный товар не найден в корзине");




    }
    @AfterMethod
    public void postcondition(){
        //tearDownDriver();
    }


}