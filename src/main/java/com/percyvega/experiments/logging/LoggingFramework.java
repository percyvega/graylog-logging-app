package com.percyvega.experiments.logging;

import java.io.File;

public enum LoggingFramework {
    log4j("log4j.configuration"),
    logback("logback.configurationFile"),
    log4j2("");

    private String jvmParameterName;

    LoggingFramework(String jvmParameterName) {
        this.jvmParameterName = jvmParameterName;
    }

    boolean isToBeUsed() {
        boolean isValid = false;

        String loggingFilePath = System.getProperty(jvmParameterName);
        if (loggingFilePath != null) {
            File loggingFile = new File(loggingFilePath);
            if (!loggingFile.exists())
                throw new RuntimeException("File " + loggingFilePath + " was specified but it doesn't exist.");
            else
                isValid = true;
        }

        return isValid;
    }
}
