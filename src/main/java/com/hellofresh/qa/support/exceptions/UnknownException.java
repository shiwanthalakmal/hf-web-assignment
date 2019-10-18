package com.hellofresh.qa.support.exceptions;

import org.apache.log4j.Logger;

public class UnknownException extends FrameworkException {
    Logger log = Logger.getLogger(TimeoutException.class);

    public UnknownException(String message) {
        super(message);
        log.error(message);
    }

}
