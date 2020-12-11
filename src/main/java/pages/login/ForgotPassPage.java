package pages.login;

import pages.BasePage;
import properties.PropertiesFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ForgotPassPage extends BasePage {
    public static final Logger logger = LogManager.getLogger(ForgotPassPage.class);

    public static String FORGOTPASSWORD_PAGE_URL;
    public static String VALID_EMAIL;

    public final static String LOGO = "//h1[@class='logo-name']";
    public final static String LOGO_ADD = "//span[@class='logo-color']";
    public final static String EMAIL_FORM = "//form[@class='ember-view form']//descendant::button[@type='submit']";
    public final static String TRADEUP_LOGO = "//img[@src='../images/logo-c9952b5bf9d4c690b1cdba7f2f6e5089.png']";
    public final static String MAIL_FIELD_OF_ACCOUNT = "//input[@type='email']";
    public final static String APPLY_BUTTON = "//button[@type='submit']";
    public final static String SIGNIN_BUTTON = "//a[@href='/login']";
    public final static String INSTRUCTIONS_MESSAGE = "//*[contains(text(),'All the instructions')]";
    public final static String ERROR_MESSAGE = "//div[@class='toast toast-error']";
    public final static String NOTIFICATION_MESSAGE = "//h3";


    public void navigateToForgotPassPage() {
        driver.get(FORGOTPASSWORD_PAGE_URL);
    }

    public void typeValidEmail() {
        sendKeyToField(MAIL_FIELD_OF_ACCOUNT, VALID_EMAIL);
    }

    public void clickApplyButton() {
        clickElementByXpath(APPLY_BUTTON);
    }

    public void clickSigninButton() {
        clickElementByXpath(SIGNIN_BUTTON);
    }

    public boolean isInstructionMessageDisplayed() {
        return isElementDisplayed(INSTRUCTIONS_MESSAGE);
    }

    public String getInstructionsMessageText() {
        return getElementInnerText(INSTRUCTIONS_MESSAGE);
    }

    public void typeValueEmailFieldOfAccount(String email) {
        sendKeyToField(MAIL_FIELD_OF_ACCOUNT, email);
    }

    public boolean isErrorMessageDisplayed() {
        return isElementDisplayed(ERROR_MESSAGE);
    }

    public boolean isPhoenixLogoVisible() {
        return (isElementDisplayed(LOGO)) && (isElementDisplayed(LOGO_ADD));
    }

    public boolean isEmailFormVisible() {
        return isElementDisplayed(EMAIL_FORM);
    }

    public boolean isTradeupLogoVisible() {
        return isElementDisplayed(TRADEUP_LOGO);
    }

    public String getApplyButtonText() {
        return getElementInnerText(APPLY_BUTTON);
    }

    public String getSigninButtonText() {
        return getElementInnerText(SIGNIN_BUTTON);
    }

    public String getNotificationText() {
        return getElementInnerText(NOTIFICATION_MESSAGE);
    }

    public String getErrorMessageText() {
        return getElementInnerText(ERROR_MESSAGE);
    }
}
