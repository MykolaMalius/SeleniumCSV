package com.epam.lab.excelutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvProperties {
    private Properties properties;

    public EnvProperties() {
        properties = new Properties();

        try {
            properties.load(new FileInputStream(new File("config.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getBaseUrl () {
        return properties.getProperty("BaseURL");
    }
    public  String getHomePageURL(){
        return properties.getProperty("HomePageURL");
    }
}

