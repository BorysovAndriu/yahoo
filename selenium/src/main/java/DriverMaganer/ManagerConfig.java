package DriverMaganer;

import com.oracle.tools.packager.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ManagerConfig {

    private Properties properties;

    public ManagerConfig() {

        this.properties = new Properties();

        try {
            properties.load(new FileInputStream(new File("src/main/resources/sender.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String nameProperty) {
        return properties.getProperty(nameProperty);
    }
}
