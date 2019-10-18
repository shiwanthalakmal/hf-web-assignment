package com.hellofresh.qa.support.exceptions;

import org.apache.log4j.Logger;

/**
 * ScriptException
 */
public class ScriptException extends FrameworkException {
    Logger log = Logger.getLogger(TimeoutException.class);

    public ScriptException(String message) {
        super(message);
        log.error(message);
    }
}
