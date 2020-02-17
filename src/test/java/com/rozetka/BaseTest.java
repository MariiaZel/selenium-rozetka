package com.rozetka;

import com.rozetka.config.DriverFactory;
import com.rozetka.config.DriverManager;
import com.rozetka.logging.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class BaseTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        if (DriverManager.getDriver() == null) {
            DriverManager.setWebDriver(DriverFactory.getWebDriverInstance());
        }
    }
}
