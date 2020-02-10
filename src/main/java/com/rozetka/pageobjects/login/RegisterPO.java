package com.rozetka.pageobjects.login;

import com.rozetka.pageobjects.AbstractPage;
import org.openqa.selenium.By;

public class RegisterPO extends SingInPO {
    private By loginField = By.xpath("//input[@formcontrolname='username']");
    private By nameField = By.xpath("//input[@formcontrolname='name']");
}
