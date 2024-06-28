package utils;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

    public class PropertiesReader {
        public static Properties getEnvProperties() {
            try {
                Properties property=new Properties();
                property.load(new FileInputStream(new File(System.getProperty("user.dir")+"/config/qa.properties")));
                return property;
            } catch (Exception e) {
                return null;
            }
        }
    }


