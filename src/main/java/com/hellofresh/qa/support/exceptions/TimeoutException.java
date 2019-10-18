package com.hellofresh.qa.support.exceptions;


import org.apache.log4j.Logger;

public class TimeoutException extends FrameworkException {
    Logger log = Logger.getLogger(TimeoutException.class);

    public TimeoutException(String message) {
        super(message);
        log.error(message);
    }

}
