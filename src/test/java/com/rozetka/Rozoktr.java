package com.rozetka;

import org.testng.annotations.Test;

public class Rozoktr extends BaseTest {
    @Test
    public void testRe() {
        System.out.println(getDriver().getTitle());
    }

    @Test
    public void testR1e() {
        System.out.println(getDriver().getTitle());
    }

    @Test
    public void test2Re() {
        System.out.println(getDriver().getTitle());
    }

//    WebDriver driver;
//
//    @Test()
//    public void testOnChromeWithBrowserStackUrl()
//    {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://rozetka.com.ua/");
//        driver.manage().window().maximize();
//        System.out.println("this is the test related to chrome browserstack homepage"+ " " +Thread.currentThread().getId());
//
//    }
//
//    @Test()
//    public void testOnChromeWithBrowserStackSignUp()
//    {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://rozetka.com.ua/");
//        driver.manage().window().maximize();
//
//        System.out.println("this is the test related to chrome browserstack login"+ " " +Thread.currentThread().getId());
//
//    }
//
//    @Test()
//    public void testOnChromeWithBrowserStackSignUp1()
//    {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://rozetka.com.ua/");
//        driver.manage().window().maximize();
//
//        System.out.println("this is the test related to chrome browserstack login"+ " " +Thread.currentThread().getId());
//
//    }

}