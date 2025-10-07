package HWDemoWorkShop.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase {

     WebDriver driver;
     WebDriverWait wait;

    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://demowebshop.tricentis.com/");
    }

    public void tearDownDriver() {
        if (driver != null) driver.quit();
    }

    // ---------- Общие действия ----------
    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void type(By locator, String text) {
        if (text != null) {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(text);
        }
    }

    protected boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    protected String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    // ---------- Регистрация ----------
    public void openRegistrationPage() {
        click(By.cssSelector("a[href='/register']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.name("FirstName"), user.getFirstName());
        type(By.name("LastName"), user.getLastName());
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
        type(By.name("ConfirmPassword"), user.getPassword());
    }

    public void submitRegistration() {
        click(By.name("register-button"));
    }

    public void clickContinueButton() {
        click(By.cssSelector("input.register-continue-button"));
    }

    public boolean isLoggedIn(String email) {
        return isElementPresent(By.xpath("//a[text()='Log out']")) &&
                getText(By.cssSelector("a.account")).equals(email);
    }

    // ---------- Логин ----------
    public void login(User user) {
        click(By.cssSelector("a[href='/login']"));
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
        click(By.cssSelector("input.login-button"));
    }

    public boolean isLogoutVisible() {
        return isElementPresent(By.xpath("//a[text()='Log out']"));
    }

    // ---------- Корзина ----------
    public String addSecondItemToCart() {
        WebElement secondProduct = driver.findElements(By.cssSelector(".product-item")).get(1);
        String productName = secondProduct.findElement(By.cssSelector(".product-title a")).getText();
        secondProduct.findElement(By.cssSelector("input[value='Add to cart']")).click();

        // Ждём появления уведомления и исчезновения
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bar-notification.success")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".bar-notification.success")));

        return productName;
    }

    public void openShoppingCart() {
        // Ждём, пока кнопка корзины станет кликабельной и кликаем
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.cart-label"))).click();
    }

    public String getProductNameFromCart() {
        // Возвращаем название первого товара в корзине
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.product-name"))).getText();
    }

    protected String getUniqueEmail() {
        String uniqueEmail = "gorlum007user" + System.currentTimeMillis() / 1000 + "@gmail.com";
        return uniqueEmail;
    }
}