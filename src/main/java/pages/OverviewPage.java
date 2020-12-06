package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.mySites.CampaignPage;
import pages.mySites.SitePage;
import properties.PropertiesFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class OverviewPage extends BasePage {


//    public static String OVERVIEW_PAGE_URL;

    public final static String CHANGE_LANGUAGE_BUTTON = "//button[contains(text(), 'Change language')]";
    public final static String LANGUAGE_OPTION = "//a[text()='%s']";
    public final static String INFO_MESSAGE = "//*[text()='%s']";
    public final static String PLAYER = "//iframe[@src='https://www.youtube.com/embed/f7MklmZv1Tw']";
    public final static String LOGO = "//div[text()='%s']";
    public final static String QSTART = "//*[text()='%s']";
    public final static String CREATE = "//*[text()='%s']";
    public final static String EDIT_PROFILE_BUTTON = "//*[text()='%s']";
    public final static String NAME_PAGE = "//*[text()='%s']";
    public final static String LOGOUT = "//div[1]/nav/ul/li[2]/a";
    public final static String CREATE_BUTTON = "//button[text()='%s']";
    public final static String DROP_DOWN_LIST_BUTTON = "//a[text()='%s']";
    public final static String PHOENIX_EMAIL_LINK = "//a[text()='info@phoenix-widget.com']";
    public final static String VIDEO_PLAYER_BUTTON = "//button[@class='ytp-large-play-button ytp-button']";


    LoginPage loginPage = new LoginPage();

    public void navigateToOverviewPage() {
        PropertiesFile.readPropertiesFile();
        driver.get(LoginPage.LOGIN_PAGE_URL);
        loginPage.sendTextToEmailField(LoginPage.VALID_EMAIL);
        loginPage.sendTextToPasswordField(LoginPage.VALID_PASSWORD);
        loginPage.clickLoginButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void clickChangeLanguageButton() {
        clickElementByXpath(CHANGE_LANGUAGE_BUTTON);
    }

    public void clickCreateButton(String createButton) {
        clickElementByXpath(String.format(CREATE_BUTTON, createButton));
    }


    public pages.mySites.SitePage clickDropListButtonSite(String dropButton) {
        clickElementByXpath(String.format(DROP_DOWN_LIST_BUTTON, dropButton));
        return new pages.mySites.SitePage();
    }

    public pages.mySites.CampaignPage clickDropListButtonCampaign(String dropButton) {
        clickElementByXpath(String.format(DROP_DOWN_LIST_BUTTON, dropButton));
        return new pages.mySites.CampaignPage();
    }

    public ProfilePage clickEditProfileButton(String editButton) {
        clickElementByXpath(String.format(EDIT_PROFILE_BUTTON, editButton));
        return new ProfilePage();
    }

    public void chooseLanguage(String language) {
        clickElementByXpath(String.format(LANGUAGE_OPTION, language));
    }

    public boolean isTextInfoMassageDisplayed(String text) {
        return isElementDisplayed(String.format(INFO_MESSAGE, text));
    }

    public boolean isLogoDisplayed(String logo) {
        return isElementDisplayed(String.format(LOGO, logo));
    }

    public boolean isQstartDisplayed(String qstart) {
        return isElementDisplayed(String.format(QSTART, qstart));
    }

    public boolean isButtonCreateDisplayed(String button_create) {
        return isElementDisplayed(String.format(CREATE, button_create));
    }

    public boolean isButtonEditProfileDisplayed(String button_edit) {
        return isElementDisplayed(String.format(EDIT_PROFILE_BUTTON, button_edit));
    }

    public boolean isVideoPlayerDisplayed() {
        return isElementDisplayed(PLAYER);
    }

    public void logOut() {
        loginPage.clickElementByXpath(LOGOUT);
    }

    public void mouseHover() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(PHOENIX_EMAIL_LINK))).build().perform();

    }

    public boolean isEmailHighlighted() {
        boolean success = true;
        String color = driver.findElement(By.xpath(PHOENIX_EMAIL_LINK)).getCssValue("color");
        String backcolor = driver.findElement(By.xpath(PHOENIX_EMAIL_LINK)).getCssValue("background-color");

        if (!color.equals(backcolor)) {
            return success;
        } else {
            return success = false;
        }
    }

    public void clickVideButton(String nameOfFile) {

        driver.switchTo().frame(0);
        driver.findElement(By.xpath(VIDEO_PLAYER_BUTTON)).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        takeScreenshot(nameOfFile);
        driver.switchTo().defaultContent();

    }

    public boolean isScreenShotExists(String fileName) {
        Path path = Paths.get("D:/Workspace_Java/phoenix-ui-tester-copy/Screenshots/" + fileName + ".jpeg");
        return Files.exists(path);

    }
}




