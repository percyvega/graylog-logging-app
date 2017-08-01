package com.percyvega.experiments.log4j;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.Random;

public class Log4jTest {

    private static final Logger LOGGER = Logger.getLogger(Log4jTest.class);

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        final Log4jTest console = new Log4jTest();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                long timeToSleep;

                while (true) {
                    try {
                        timeToSleep = Math.abs(RANDOM.nextLong() % 6000);
                        Thread.sleep(timeToSleep);

                        switch ((int) (timeToSleep % 13)) {
                            case 0:
                            case 1:
                            case 2:
                                String s = null;
                                s.length();
                                break;
                            case 3:
                            case 4:
                            case 5:
                                int x = (int) timeToSleep / 0;
                                break;
                            case 6:
                            case 7:
                            case 8:
                                int[] array = new int[]{0, 1, 2, 3, 4};
                                int y = array[5];
                                break;
                            case 9:
                            case 10:
                            case 11:
                                throw new LoggingAppException("timeToSleep is " + timeToSleep);
                            default:
                                console.execute();
                                break;
                        }

                    } catch (Exception e) {
                        String message = e.getMessage();
                        if(message == null)
                            message = e.toString();

                        LOGGER.error(message, e);
                    }

                }
            }
        });

        thread.start();

    }

    private void execute() {
        LOGGER.log(Level.OFF, "------------------------------------------------");

        LOGGER.log(Level.ALL, "A sample Level.ALL message.");
        LOGGER.trace("A sample Level.TRACE message.");
        LOGGER.debug("A sample Level.DEBUG message.");
        LOGGER.info("A sample Level.INFO message.");
        LOGGER.warn("A sample Level.WARN message.");
        LOGGER.error("A sample Level.ERROR message.");
        LOGGER.fatal("A sample Level.FATAL message.");
        LOGGER.log(Level.OFF, "A sample Level.OFF message.");

        printLevelEnabled(Level.ALL);
        printLevelEnabled(Level.TRACE);
        printLevelEnabled(Level.DEBUG);
        printLevelEnabled(Level.INFO);
        printLevelEnabled(Level.WARN);
        printLevelEnabled(Level.ERROR);
        printLevelEnabled(Level.FATAL);
        printLevelEnabled(Level.OFF);

        assert (LOGGER.isTraceEnabled() == LOGGER.isEnabledFor(Level.TRACE));
        assert (LOGGER.isDebugEnabled() == LOGGER.isEnabledFor(Level.DEBUG));
        assert (LOGGER.isInfoEnabled() == LOGGER.isEnabledFor(Level.INFO));
    }

    private void printLevelEnabled(final Level level) {
        String LEVEL_NAME = "Level." + level;
        String IS_ENABLED = " is enabled.";
        String IS_NOT_ENABLED = " is not enabled.";

        String message = LEVEL_NAME;
        if (LOGGER.isEnabledFor(level)) {
            message += IS_ENABLED;
        } else {
            message += IS_NOT_ENABLED;
        }

        LOGGER.log(Level.OFF, message);
    }

}