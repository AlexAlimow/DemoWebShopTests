package Phonebook.core;

import com.phonebook.core.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestBase {

    protected static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));

    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeMethod(alwaysRun = true)
    public void startTest(Method method) {
        logger.info("Start test {}", method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: {}", result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: {} Screenshot: {}", result.getMethod().getMethodName(), app.getContact().takeScreenshot());
        }
        logger.info("Stop test");
        logger.info("**************************************************");
    }

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }


    @BeforeGroups("smoky")
    public void setUpSmokyGroup() {
        logger.info("Start smoky tests");
    }

    @AfterGroups("smoky")
    public void stopSmokyGroup() {
        logger.info("Stop smoky tests");
    }
}
