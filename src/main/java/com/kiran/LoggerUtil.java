package com.kiran;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerUtil.class);

    public static void logInfo(String message) {
        LOGGER.info(message);
    }

    public static void logError(String message, Throwable throwable) {
        LOGGER.error(message, throwable);
    }
}

