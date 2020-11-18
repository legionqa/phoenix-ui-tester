package pages;

public class LoginPage extends BasePage {
    public final static String LOGO = "//h1[@class='logo-name']";
    public final static String LOGIN_BAR = "//*[@id='ember608']";
    public final static String BUTTON_CHANGE_LANGUAGE = "//*[@id='ember696']";
    public final static String BUTTON_LOG_IN = "//*[@id='ember637']";
    public final static String ERROR_MESSAGE = "//*[contains(text(),'Ошибка')]";


    public final static String BUTTON_NAME = "//button[@id='ember637']";
    public final static String ACCOUNT_NAME = "//*[@id='ember710']";
    public final static String EMAIL_FIELD = "//*[@id='ember621']";
    public final static String PASSWORD_FIELD = "//*[@id='ember622']";
    public final static String FORGET_PASSWORD = "//*[@id='ember645']";


    public void navigateToLoginPage(String url) {
        driver.get(url);
    }

    public boolean isMainLogoDisplayed() {
        return isElementDisplayed(LOGO);
    }

    public boolean isLogInBarDisplayed() {
        return isElementDisplayed(LOGIN_BAR);
    }

    public void clickButtonChangeLanguage() {
        clickElementByXpath(BUTTON_CHANGE_LANGUAGE);
    }

    public void chooseLanguage(String language) {
        clickElementByXpath("//a[text()='" + language + "']");
    }


    public boolean isGreetingTextDisplayed(String greeting) {
        return isElementDisplayed("//*[contains(text(),'" + greeting + "')]");
    }


    public String buttonNameDisplayed() {
        return getElementInnerText(BUTTON_NAME);
    }

    public String accountNameDisplayed() {
        return getElementInnerText(ACCOUNT_NAME);
    }

    public void typeValueEmailField(String email) {
        sendTheKeyToField(EMAIL_FIELD, email);
    }

    public void typeValuePasswordField(String pass) {
        sendTheKeyToField(PASSWORD_FIELD, pass);
    }

    public void clickButtonLogIn() {
        clickElementByXpath(BUTTON_LOG_IN);
    }

    public boolean isMainLogoVisible() {
        return isElementDisplayed(LOGO);
    }

    public boolean isErrorMessaeVisible() {
        return isElementDisplayed(ERROR_MESSAGE);
    }

    public String forgetPasswordDisplayed() {
        return getElementInnerText(FORGET_PASSWORD);
    }

    public ForgotPassPage clickForgotPasswordLink() {
        clickElementByXpath(FORGET_PASSWORD);
        return new ForgotPassPage();
    }

}