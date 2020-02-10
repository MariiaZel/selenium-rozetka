package com.rozetka.pageobjects.login;

import com.rozetka.logging.Log;
import com.rozetka.logging.LogType;
import com.rozetka.pageobjects.AbstractPage;
import org.openqa.selenium.By;

public class SingInPO extends AbstractPage {
    private By loginWithFacebookButton = By.xpath("//button[contains(text(),'Facebook')]");
    private By loginWithGoogleButton = By.xpath("//button[contains(text(),'Google')]");
    private By closeButton = By.xpath("//button[@class='modal__close']");
    private By submitButton = By.xpath("//button[contains(@class,'button_color_green auth-modal__submit')]");
    private By passwordField = By.xpath("//input[@formcontrolname='password']");

    public void setUserPasswordTextField(String password) {
        getWebDriver().findElement(passwordField).sendKeys(password);
        Log.log("Set password [" + password + "] into form.", LogType.INFO);
    }
}
