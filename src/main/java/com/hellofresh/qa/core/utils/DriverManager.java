package com.hellofresh.qa.core.utils;

import com.hellofresh.qa.support.exceptions.FrameworkException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DriverManager {

    private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
    private static ThreadLocal<String> browser = new ThreadLocal<String>();

    private DriverManager() {

    }

    public static RemoteWebDriver createDriverInstance(String browserType) throws FrameworkException {
        driver.set(getSpecificDriverInstance(browserType));
        browser.set(browserType);
        return driver.get();
    }

    private static RemoteWebDriver getSpecificDriverInstance(String browserType) throws FrameworkException {

        if (browserType.equalsIgnoreCase("chrome")) {
            URL driverPath = DriverManager.class.getClassLoader().getResource("drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", driverPath.getPath());
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            URL driverPath = DriverManager.class.getClassLoader().getResource("drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", driverPath.getPath());
            return new FirefoxDriver();
        } else {
            throw new FrameworkException("Invalid browser type. Valid types are: chrome or firefox");
        }
    }

    public static RemoteWebDriver getDriver() {
        return driver.get();
    }

    public static String getBrowser() {
        return browser.get();
    }

}
