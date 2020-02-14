package com.rozetka.pageobjects;

import org.openqa.selenium.By;

public class HomePO extends AbstractPage{
    private By loginButton = By.xpath("//a[@class='gb_ce gb_4 gb_W']"); //TODO: need change xpath
    private By basketButton = By.xpath("//span[@class='xhr']");
    private By wishesButton = By.xpath("//span[@class='underline-hover']");
    private By comparisonButton = By.xpath("//a[contains(@class, 'comparison-link sprite-side whitelink')]");

    public String getTitle() {
        return getWebDriver().getTitle();
    }

    public void clickLogin() {
        getWebDriver().findElement(loginButton).click();
    }
}
