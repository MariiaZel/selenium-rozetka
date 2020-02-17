package com.rozetka.config;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadLocal.get();
    }

    public static void setWebDriver(WebDriver webDriver) {
        threadLocal.set(webDriver);
    }

    public static void closeDriver() {
        if (threadLocal.get() != null) {
            threadLocal.get().quit();
            threadLocal.set(null);
        }
    }
}
