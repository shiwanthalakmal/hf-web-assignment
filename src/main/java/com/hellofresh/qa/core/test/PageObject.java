package com.hellofresh.qa.core.test;

import com.github.javafaker.Faker;
import com.hellofresh.qa.core.utils.DriverManager;
import com.hellofresh.qa.support.exceptions.FrameworkException;
import com.hellofresh.qa.support.exceptions.TimeoutException;
import com.hellofresh.qa.support.exceptions.UnknownException;
import com.hellofresh.qa.support.util.ReporterUtil;
import com.hellofresh.qa.support.util.ScreenShortUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Parent page object class
 */
public class PageObject {

    private static Logger log = Logger.getLogger(PageObject.class);

    protected static Faker faker = new Faker();

    protected WebElement locator(By findBy) throws FrameworkException {
        try {
            WebDriver driver = DriverManager.getDriver();
            return driver.findElement(findBy);
        } catch (NoSuchElementException e) {
            throw new TimeoutException(e.getMessage());
        } catch (org.openqa.selenium.TimeoutException e) {
            throw new TimeoutException(e.getMessage());
        } catch (Exception e) {
            throw new UnknownException(e.getMessage());
        }
    }

    protected Select selection(By findBy) throws FrameworkException {
        Select select = new Select(locator(findBy));
        return select;
    }

    protected WebElement waitUntil(By findBy) throws FrameworkException {
        try {
            WebDriver driver = DriverManager.getDriver();
            return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(findBy));
        } catch (NoSuchElementException e) {
            throw new TimeoutException(e.getMessage());
        } catch (org.openqa.selenium.TimeoutException e) {
            throw new TimeoutException(e.getMessage());
        } catch (Exception e) {
            throw new UnknownException(e.getMessage());
        }
    }

    protected void assertEquals(String actual, String expected) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (AssertionError e) {
            fail(e.getMessage());
        }
    }

    protected void assertTrue(boolean condition) {
        try {
            Assert.assertTrue(condition);
        } catch (AssertionError e) {
            fail(e.getMessage());
        }
    }

    private void fail(String message) {
        try {
            ScreenShortUtil.captureScreenshot();
            log.error(message);
            Assert.fail(message);
        } catch (Exception e) {
            log.error("Error Occurred ! " + e);
        }
    }

    protected void step_initializer() {
        ReporterUtil.getLogger().info(Thread.currentThread().getStackTrace()[2].getFileName() + "::" + Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    protected String getBrowser() {
        return DriverManager.getBrowser();
    }
}
