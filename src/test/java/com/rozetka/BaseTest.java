package com.rozetka;

import com.rozetka.config.WebDriverInit;
import com.rozetka.logging.TestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class BaseTest {
    @AfterTest
    public void tearDown() {
        WebDriverInit.getInstance().removeDriver();
    }
}
