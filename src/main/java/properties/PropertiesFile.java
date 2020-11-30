package properties;

import pages.ForgotPassPage;
import pages.LoginPage;
import pages.RegistrationPage;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {

    static Properties prop = new Properties();

    public static void readPropertiesFile() {

        try (InputStream input = new FileInputStream("src/test/resources//config.properties")) {
            prop.load(input);
            LoginPage.LOGIN_PAGE_URL = prop.getProperty("RootUrl").concat(prop.getProperty("LoginUrl"));
            LoginPage.MAIN_PAGE_URL = prop.getProperty("RootUrl").concat(prop.getProperty("MainUrl"));
            LoginPage.ROOT_URL = prop.getProperty("RootUrl");
            LoginPage.VALID_EMAIL = prop.getProperty("ValidEmail");
            LoginPage.VALID_PASSWORD = prop.getProperty("ValidPassword");
            LoginPage.USERNAME = prop.getProperty("Username");
            ForgotPassPage.FORGOTPASSWORD_PAGE_URL = prop.getProperty("RootUrl").concat(prop.getProperty("ForgotPasswordUrl"));
            RegistrationPage.REGISTRATION_PAGE_URL = prop.getProperty("RootUrl").concat(prop.getProperty("RegisterUrl"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

