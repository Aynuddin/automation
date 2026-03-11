package com.selenium.in.config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigManager {

    private static Properties prop;

    static {

        try {

            prop = new Properties();

            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir") +
                    "/src/main/resources/config.properties"
            );

            prop.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyValue(String key) {
        return prop.getProperty(key);
    }
}