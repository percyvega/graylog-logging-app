package com.percyvega.experiments.logging;


public class LoggingApp {

    public static void main(String[] args) {

        LoggerThread thread = new LoggerThread();
        thread.start();

    }

}
