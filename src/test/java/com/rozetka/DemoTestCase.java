package com.rozetka;

import com.rozetka.bo.SearchBO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTestCase extends BaseTest {

    @Test
    public void TestCaseDemo1() throws InterruptedException {
        String url = "http://www.google.com";
        WebDriver driver = getDriver();
        driver.navigate().to(url);
        Thread.sleep(8000);
    }

    @Test
    public void TestCaseDemo2() throws InterruptedException {
        String url = "http://www.blogger.com";
        WebDriver driver = getDriver();
        driver.navigate().to(url);
        Thread.sleep(8000);
    }

    @Test
    public void TestCaseDemo12() throws InterruptedException {
        WebDriver driver = getDriver();
        String expectedHeader = "Toster";
        String resultHeader = new SearchBO(driver).getSearchCategoryHeader(expectedHeader);
        Assert.assertEquals(resultHeader, expectedHeader, "The header is not equals.");
        Thread.sleep(8000);
    }
}