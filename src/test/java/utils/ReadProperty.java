package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperty {
    String result;
    InputStream inputStream;

    public String getPropValues(String property) {
        try {
            Properties prop = new Properties();

            inputStream = getClass().getClassLoader().getResourceAsStream("properties/qa.properties");

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file is not found in the classpath");
            }
            result = prop.getProperty(property);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
