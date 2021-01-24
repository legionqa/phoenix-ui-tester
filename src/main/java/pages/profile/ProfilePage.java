package pages.profile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.login.LoginPage;
import pages.mySites.MySitesPage;

import java.util.List;


public class ProfilePage extends BasePage {
    public static final Logger logger = LogManager.getLogger(ProfilePage.class);
    public static String PROFILE_PAGE_URL;
    public static String PROFILE_PAGE_URL_NEW_USER;
    public static String TEST_USER_MAIL;
    public static String TEST_USER_PASSWORD;
    public static String TEST_USER_NEW_PASSWORD;
    public static String TEST_USER_NEW_MAIL;

    public final static String MAIL_FIELD = "//input[@type='email']";
    public final static String CURRENCY_FIELD = "//div[@class = 'ember-view form-group is-disabled']";
    public static final String VIEW_ACTIVE_MENU = "//a[@class = 'ember-view active']";
    public static final String PROFILE_MAIN_MENU = "[text() = 'Profile']";
    public static final String MY_PROFILE_USER_PANEL = "[text() = 'My profile']";
    public static final String USER_PANEL_CARET = "//b[@class = 'caret']";
    public static final String BUTTON_CHANGE_LANGUAGE = "//button[contains(text(), 'Change language')]";
    public static final String EDITING_PROFILE_BLOCK = "(//h5)[1]";
    public static final String NAME_FIELD = "(//input[@class = 'ember-view ember-text-field form-control'])[2]";
    public static final String PHONE_FIELD = "(//input[@class = 'ember-view ember-text-field form-control'])[3]";
    public static final String CHANGING_PASSWORD_BLOCK = "(//h5)[2]";
    public static final String COLLAPSING_PASSWORD_BLOCK = "//i[@class = 'fa fa-chevron-down']";
    public static final String PLACEHOLDER_PASS = "//input[@placeholder ='%s']";
    public static final String SAVE_BUTTON = "(//button[@class = 'ember-view btn btn-primary'])[1]";
    public static final String CHANGE_BUTTON = "(//button[@class = 'ember-view btn btn-primary'])[2]";
    public static final String CANCEL_BUTTON = "//button[@class = 'ember-view btn btn-default']";
    public static final String MAIN_MENU = "//a[@href = '/overview']";
    public static final String USER_NAME_USER_PANEL = "//h2[@class = 'm-b-xs']";
    public static final String MAIL_USER_PANEL = "(//div[@class = 'ember-view dropdown']/*[text()])[1]";
    public static final String SKYPE_FIELD = "//input[@placeholder = 'skype']";
    public static final String SUCCESS_MESSAGE = "//div[@class = 'toast toast-success']";
    public static final String VALID_SIGN_MAIL_FIELD = "(//span[@class = 'form-control-feedback glyphicon glyphicon-ok'])";
    public static final String VALID_SIGN_NAME_FIELD = "(//span[@class = 'form-control-feedback glyphicon glyphicon-ok'])[1]";
    public static final String CURRENT_PASSWORD_FIELD = "//input[@placeholder ='Current password']";
    public static final String NEW_PASSWORD_FIELD = "//input[@placeholder ='New password']";
    public static final String CONFIRMATION_PASSWORD_FIELD = "//input[@placeholder ='Password confirmation']";
    public static final String CHANGE_PASSWORD_SUCCESS_MESSAGE = "//div[@class = 'toast toast-success']";
    public static final String LOGOUT_BUTTON = "//a[text() = 'Log out']";
    public static final String BAD_PASSWORD_MESSAGE = "//div[@class = 'toast toast-error']//div[@class='toast-message']";
    public static final String SUCCESS_MESSAGE_ACCOUNT = "//div[@class = 'toast toast-success']//div[@class='toast-message']";
    public final static String ERROR_MESSAGE_MAIL_FIELD = "//span[@class ='help-block']";


    public void navigateToProfilePage() {
        driver.get(PROFILE_PAGE_URL);
    }

    public void goToProfilePageNewUser() {
        driver.get(PROFILE_PAGE_URL_NEW_USER);
    }

    public boolean isEmailFieldDisplayed() {
        return isElementDisplayed(MAIL_FIELD);
    }

    public boolean isCurrencyFieldDisplayed() {
        return isElementDisplayed(CURRENCY_FIELD);
    }

    public boolean profileIsActivesMainMenu() {
        return isElementDisplayed(VIEW_ACTIVE_MENU + PROFILE_MAIN_MENU);
    }

    public void openUserPanelMenu() {
        clickElementByXpath(USER_PANEL_CARET);
    }

    public boolean myProfileIsActivesUserPanel() {
        return isElementDisplayed(VIEW_ACTIVE_MENU + MY_PROFILE_USER_PANEL);
    }

    public void clickChangeLanguageButton() {
        clickElementByXpath(BUTTON_CHANGE_LANGUAGE);
    }

    public String getEditingProfileBlockText() {
        return getElementInnerText(EDITING_PROFILE_BLOCK);
    }

    public String getNamePlaceHolder() {
        return getElementPlaceHolder(NAME_FIELD);
    }

    public String getPhonePlaceHolder() {
        return getElementPlaceHolder(PHONE_FIELD);
    }

    public String getChangingPasswordBlockBlockText() {
        return getElementInnerText(CHANGING_PASSWORD_BLOCK);
    }

    public void clickCollapsingChangePasswordBlock() {
        clickElementByXpath(COLLAPSING_PASSWORD_BLOCK);
    }

