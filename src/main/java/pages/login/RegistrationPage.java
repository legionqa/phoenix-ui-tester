package pages.login;

import pages.BasePage;
import properties.PropertiesFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistrationPage extends BasePage {
    public static final Logger logger = LogManager.getLogger(RegistrationPage.class);

    public static String REGISTRATION_PAGE_URL;

    public final static String CHANGE_LANGUAGE_BUTTON = "//button[contains(text(), 'Change language')]";
    public final static String LANGUAGE_OPTION = "//a[text()='%s']";
    public final static String GREETING_TEXT = "//h3";
    public final static String NAME_FIELD = "(//input[@type='text'])[1]";
    public final static String PHONE_FIELD = "(//input[@type='text'])[2]";
    public final static String PASS_FIELD = "(//input[@type='password'])[1]";
    public final static String PASS_CONF_FIELD = "(//input[@type='password'])[2]";
    public final static String REGISTRATION_BUTTON = "//button[@type='submit']";
    public final static String SIGNIN_BUTTON = "//a[@href='/login']";
    public final static String MAIN_LOGO = "//h1[@class='logo-name']";
    public final static String MAIN_LOGO_ADD = "//span[@class='logo-color']";
    public final static String REGISTER_FORM = "//form[@class='form-lg ember-view form']";
    public final static String TRADEUP_LOGO = "//img[@src='../images/logo-c9952b5bf9d4c690b1cdba7f2f6e5089.png']";
    public final static String SIGNIN_BUTTON_BY_TEXT = "//a[text()='Sign in']";
    public final static String EMAIL_FIELD = "//input[@type='email']";
    public final static String CURRENCY_LIST = "//select";
    public final static String CURRENCY_PLACEHOLDER = "(//select/option)[1]";
    public final static String SKYPE_FIELD = "//input[@placeholder='skype']";

    public final static String CURRENCY_OPTION = "//option[text()='%s']";
    public final static String NO_CURRENCY = "Account currency";
    public final static String VALID_CURRENCY = "USD";

    public final static String EMPTY_STRING = "";
    public final static String CORRECT_EMAIL = "qwerty@qwerty.com";
    public final static String INCORRECT_EMAIL = "qwerty";
    public final static String CORRECT_NAME = "qwerty";
    public final static String PASSWORD = "qwerty";

    public final static String BLANK_EMAIL_MESSAGE_BY_TEXT = "//span[text()=\"This field can't be blank\"]";
    public final static String INVALID_EMAIL_MESSAGE_BY_TEXT = "//span[text()='This field must be a valid email address']";
    public final static String INVALID_NAME_MESSAGE_BY_TEXT = "//span[text()='This field is too short (minimum is 4 characters)']";
    public final static String NO_CURRENCY_MESSAGE = "//div[@class='sweet-alert showSweetAlert visible']";
    public final static String CHECK_DATA_MESSAGE = "//div[@class='toast toast-error']";
    public final static String PASSWORD_ERROR_MESSAGE = "//div[@class='toast toast-warning']";
    public final static String BLANK_EMAIL_MESSAGE = "//input[@type='email']/following::span[@class='help-block']";
    public final static String INVALID_EMAIL_MESSAGE = "//input[@type='email']/following::span[@class='help-block']";
    public final static String INVALID_NAME_MESSAGE = "//input[@type='text']/following::span[@class='help-block']";
    public final static String NO_CURRENCY_TEXT1 = "//div[@class='sweet-alert showSweetAlert visible']//h2";
    public final static String NO_CURRENCY_TEXT2 = "//div[@class='sweet-alert showSweetAlert visible']//p";
    public final static String CHECK_DATA_TEXT1 = "//div[@class='toast-title']";
    public final static String CHECK_DATA_TEXT2 = "//div[@class='toast-message']";

    public final static String INVALID_EMAIL_SIGN = "//span[contains(@class,'glyphicon-remove')]//preceding-sibling::input[@type='email']";
    public final static String VALID_EMAIL_SIGN = "//span[contains(@class,'glyphicon-ok')]//preceding-sibling::input[@type='email']";
    public final static String INVALID_NAME_SIGN = "//span[contains(@class,'glyphicon-remove')]//preceding-sibling::input[@type='text']";
    public final static String VALID_NAME_SIGN = "//span[contains(@class,'glyphicon-ok')]//preceding-sibling::input[@type='text']";

    public void navigateToRegistrationPage() {
        driver.get(REGISTRATION_PAGE_URL);
    }

    public boolean isLogoVisible() {
        return (isElementDisplayed(MAIN_LOGO)) && (isElementDisplayed(MAIN_LOGO_ADD));
    }

    public boolean isRegistrationFormDisplayed() {
        return isElementDisplayed(REGISTER_FORM);
    }

    public boolean isEmailFieldVisible() {
        return isElementDisplayed(EMAIL_FIELD);
    }

    public boolean isSkypeFieldVisible() {
        return isElementDisplayed(SKYPE_FIELD);
    }

    public boolean isChangeLanguageButtonDisplayed() {
        return isElementDisplayed(CHANGE_LANGUAGE_BUTTON);
    }

    public boolean isTradeupLogoVisible() {
        return isElementDisplayed(TRADEUP_LOGO);
    }

    public void sendValueToEmailField(String email) {
        sendKeyToField(EMAIL_FIELD, email);
    }

    public void chooseCurrency(String currency) {
        clickElementByXpath(CURRENCY_LIST);
        clickElementByXpath(String.format(CURRENCY_OPTION, currency));
    }

    public boolean isBlankEmailMessageVisible() {
        return isElementDisplayed(BLANK_EMAIL_MESSAGE_BY_TEXT);
    }

    public boolean isIncorrectEmailMessageVisible() {
        return isElementDisplayed(INVALID_EMAIL_MESSAGE_BY_TEXT);
    }

    public boolean isInvalidNameMessageVisible() {
        return isElementDisplayed(INVALID_NAME_MESSAGE_BY_TEXT);
    }

    public boolean isNoCurrencyErrorMessageVisible() {
        return isElementDisplayed(NO_CURRENCY_MESSAGE);
    }

    public boolean isCheckDataErrorMessageVisible() {
        return isElementDisplayed(CHECK_DATA_MESSAGE);
    }

    public boolean isPasswordsErrorMessageVisible() {
        return isElementDisplayed(PASSWORD_ERROR_MESSAGE);
    }

    public boolean isInvalidEmailSignVisible() {
        return isElementDisplayed(INVALID_EMAIL_SIGN);
    }

    public boolean isValidEmailSignVisible() {
        return isElementDisplayed(VALID_EMAIL_SIGN);
    }

    public boolean isInvalidNameSignVisible() {
        return isElementDisplayed(INVALID_NAME_SIGN);
    }

    public boolean isValidNameSignVisible() {
        return isElementDisplayed(VALID_NAME_SIGN);
    }

    public void clickRegistrationButton() {
        clickElementByXpath(REGISTRATION_BUTTON);
    }

    public void sendValueToNameField(String name) {
        sendKeyToField(NAME_FIELD, name);
    }

    public void sendValueToPasswordField(String name) {
        sendKeyToField(PASS_FIELD, name);
    }

    public void sendValueToPasswordConfirmationField(String name) {
        sendKeyToField(PASS_CONF_FIELD, name);
    }

    public void clickSignInButton() {
        clickElementByXpath(SIGNIN_BUTTON_BY_TEXT);
    }

    public void clickChangeLanguageButton() {
        clickElementByXpath(CHANGE_LANGUAGE_BUTTON);
    }

    public void chooseLanguage(String language) {
        clickElementByXpath(String.format(LANGUAGE_OPTION, language));
    }

    public String getGreetingText() {
        return getElementInnerText(GREETING_TEXT);
    }

    public String getBlankEmailFieldMessageText() {
        return getElementInnerText(BLANK_EMAIL_MESSAGE);
    }

    public String getInvalidEmailFieldMessageText() {
        return getElementInnerText(INVALID_EMAIL_MESSAGE);
    }

    public String getInvalidNameFieldMessageText() {
        return getElementInnerText(INVALID_NAME_MESSAGE);
    }

    public String getNoCurrencyMessageText() {
        return getElementInnerText(NO_CURRENCY_TEXT1).concat(getElementInnerText(NO_CURRENCY_TEXT2));
    }

    public String getCheckDataErrorMessageText() {
        return getElementInnerText(CHECK_DATA_TEXT1).concat(getElementInnerText(CHECK_DATA_TEXT2));
    }

    public String getPasswordErrorMessageText() {
        return getElementInnerText(CHECK_DATA_TEXT2);
    }

    public String getNameFieldPlaceHolder() {
        return getElementPlaceHolder(NAME_FIELD);
    }

    public String getCurrencyPlaceholder() {
        return getElementInnerText(CURRENCY_PLACEHOLDER);
    }

    public String getPhoneFieldPlaceHolder() {
        return getElementPlaceHolder(PHONE_FIELD);
    }

    public String getPassFieldPlaceHolder() {
        return getElementPlaceHolder(PASS_FIELD);
    }

    public String getPassConfFieldPlaceHolder() {
        return getElementPlaceHolder(PASS_CONF_FIELD);
    }

    public String getRegistrationButtonText() {
        return getElementInnerText(REGISTRATION_BUTTON);
    }

    public String getSigninButtonText() {
        return getElementInnerText(SIGNIN_BUTTON);
    }

    public void reloadPage() {
        driver.navigate().refresh();
    }
}
