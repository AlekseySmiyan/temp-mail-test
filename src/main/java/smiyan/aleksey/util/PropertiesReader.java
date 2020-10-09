package smiyan.aleksey.util;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class PropertiesReader {

    private static final Properties PROPERTIES;

    static {
        PROPERTIES = new Properties();
        URL prop = ClassLoader.getSystemResource("config.properties");
        try {
            PROPERTIES.load(prop.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperties(String key) {
        return PROPERTIES.getProperty(key);
    }
}
