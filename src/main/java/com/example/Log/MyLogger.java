package com.example.Log;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;


@Component
public class MyLogger {
    private static final Logger logger = LoggerFactory.getLogger(MyLogger.class);

    public void logInfo(String message) {
        logger.info(message);
    }

    public void logDebug(String message) {
        logger.debug(message);
    }

    public void logError(String message, Exception e) {
        logger.error(message, e);
    }

    public void logWarn(String message) {
        logger.warn(message);
    }

}
