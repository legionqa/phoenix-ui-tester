package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.login.LoginPage;
import pages.mySites.SiteSettingsPage;
import properties.PropertiesFile;
import steps.mySites.PhoenixUIMySitesPageTest;
import steps.mySites.PhoenixUISitesActivationTests;
import steps.profile.ProfilePageVisibilityLangLink;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Hooks {
    public static LoginPage loginPage;
    public static SiteSettingsPage siteSettingsPage;
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

    @Before("@profile")
    public static void setupErrorsList() {
        ProfilePageVisibilityLangLink.errorsList = new ArrayList<>();
    }


    @After("@switch")
    public static void scenarioAssertion() {
        assertTrue(PhoenixUISitesActivationTests.errors.size() == 0);
    }

    @After("@profile")
    public static void seizeListAssertion() {
        assertTrue(ProfilePageVisibilityLangLink.errorsList.size() == 0);
    }

    @After("@reset")
    public static void siteDataReset() {
        siteSettingsPage = new SiteSettingsPage();
        if (siteSettingsPage.getCurrentPageUrl().equals(siteSettingsPage.MY_SITES_PAGE_URL)) {
            try {
                siteSettingsPage.clickSiteSettingsButton(siteSettingsPage.TEST_SITE_4_NAME);
            } catch (NoSuchElementException e) {
                siteSettingsPage.clickSiteSettingsButton(siteSettingsPage.TEST_SITE_1_NAME);
            }
        }
        siteSettingsPage.resetTestSite1Data();
    }
}
