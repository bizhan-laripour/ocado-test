package com.ocado.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyConfig {

    private static Properties properties = new Properties();

    private PropertyConfig() {}

    static {
        InputStream inputStream =
                PropertyConfig.class.getClassLoader().getResourceAsStream("application.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getProperties(){
        return properties;
    }
}
