package com.rozetka.config;

import com.rozetka.utils.BrowserNotFoundException;
import com.rozetka.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.BrowserType;

public class WebDriverInit {
    private PropertyReader propertyReader = new PropertyReader();
    private WebDriver driver;
    protected ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

//    public WebDriverInit() {
//        initDriver();
//    }

    public void initDriver() {
        try {
            threadLocal.set(getWebDriverInstance(propertyReader.getBaseUrl(), propertyReader.getBrowserType()));
        } catch (BrowserNotFoundException e) {
            e.printStackTrace();
        }
    }

    private WebDriver getWebDriverInstance(String url, String browserType) throws BrowserNotFoundException {
        switch (browserType) {
            case BrowserType.CHROME:
                WebDriverManager.chromedriver().setup();
                this.driver = new ChromeDriver();
                break;
            case BrowserType.FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                this.driver = new FirefoxDriver();
                break;
            case BrowserType.HTMLUNIT:
                this.driver = new HtmlUnitDriver();
                break;
            default:
                throw new BrowserNotFoundException(String.format("Browser [%s] not found. Please try [%s], [%s] or [%s]",
                        browserType, BrowserType.CHROME, BrowserType.FIREFOX, BrowserType.HTMLUNIT));
        }
        this.driver.manage().window().maximize();
        this.driver.get(url);
        return this.driver;
    }

    public WebDriver getDriver() {
        return this.threadLocal.get();
    }

    public void removeDriver() {
        this.threadLocal.get().quit();
        this.threadLocal.remove();
    }
}
