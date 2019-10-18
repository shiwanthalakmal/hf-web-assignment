package com.hellofresh.qa.support.exceptions;

import com.hellofresh.qa.support.util.ScreenShortUtil;
import org.apache.log4j.Logger;

/**
 * FrameworkException
 */
public class FrameworkException extends Exception {
    Logger log = Logger.getLogger(FrameworkException.class);

    public FrameworkException(String message) {
        super(message);
        try {
            ScreenShortUtil.captureScreenshot();
        } catch (FrameworkException e) {
            log.error(message);
        }
    }
}
