package utilities.fileUtils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtility {

    public static Properties getApplicationProperties(String configFileName){
        Properties properties;
        try (InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/" + configFileName)){
            properties = new Properties();
            properties.load(inputStream);
        }catch (Exception e){
            throw new RuntimeException("Error while reading the properties file. ", e);
        }
        return properties;
    }


    public static Properties setApplicationProperties(String propertiesFileName, String key, String value){
        Properties properties = new Properties();

        File filePath = new File(System.getProperty("user.dir") + "\\" + propertiesFileName);

        try(InputStream inputStream = new FileInputStream(filePath)){
            properties.load(inputStream);
            try (OutputStream outputStream = new FileOutputStream(filePath)) {
            properties.setProperty(key, value);
            properties.store(outputStream, "storing the properties");

            return properties;

            } catch (Exception e){
                throw new RuntimeException("Error while storing the values in the properties file. ", e);
            }
        }catch (Exception e){
            throw new RuntimeException("Error while storing the values in the properties file. ", e);
        }



    }

}
