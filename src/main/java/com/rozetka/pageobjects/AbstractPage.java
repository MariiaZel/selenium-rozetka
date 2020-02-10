package com.rozetka.pageobjects;

import com.rozetka.config.WebDriverInit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    private WebDriver webDriver = new WebDriverInit().getDriver();

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public AbstractPage() {
        PageFactory.initElements(new DefaultFieldDecorator(new DefaultElementLocatorFactory(webDriver)), this);
    }

    protected void waitForElementVisible(WebElement webElement) {
        (new WebDriverWait(this.webDriver, 10)).until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitForElementIsNotVisible(WebElement webElement) {
        (new WebDriverWait(this.webDriver, 10)).until(ExpectedConditions.invisibilityOf(webElement));
    }
}