package utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CredentialsReader {
    private static Properties properties = new Properties();


    public static void loadProperties() throws IOException {
        InputStream input = CredentialsReader.class.getClassLoader().getResourceAsStream("credentials.properties");
        properties.load(input);
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
