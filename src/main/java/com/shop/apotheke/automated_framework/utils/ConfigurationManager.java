package com.shop.apotheke.automated_framework.utils;

import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConfigurationManager {
    public static ResourceBundle resourceBundle;
    private static volatile ConfigurationManager manager;
    private ConfigurationManager() throws IOException {
        resourceBundle = ResourceBundle.getBundle("config");
    }
    public static ConfigurationManager getInstance() {

        if (manager == null) {
            synchronized (ConfigurationManager.class) {
                if (manager == null) {
                    try {
                        manager = new ConfigurationManager();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return manager;
    }

    public  String getKey(String key){
        return resourceBundle.getString(key);
    }
}
