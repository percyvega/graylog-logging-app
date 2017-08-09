package com.percyvega.experiments.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class LogbackLoggerThread extends Thread {

    private static Logger LOGGER = LoggerFactory.getLogger(LogbackLoggerThread.class);

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    @Override
    public void run() {
        LOGGER.debug("Hello world.");
    }
}