package com.rozetka.config;

import com.rozetka.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class WebDriverInit {
    private static WebDriverInit instance = new WebDriverInit();
    private PropertyReader propertyReader = new PropertyReader();
    private static volatile WebDriver driver;

    public static WebDriverInit getInstance() {
        return instance;
    }


    private ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {


            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(propertyReader.getBaseUrl());
            return driver;
//            if (driver == null) {
//                return init(propertyReader.getBaseUrl(), propertyReader.getBrowserType());
//            }
//            return driver;
        }
    };

    private WebDriver init(String url, String browserType) {
        switch (browserType) {
            case BrowserType.CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case BrowserType.FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case BrowserType.HTMLUNIT:
                driver = new HtmlUnitDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    public WebDriver getDriver() {
        return threadDriver.get();
    }

    public void removeDriver() {
        threadDriver.get().quit();
        threadDriver.remove();
    }
}
