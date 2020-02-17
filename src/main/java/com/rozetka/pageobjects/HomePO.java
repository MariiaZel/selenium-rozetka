package com.rozetka.pageobjects;

import com.rozetka.logging.Log;
import com.rozetka.logging.LogType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.rozetka.utils.SeleniumHelper.waitForElementClickable;
import static com.rozetka.utils.SeleniumHelper.waitForElementVisible;

public class HomePO {
    private WebDriver driver;

    private By searchField = By.xpath("//input[@name='search']");
    private By searchButton = By.xpath("//button[contains(@class, 'search-form__submit')]");

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void setQueryToSearchField(String query) {
        waitForElementVisible(driver, searchField);
        driver.findElement(searchField).sendKeys(query);
        Log.log(String.format("Set [%s] to search field", query), LogType.INFO);
    }

    public void clickSearchButton() {
        waitForElementClickable(driver, searchButton);
        driver.findElement(searchButton).click();
        Log.log("Click [Search] button.", LogType.INFO);
    }
}