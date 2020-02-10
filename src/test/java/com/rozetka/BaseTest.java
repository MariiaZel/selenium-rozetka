package com.rozetka;

import com.rozetka.config.WebDriverInit;
import com.rozetka.logging.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class BaseTest {

    private WebDriverInit driverInit;

    @BeforeMethod
    public void setUp() {
        driverInit = new WebDriverInit();
    }

    public WebDriver getDriver() {
        return this.driverInit.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driverInit.removeDriver();
    }
}
