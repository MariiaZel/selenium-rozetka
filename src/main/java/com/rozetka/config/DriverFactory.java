package com.rozetka.config;

import com.rozetka.logging.Log;
import com.rozetka.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static PropertyReader propertyReader = new PropertyReader();
    private static WebDriver driver;

    public static WebDriver getWebDriverInstance() {
        switch (propertyReader.getBrowserType()) {
            case BrowserType.CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(getChromeOptions());
                break;
            case BrowserType.FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case BrowserType.HTMLUNIT:
                driver = new HtmlUnitDriver();
                break;
            default:
                Log.log(String.format("Browser [%s] not found. Please try [%s], [%s] or [%s]",
                        propertyReader.getBrowserType(), BrowserType.CHROME, BrowserType.FIREFOX, BrowserType.HTMLUNIT));
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(propertyReader.getBaseUrl());
        return driver;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        return options;
    }
}
