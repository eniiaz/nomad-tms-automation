package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {

    // 1. We need to open the properties file
    // 2. Load that file to Properties class that Java already provides
    // 3. Create a static method that takes a key as a parameter and then it should simply return the value of the given key

    private static Properties properties;

    static {
        try{
            properties = new Properties();
            FileInputStream file = new FileInputStream("configurations.properties");
            properties.load(file);
            file.close();
        }catch (IOException e){
            System.out.println("Configuration file not found");
        }
    }

    public static String getValue(String key){
        return properties.getProperty(key);
    }

}
