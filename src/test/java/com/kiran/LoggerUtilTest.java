package com.kiran;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class LoggerUtilTest {

    @Test
    public void testLogInfo() {
        // Redirect log output to a mock logger
        Logger mockLogger = mock(Logger.class);
        LoggerFactory.getLogger(LoggerUtil.class).addAppender(mockLogger);
        LoggerUtil.logInfo("Test Info Log");

        // Verify that the log message is present in the mock logger
        verify(mockLogger).info("Test Info Log");
    }

    @Test
    public void testLogError() {
        // Redirect log output to a mock logger
        Logger mockLogger = mock(Logger.class);
        LoggerFactory.getLogger(LoggerUtil.class).addAppender(mockLogger);

        // Create a test exception
        Exception testException = new Exception("Test Exception");

        // Log an error with the exception
        LoggerUtil.logError("Test Error Log", testException);

        // Verify that the log message and exception are present in the mock logger
        verify(mockLogger).error("Test Error Log", testException);
    }
}

