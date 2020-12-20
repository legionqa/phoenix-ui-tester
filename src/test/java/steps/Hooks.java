package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.login.LoginPage;
import properties.PropertiesFile;
import steps.mySites.PhoenixUIMySitesPageTest;
import steps.mySites.PhoenixUISitesActivationTests;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Hooks {
    public static LoginPage loginPage;
    public static boolean loggedIn = false;

    @Before("@login")
    public static void loginToDashboard() {
        if (!loggedIn) {
            loginPage = new LoginPage();
            PropertiesFile.readPropertiesFile();
            loginPage.loginToDashboard(LoginPage.VALID_EMAIL, LoginPage.VALID_PASSWORD);
            loggedIn = true;
        }
    }

    @Before("@switch")
    public static void errorsListSetup() {
        PhoenixUISitesActivationTests.errors = new ArrayList<>();
    }

    @After("@switch")
    public static void scenarioAssertion() {
        assertTrue(PhoenixUISitesActivationTests.errors.size() == 0);
    }

}
