package com.hellofresh.qa.support.util;

import org.apache.log4j.Logger;

import java.io.IOException;

public class Utility {
    private static Logger log = Logger.getLogger(Utility.class);

    public static void killProcess() {
        try {
            Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
            Runtime.getRuntime().exec("taskkill /im geckodriver.exe /f");
        } catch (IOException e) {
            log.error("Error Occurred ! "+e);
        }
    }
}
