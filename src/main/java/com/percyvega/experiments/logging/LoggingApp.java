package com.percyvega.experiments.logging;


public class LoggingApp {

    public static void main(String[] args) {

        if (LoggingFramework.log4j.isToBeUsed()) {

            Log4jLoggerThread thread = new Log4jLoggerThread();
            thread.start();

        } else if (LoggingFramework.logback.isToBeUsed()) {

            LogbackLoggerThread thread = new LogbackLoggerThread();
            thread.start();

        } else {

            throw new RuntimeException("Please specify a valid logging JVM parameter.");

        }

    }

}
