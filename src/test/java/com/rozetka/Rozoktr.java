package com.rozetka;

import com.rozetka.pageobjects.HomePO;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class Rozoktr extends BaseTest {
    HomePO homePO;

    @Step("Login page")
    @Test
    public void testRe() {
        homePO = new HomePO();
        System.out.println(homePO.getTitle());
//        homePO.clickLogin();
//        System.out.println(getDriver().getTitle());
    }

    @Test
    public void testR1e() {
        homePO = new HomePO();
        System.out.println(homePO.getTitle());
//        homePO.clickLogin();
//        System.out.println(getDriver().getTitle());
    }

    @Test
    public void test2Re() {
        homePO = new HomePO();
        Assert.assertEquals(homePO.getTitle(), "Google123");
//        System.out.println(homePO.getTitle());
//        homePO.clickLogin();
//        System.out.println(getDriver().getTitle());
    }

//    @AfterMethod
//    public void removeDriver() {
//        homePO.getWebDriver().quit();
//    }
}