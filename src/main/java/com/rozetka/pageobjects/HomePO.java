package com.rozetka.pageobjects;

import org.openqa.selenium.By;

public class HomePO extends AbstractPage{
    private By loginButton = By.xpath("//span[@name='splash-button']");
    private By searchField = By.xpath("//a[@class='header-topline__user-link link-dashed']");
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
