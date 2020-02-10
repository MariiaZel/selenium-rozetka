package com.rozetka.logging;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

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
        System.out.println("FAILED11111 !!!!");
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
