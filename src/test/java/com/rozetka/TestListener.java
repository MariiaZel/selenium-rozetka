package com.rozetka;

import com.rozetka.config.WebDriverInit;
import com.rozetka.logging.Log;
import com.rozetka.pageobjects.AbstractPage;
import com.rozetka.pageobjects.HomePO;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Override
    public void onFinish(ITestContext arg0) {
        System.out.println("FINISH !!!");
    }

    @Override
    public void onStart(ITestContext arg0) {
        System.out.println("START !!!");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        System.out.println("FAILED !!!!");
    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        Object testClass = arg0.getInstance();
        WebDriver driver = ((BaseTest)testClass).getDriver();
        if(driver instanceof WebDriver) {
            System.out.println("Screenshot captured for test case:" + getTestMethodName(arg0));
            saveScreenshotPNG(driver);
        }
        System.out.println("FAILED11111 !!!!");
        saveTextLog(getTestMethodName(arg0) + "failed");
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        System.out.println("SCIPPED !!!!");
    }

    @Override
    public void onTestStart(ITestResult arg0) {
        Log.log("Test [" + arg0.getName() + "] started.");
    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        System.out.println("SUCCESS !!!!");
    }
}
