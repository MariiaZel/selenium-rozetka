package com.rozetka.pageobjects;

import com.rozetka.logging.Log;
import com.rozetka.logging.LogType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.rozetka.utils.SeleniumHelper.waitForElementClickable;

public class ResultPO {
    WebDriver driver;
    private By sectionHeader = By.xpath("//h1[contains(@class, 'catalog-heading')]");

    public ResultPO (WebDriver driver) {
        this.driver = driver;
    }

    public String getSectionHeader() {
        waitForElementClickable(driver, sectionHeader);
        String sectionHeaderText = driver.findElement(sectionHeader).getText();
        Log.log(String.format("Get section header text -> [%s].", sectionHeaderText), LogType.INFO);
        return sectionHeaderText;
    }
}
