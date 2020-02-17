package com.rozetka.logging;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static com.rozetka.config.DriverManager.getDriver;

public class TestListener implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public void saveScreenshotPNG(String name, long millisecond) {
        try {
            File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(String.format("%sfailure_screenshots/%s_%s.png", Paths.get("target").toUri().toURL().getPath(), name, millisecond)));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        saveScreenshotPNG(arg0.getName(), arg0.getEndMillis());
        System.out.println("Screenshot captured for test case:" + getTestMethodName(arg0));
        System.out.println("FAILED !!!!");
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        System.out.println("SKIPPED !!!!");
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
