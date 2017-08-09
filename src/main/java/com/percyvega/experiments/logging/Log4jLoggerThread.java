package com.percyvega.experiments.logging;

import com.percyvega.experiments.util.log4j.UnsafeUtil;
import org.apache.log4j.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Log4jLoggerThread extends Thread {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingApp.class);

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    @Override
    public void run() {
        long timeToSleep = 0;

        while (true) {
            try {
                timeToSleep = Math.abs(RANDOM.nextLong() % 7000);
                UnsafeUtil.performAnUnsafeOperation(timeToSleep);
                printAllLevels();
            } catch (Exception e) {
                LOGGER.error("Meaningful specific error message here!", e);
            }

            try {
                Thread.sleep(timeToSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void printAllLevels() {
        LOGGER.error("------------------------------------------------");

        LOGGER.trace("A sample Level.TRACE message.");
        LOGGER.debug("A sample Level.DEBUG message.");
        LOGGER.info("A sample Level.INFO message.");
        LOGGER.warn("A sample Level.WARN message.");
        LOGGER.error("A sample Level.ERROR message.");

        printLevelEnabled(Level.ALL);
        printLevelEnabled(Level.TRACE);
        printLevelEnabled(Level.DEBUG);
        printLevelEnabled(Level.INFO);
        printLevelEnabled(Level.WARN);
        printLevelEnabled(Level.ERROR);
        printLevelEnabled(Level.FATAL);
        printLevelEnabled(Level.OFF);
    }

    private void printLevelEnabled(final Level level) {
        String LEVEL_NAME = "Level." + level;
        String IS_ENABLED = " is enabled.";
        String IS_NOT_ENABLED = " is not enabled.";

        String message = LEVEL_NAME;

        switch (level.toInt()) {
            case Level.ALL_INT:
                message = level + " exists in Log4j but not in SLF4J";
                break;
            case Level.TRACE_INT:
                if (LOGGER.isTraceEnabled()) {
                    message += IS_ENABLED;
                } else {
                    message += IS_NOT_ENABLED;
                }
                break;
            case Level.DEBUG_INT:
                if (LOGGER.isDebugEnabled()) {
                    message += IS_ENABLED;
                } else {
                    message += IS_NOT_ENABLED;
                }
                break;
            case Level.INFO_INT:
                if (LOGGER.isInfoEnabled()) {
                    message += IS_ENABLED;
                } else {
                    message += IS_NOT_ENABLED;
                }
                break;
            case Level.WARN_INT:
                if (LOGGER.isWarnEnabled()) {
                    message += IS_ENABLED;
                } else {
                    message += IS_NOT_ENABLED;
                }
                break;
            case Level.ERROR_INT:
                if (LOGGER.isErrorEnabled()) {
                    message += IS_ENABLED;
                } else {
                    message += IS_NOT_ENABLED;
                }
                break;
            case Level.FATAL_INT:
                message = level + " exists in Log4j but not in SLF4J";
                break;
            case Level.OFF_INT:
                message = level + " exists in Log4j but not in SLF4J";
                break;
        }

        LOGGER.error(message);
    }

}
