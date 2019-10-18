package com.hellofresh.qa.core.test;

import com.hellofresh.qa.core.utils.DriverConnection;
import com.hellofresh.qa.core.utils.DriverManager;
import com.hellofresh.qa.support.exceptions.FrameworkException;
import com.hellofresh.qa.support.listener.TestNGListener;
import com.hellofresh.qa.support.util.ReporterUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestObject {

    protected WebDriver driver;

    @BeforeTest
    public void testSetup() {
        ReporterUtil.startReport();
    }

    @Parameters({"browser", "url"})
    @BeforeMethod
    public void setUp(String browser, String url) throws FrameworkException {
        driver = DriverManager.createDriverInstance(browser);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(url);
        DriverConnection.setWebDriver(driver);
    }

    @AfterMethod
    public void tearDown() {
        ReporterUtil.getResult(TestNGListener.getCurrentResults());
        driver = DriverConnection.getDriver();
        if (driver != null) {
            driver.close();
        }
    }

    @AfterTest
    public void testTearDown() {
        ReporterUtil.endReport();
    }

    @AfterSuite
    public void suiteTearDown() {
        DriverConnection.terminateDriverProcess();
    }

}
