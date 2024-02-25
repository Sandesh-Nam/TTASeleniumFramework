package org.thetestingacademy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertyReader {

    PropertyReader() {
    }

    public static String readKey(String key) throws Exception {
        FileInputStream fileInputStream = null;
        Properties p = null;
        //opening the file
        try {
            fileInputStream = new FileInputStream(new File
                    (System.getProperty("user.dir") +
                            "/src/main/resources/data.properties"));
            //It will read from the src/main/resources/data.properties file
            p = new Properties();
            p.load(fileInputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (Objects.nonNull(fileInputStream)) {
                fileInputStream.close();
            }
        }
//Reading the file
        if (p.getProperty(key) == null) {
            throw new Exception(p.getProperty(key) + " not found!!");
        } else {
            return p.getProperty(key);
        }

    }
}