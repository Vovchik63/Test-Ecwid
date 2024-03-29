package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static String getPropertyFromFile(String propertyName){
        Properties properties = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream("src/test/resources/test_ecwid.properties")){
            properties.load(fileInputStream);
        }catch (IOException ioException) {
            System.out.println("Cannot read property file "+propertyName+"");
            ioException.printStackTrace();
        }
        return properties.getProperty(propertyName);
    }


    private static String getProperty(String propertyName){
        if(System.getProperty(propertyName)==null){
            return getPropertyFromFile(propertyName);
        }else {
            return System.getProperty(propertyName);
        }
    }

    public static String getUrl(){
        return getProperty("url");
    }
    public static Browsers getBrowser(){
        return Browsers.valueOf(getProperty("browser"));
    }


}
