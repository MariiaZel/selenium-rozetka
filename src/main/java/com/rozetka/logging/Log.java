package com.rozetka.logging;

import com.rozetka.utils.PropertyReader;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Properties;

public class Log {
    private static Logger logger = null;
    private static final String LOG_PROPERTIES_FILE_NAME = "log4j.properties";

    public Log() {
    }

    private static Logger setName(String name) {
        logger = Logger.getLogger(String.format("%s", name));
        Properties props = new PropertyReader().loadProperties(LOG_PROPERTIES_FILE_NAME);
        PropertyConfigurator.configure(props);
        return logger;
    }

    private static Logger getLogger() {
        if (logger != null) {
            return logger;
        } else {
            logger = setName("Not initialized logger");
            return logger;
        }
    }

    public static void log(String message) {
        getLogger().info(message);
    }

    public static void log(String message, LogType type) {
        switch (type) {
            case INFO:
                getLogger().info(message);
                break;
            case ERROR:
                getLogger().error(message);
                break;
        }
    }
}
