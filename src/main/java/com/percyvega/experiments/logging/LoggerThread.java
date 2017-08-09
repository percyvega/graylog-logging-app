package com.percyvega.experiments.logging;

import com.percyvega.experiments.logging.util.UnsafeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class LoggerThread extends Thread {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingApp.class);

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    @Override
    public void run() {
        long timeToSleep = 0;

        while (true) {
            try {
                timeToSleep = Math.abs(RANDOM.nextLong() % 7000);
                UnsafeUtil.performAnUnsafeOperation(timeToSleep);

                LOGGER.error("----Logging information:");
                printOfAllLevels();
                printLevelsEnabled();
                LOGGER.error("----:Logging information");
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

    private void printOfAllLevels() {
        LOGGER.trace("A sample Level.trace message.");
        LOGGER.debug("A sample Level.debug message.");
        LOGGER.info("A sample Level.info message.");
        LOGGER.warn("A sample Level.warn message.");
        LOGGER.error("A sample Level.error message.");
    }

    private void printLevelsEnabled() {
        printIsEnabled(LOGGER.isTraceEnabled(), "trace");
        printIsEnabled(LOGGER.isDebugEnabled(), "debug");
        printIsEnabled(LOGGER.isInfoEnabled(), "info");
        printIsEnabled(LOGGER.isWarnEnabled(), "warn");
        printIsEnabled(LOGGER.isErrorEnabled(), "error");
    }

    private void printIsEnabled(boolean isEnabled, String levelName) {
        LOGGER.error("Level." + levelName + " is" + (isEnabled ? "" : " not") + " enabled.");
    }

}