    public String getCurrentPasswordPlaceHolder(String text) {
        return getElementPlaceHolder(String.format(PLACEHOLDER_PASS, text));
    }

    public String getNewPasswordPlaceHolder(String text) {
        return getElementPlaceHolder(String.format(PLACEHOLDER_PASS, text));
    }

    public String getPasswordConfirmationPlaceHolder(String text) {
        return getElementPlaceHolder(String.format(PLACEHOLDER_PASS, text));
    }

    public String getSaveButtonText() {
        return getElementInnerText(SAVE_BUTTON);
    }

    public String getChangeButtonText() {
        return getElementInnerText(CHANGE_BUTTON);
    }

    public void sendTextToNameField() {
        sendKeyToField(NAME_FIELD, " ");
    }

    public String getCancelButtonText() {
        return getElementInnerText(CANCEL_BUTTON);
    }

    public void reloadPage() {
        clickElementByXpath(MAIN_MENU);
        driver.navigate().back();
    }

    public String getMailFieldText() {
        return getElementValue(MAIL_FIELD);
    }

    public String getNameFieldText() {
        return getElementValue(NAME_FIELD);
    }

    public String getDataFromPhoneField() {
        return getElementValue(PHONE_FIELD);
    }

    public boolean isCancelButtonDisplayed() {
        return isElementDisplayed(CANCEL_BUTTON);
    }

    public String getNameFromUserPanel() {
        return getElementText(USER_NAME_USER_PANEL);
    }

    public String getEmailFromUserPanel() {
        return getElementText(MAIL_USER_PANEL);
    }

    public void typeNewDataInMailField(String text) {
        clearFieldByXpath(MAIL_FIELD);
        sendKeyToField(MAIL_FIELD, text);
    }

    public void typeNewDataInNameField(String text) {
        clearFieldByXpath(NAME_FIELD);
        sendKeyToField(NAME_FIELD, text);
    }

    public void sendNumberInPhoneField(String text) {
        clearFieldByXpath(PHONE_FIELD);
        sendKeyToField(PHONE_FIELD, text);
    }

    public void sendNameInSkypeField(String text) {
        clearFieldByXpath(SKYPE_FIELD);
        sendKeyToField(SKYPE_FIELD, text);
    }

    public boolean isSkypeFieldDisplayed() {
        return isElementDisplayed(SKYPE_FIELD);
    }

    public void clickSaveButton() {
        clickElementByXpath(SAVE_BUTTON);
    }

    public boolean successMessageIsVisible() {
        return isElementDisplayed(SUCCESS_MESSAGE);
    }

    public void returnPhoneAndSkypeToOriginal() {
        sendNumberInPhoneField("4578974");
        sendNameInSkypeField("Legion QA");
        clickSaveButton();
    }

    public void clickCancel() {
        clickElementByXpath(CANCEL_BUTTON);
    }

    public boolean isValidSignInMailFIELDDisplayed() {
        return isElementDisplayed(VALID_SIGN_MAIL_FIELD);
    }

    public boolean isValidSignInNameFieldDisplayed() {
        return isElementDisplayed(VALID_SIGN_NAME_FIELD);
    }

    public void loginWithTestEmail() {
        loginToDashboard(TEST_USER_MAIL, TEST_USER_PASSWORD);
    }

    public void sendPasswordInCurrentField(String password) {
        sendKeyToField(CURRENT_PASSWORD_FIELD, password);
    }

    public void sendStringInNewPasswordAndConfirmationFields(String newPass) {
        sendKeyToField(NEW_PASSWORD_FIELD, newPass);
        sendKeyToField(CONFIRMATION_PASSWORD_FIELD, newPass);
    }

    public void clickChangeButton() {
        clickElementByXpath(CHANGE_BUTTON);
    }

    public boolean changePasswordSuccessMassageDisplayed() {
        return isElementDisplayed(CHANGE_PASSWORD_SUCCESS_MESSAGE);
    }

    public void returnPasswordToOriginal() {
        clearFieldByXpath(CURRENT_PASSWORD_FIELD);
        sendPasswordInCurrentField(TEST_USER_NEW_PASSWORD);
        clearFieldByXpath(NEW_PASSWORD_FIELD);
        clearFieldByXpath(CONFIRMATION_PASSWORD_FIELD);
        sendStringInNewPasswordAndConfirmationFields(TEST_USER_PASSWORD);
        clickChangeButton();
    }

    public void changeMailToNewTestMail() {
        typeNewDataInMailField(TEST_USER_NEW_MAIL);
    }

    public void clickLogOutMenu() {
        openUserPanelMenu();
        clickElementByXpath(LOGOUT_BUTTON);
    }

    public void loginWithNewTestMail() {
        loginToDashboard(TEST_USER_NEW_MAIL, TEST_USER_PASSWORD);
    }

    public void changeMailToTestMail() {
        typeNewDataInMailField(TEST_USER_MAIL);
    }


    public void clickElementWithJS() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", driver.findElement(By.xpath(LOGOUT_BUTTON)));
    }

    public String getTextSuccessMessage() {
        return getElementInnerText(SUCCESS_MESSAGE);
    }

    public String getTextBadPasswordMessage() {
        return getElementInnerText(BAD_PASSWORD_MESSAGE);
    }

    public String getTextMassageSaveAccount() {
        return getElementInnerText(SUCCESS_MESSAGE_ACCOUNT);
    }

    public String getTextErrorInMailField() {
        return getElementText(ERROR_MESSAGE_MAIL_FIELD);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
}





