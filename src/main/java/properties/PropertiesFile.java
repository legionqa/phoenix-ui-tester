package properties;

import pages.LoginPage;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {


    static Properties prop = new Properties();

    public static void readPropertiesFile() {


        try (InputStream input = new FileInputStream("src/test/resources//config.properties")) {
            prop.load(input);
            LoginPage.LOGIN_PAGE_URL = prop.getProperty("LoginPageUrl");




        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

