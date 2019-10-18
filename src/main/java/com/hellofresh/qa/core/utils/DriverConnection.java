package com.hellofresh.qa.core.utils;

import com.hellofresh.qa.support.util.Utility;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Driver connection class
 */
public class DriverConnection {
    private static Logger log = Logger.getLogger(DriverConnection.class);

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    public static void terminateDriverProcess() {
        Utility.killProcess();
    }
}
