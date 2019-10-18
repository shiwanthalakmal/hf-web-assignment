package com.hellofresh.qa.support.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
    private final static Logger log = Logger.getLogger(TestNGListener.class);

    private static ThreadLocal<String> currentTest = new ThreadLocal<String>();
    private static ThreadLocal<ITestResult> currentResults = new ThreadLocal<ITestResult>();

    public static ITestResult getCurrentResults() {
        return currentResults.get();
    }

    public void onTestStart(ITestResult iTestResult) {
        log.info("[Test Started] : " + iTestResult.getMethod().getConstructorOrMethod().getName());
    }

    public void onTestSuccess(ITestResult iTestResult) {
        log.info("[Test Passed] : " + iTestResult.getMethod().getConstructorOrMethod().getName());
        currentResults.set(iTestResult);
    }

    public void onTestFailure(ITestResult iTestResult) {
        log.info("[Test Failed] : " + iTestResult.getMethod().getConstructorOrMethod().getName());
        currentResults.set(iTestResult);
    }

    public void onTestSkipped(ITestResult iTestResult) {
        log.info("[Test Skipped] : " + iTestResult.getMethod().getConstructorOrMethod().getName());
        currentResults.set(iTestResult);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {
        log.info("------------------------------------");
        log.info("------------------------------------");
        log.info("--------- Execution Started --------");
    }

    public void onFinish(ITestContext iTestContext) {
        log.info("------------------------------------");
        log.info("------------------------------------");
        log.info("---------- Execution Ended ---------");
    }

    private static String getMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public static String getCurrentTest() {
        return currentTest.get();
    }

}
