package com.rozetka.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static final String PROPERTIES_FILE_NAME = "app.properties";

    public String getBrowserType() {
        return getProperty("browser.type");
    }

    public String getBaseUrl() {
        return getProperty("base.url");
    }

    private Properties properties;

    public PropertyReader() {
        loadProperties(PROPERTIES_FILE_NAME);
    }

    public Properties loadProperties(String fileName) {
        properties = new Properties();
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    private String getProperty(String propertyKey) {
        String propertyValue = properties.getProperty(propertyKey);
        if (propertyValue == null) {
            throw new RuntimeException(String.format("Property with '%s' key not found in '%s' properties file", propertyKey, PROPERTIES_FILE_NAME));
        } else return propertyValue;
    }
}
