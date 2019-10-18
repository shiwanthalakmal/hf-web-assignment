package com.hellofresh.qa.support.util;

import com.hellofresh.qa.core.utils.DriverManager;
import com.hellofresh.qa.support.exceptions.FrameworkException;
import com.hellofresh.qa.support.listener.TestNGListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

/**
 * Generate screenshots of the web application under test
 *
 * @author Nilanthi
 * @since 21/11/2018
 */
public class ScreenShortUtil {

    /**
     * Returns the path under which the screenshot will be generated
     *
     * @return
     */
    public static String getScreenshotPath() {
        URL inputStream = ScreenShortUtil.class.getProtectionDomain().getCodeSource().getLocation();
        return inputStream.getPath() + "../screenshots/browser/";
    }

    /**
     * Returns the name of the image file (screenshot)
     *
     * @return
     */
    public static String getImgFileName() {
        return TestNGListener.getCurrentTest() + "_" + DriverManager.getBrowser() + ".png";
    }

    /**
     * Takes the screen capture
     *
     * @throws FrameworkException
     */
    public static void captureScreenshot() throws FrameworkException {

        String path = getScreenshotPath();

        try {
            new File(path).mkdirs();
            FileOutputStream out = new FileOutputStream(path + "/" + getImgFileName());
            WebDriver driver = DriverManager.getDriver();
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (Exception e) {
            throw new FrameworkException(e.getMessage());
        }
    }
}
