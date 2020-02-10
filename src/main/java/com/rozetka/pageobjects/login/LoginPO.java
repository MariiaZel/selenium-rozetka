package com.rozetka.pageobjects.login;


import com.rozetka.logging.Log;
import com.rozetka.logging.LogType;
import org.openqa.selenium.By;

public class LoginPO  extends SingInPO {
    private By loginField = By.xpath("//input[@id='auth_email']");
    private By submitButton = By.xpath("//button[contains(@class,'button_color_green auth-modal__submit')]");

    public void setUserEmailTextField(String email) {
        getWebDriver().findElement(loginField).sendKeys(email);
        Log.log("Set email [" + email + "] into form.", LogType.INFO);
    }
}
