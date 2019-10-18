package com.hellofresh.qa.support.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hellofresh.qa.support.listener.TestNGListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ReporterUtil {

    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> logger = new ThreadLocal<ExtentTest>();

    public static void startReport(){

        URL inputStream = ReporterUtil.class.getProtectionDomain().getCodeSource().getLocation();
        String path = inputStream.getPath()+"../execution-results/results";
        new File(path).mkdirs();

        htmlReporter = new ExtentHtmlReporter(path+"/Execution Summary.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Environment", "Production Env.");

        htmlReporter.config().setDocumentTitle("Hello Fresh Web Assignment Test Results");
        htmlReporter.config().setReportName("HelloFresh Test Execution Results");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }

    public static ExtentTest initializeLogger(){
        logger.set(extent.createTest(TestNGListener.getCurrentTest()));
        return logger.get();
    }

    public static void getResult(ITestResult result){

        if(result.getStatus() == ITestResult.SUCCESS){
            logger.get().log(Status.PASS, MarkupHelper.createLabel(result.getName()+" - Test Case Passed !", ExtentColor.GREEN));

        } else if(result.getStatus() == ITestResult.FAILURE){
                logger.get().log(Status.FAIL, MarkupHelper.createLabel(
                        result.getName()+" - Test Case Failed<br/>"+
                        "Error Occurred !: "+result.getThrowable().getMessage(), ExtentColor.RED));
            try {
                String path = ScreenShortUtil.getScreenshotPath()+ ScreenShortUtil.getImgFileName();
                logger.get().log(Status.INFO, "Screen capture:", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else if(result.getStatus() == ITestResult.SKIP){
            logger.get().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped !", ExtentColor.ORANGE));
        }
    }

    /**
     * Flush ExtentReports content
     */
    public static void endReport(){
        extent.flush();
    }

    /**
     * Returns ExtentTest instance
     * @return
     */
    public static ExtentTest getLogger(){
        return logger.get();
    }
}
