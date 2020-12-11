package properties;

import pages.BasePage;
import pages.login.ForgotPassPage;
import pages.login.LoginPage;
import pages.mySites.MySitesPage;
import pages.login.RegistrationPage;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {

    static Properties prop = new Properties();

    public static void readPropertiesFile() {

        try (InputStream input = new FileInputStream("src/test/resources//config.properties")) {
            prop.load(input);
            LoginPage.LOGIN_PAGE_URL = prop.getProperty("RootUrl").concat(prop.getProperty("LoginUrl"));
            LoginPage.MAIN_PAGE_URL = prop.getProperty("RootUrl").concat(prop.getProperty("MainUrl"));
            BasePage.ROOT_URL = prop.getProperty("RootUrl");
            LoginPage.VALID_EMAIL = prop.getProperty("LegionEmail");
            LoginPage.VALID_PASSWORD = prop.getProperty("LegionPassword");
            LoginPage.USERNAME = prop.getProperty("Username");
            ForgotPassPage.FORGOTPASSWORD_PAGE_URL = prop.getProperty("RootUrl").concat(prop.getProperty("ForgotPasswordUrl"));
            RegistrationPage.REGISTRATION_PAGE_URL = prop.getProperty("RootUrl").concat(prop.getProperty("RegisterUrl"));

            MySitesPage.MY_SITES_PAGE_URL = prop.getProperty("RootUrl").concat(String.format(prop.getProperty("MySitesUrl"), prop.getProperty("LegionID")));
            MySitesPage.CREATE_SITE_PAGE_URL = prop.getProperty("RootUrl").concat(String.format(prop.getProperty("CreateSiteUrl"), prop.getProperty("LegionID")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

