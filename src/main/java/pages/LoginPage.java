package pages;

import properties.PropertiesFile;

public class LoginPage extends BasePage {
    public static String LOGIN_PAGE_URL;
    public static String MAIN_PAGE_URL;
    public static String ROOT_URL;

    public static String VALID_EMAIL;
    public static String VALID_PASSWORD;
    public static String USERNAME;

    public final static String LOGO = "//h1[@class='logo-name']";
    public final static String LOGO_ADD = "//span[@class='logo-color']";
    public final static String GREETING_MESSAGE = "//h3[text()='%s']";
    public final static String LOGIN_FORM = "//form[@class='ember-view form']";
    public final static String CHANGE_LANGUAGE_BUTTON = "//button[contains(text(), 'Change language')]";
    public final static String LANGUAGE_OPTION = "//a[text()='%s']";
    public final static String LOGIN_BUTTON = "//button[@type='submit']";
    public final static String TRADEUP_LOGO = "//img[@src='../images/logo-c9952b5bf9d4c690b1cdba7f2f6e5089.png']";
    public final static String LINK_BY_TEXT = "//a[text()='%s']";
    public final static String CREATE_ACCOUNT_BUTTON = "//a[@href='/register']";
    public final static String EMAIL_FIELD = "//input[@type='email']";
    public final static String PASSWORD_FIELD = "//input[@type='password']";
    public final static String FORGET_PASSWORD_LINK = "//a[@href='/forgotpass']";

    public final static String MAIN_PAGE_USERNAME = "//h2[@class='m-b-xs']";
    public final static String ERROR_MESSAGE = "//div[@class='toast toast-error']";
    public final static String ERROR_MESSAGE_TEXT = "//div[@class='toast-title'][text()='%s']";

    public final static String LOGOUT_BUTTON = "//i[@class='fa-lg ember-view fa fa-sign-out']";

    public void navigateToLoginPage() {
        PropertiesFile.readPropertiesFile();
        driver.get(LOGIN_PAGE_URL);
    }

    public boolean isMainLogoDisplayed() {
        return (isElementDisplayed(LOGO)) && (isElementDisplayed(LOGO_ADD));
    }

    public boolean isLogInFormDisplayed() {
        return isElementDisplayed(LOGIN_FORM);
    }

    public boolean isChangeLanguageButtonDisplayed() {
        return isElementDisplayed(LOGIN_FORM);
    }

    public boolean isTradeUpLogoDisplayed() {
        return isElementDisplayed(TRADEUP_LOGO);
    }

    public void clickChangeLanguageButton() {
        clickElementByXpath(CHANGE_LANGUAGE_BUTTON);
    }

    public void chooseLanguage(String language) {
        clickElementByXpath(String.format(LANGUAGE_OPTION, language));
    }

    public boolean isGreetingTextDisplayed(String greeting) {
        return isElementDisplayed(String.format(GREETING_MESSAGE, greeting));
    }

    public void clickLink(String link) {
        clickElementByXpath(String.format(LINK_BY_TEXT, link));
    }

    public String getLoginButtonText() {
        return getElementInnerText(LOGIN_BUTTON);
    }

    public String getCreateAnAccountButtonText() {
        return getElementInnerText(CREATE_ACCOUNT_BUTTON);
    }

    public void sendTextToEmailField(String email) {
        sendKeyToField(EMAIL_FIELD, email);
    }

    public void sendTextToPasswordField(String pass) {
        sendKeyToField(PASSWORD_FIELD, pass);
    }

    public String getUserName() {
        return getElementInnerText(MAIN_PAGE_USERNAME);
    }

    public void clickLoginButton() {
        clickElementByXpath(LOGIN_BUTTON);
    }

    public boolean isErrorMessageVisible() {
        return isElementDisplayed(ERROR_MESSAGE);
    }

    public boolean isErrorMessageWithTextVisible(String text) {
        return isElementDisplayed(String.format(ERROR_MESSAGE_TEXT, text));
    }

    public String getForgotPasswordLinkText() {
        return getElementInnerText(FORGET_PASSWORD_LINK);
    }

    public void clickForgotPasswordLink() {
        clickElementByXpath(FORGET_PASSWORD_LINK);
    }

    public void clickLogoutButton() {
        clickElementByXpath(LOGOUT_BUTTON);
    }

}