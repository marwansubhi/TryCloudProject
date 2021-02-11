package com.trycloud.tests.Aliya;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Properties {
    public Properties() throws IOException {

        java.util.Properties properties = new java.util.Properties();
        String path = "configuration.properties";
        FileInputStream file = new FileInputStream(path);
        properties.load(file);


    }
}
