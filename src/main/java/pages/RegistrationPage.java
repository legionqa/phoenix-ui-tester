package pages;

public class RegistrationPage extends BasePage {
    public final static String REGISTER_FORM = "//*[@id='ember640']";
    public final static String EMAIL_FIELD = "//*[@id='ember674-field']";
    public final static String EMAIL_ERROR_MESSAGE = "//*[@id='ember674']/span[2]";
    public final static String NAME_ERROR_MESSAGE = "//*[@id='ember747']/span[2]";
    public final static String PHONE_FIELD = "//*[@id='ember797-field']";
    public final static String SKYPE_FIELD = "//*[@id='ember798-field']";
    public final static String PASS_FIELD = "//*[@id='ember799-field']";
    public final static String PASS_CONF_FIELD = "//*[@id='ember800-field']";
    public final static String BUTTON_SIGN_IN = "//*[@id='ember862']";
    public final static String CURRENCY_FIELD = "//*[@id='ember769']";
    public final static String PASSWORD_ERROR_MESSAGE = "//*[contains(text(),'Пароли не совпадают')]";
    public final static String BUTTON_CHANGE_LANGUAGE = "//*[@id='ember841']";

    public final static String BUTTON_REGISTER = "//*[@id='ember813']";
    public final static String NAME_FIELD = "//*[@id='ember747-field']";

    public void navigateToRegistrationPage(String url) {
        driver.get(url);
    }

    public boolean isRegisterFormDisplayed() {
        return isElementDisplayed(REGISTER_FORM);
    }

    public void typeValueEmailField(String email) {
        sendTheKeyToField(EMAIL_FIELD, email);
    }

    public boolean isEmailErrorMessaeVisible() {
        return isElementDisplayed(EMAIL_ERROR_MESSAGE);
    }

    public void clickButtonRegister() {
        clickElementByXpath(BUTTON_REGISTER);
    }

    public void typeValueNameField(String name) {
        sendTheKeyToField(NAME_FIELD, name);
    }

    public boolean isNameErrorMessaeVisible() {
        return isElementDisplayed(NAME_ERROR_MESSAGE);
    }

    public void typeValuePhoneField(String phone) {
        sendTheKeyToField(PHONE_FIELD, phone);
    }

    public String getPhoneFieldValue() {

        return getElementValue(PHONE_FIELD);

    }

    public void typeValueSkypeField(String skype) {
        sendTheKeyToField(SKYPE_FIELD, skype);
    }

    public String getSkypeFieldValue() {

        return getElementValue(SKYPE_FIELD);
    }

    public void typeValuePasswordField(String pass) {
        sendTheKeyToField(PASS_FIELD, pass);
    }
//    public String getPasswordFieldValue() {
//
//        return getElementValue(PASS_FIELD);
//    }

    public void typeValuePasswordConfField(String passConf) {
        sendTheKeyToField(PASS_CONF_FIELD, passConf);
    }

    //    public String getPasswordConfFieldValue() {
//
//        return getElementValue(PASS_CONF_FIELD);
//    }
    public boolean isButtonSignInVisible() {
        return isElementDisplayed(BUTTON_SIGN_IN);
    }

    public void clickSignInButton() {
        clickElementByXpath(BUTTON_SIGN_IN);
    }

    public void clickCurrencyField() {
        clickElementByXpath(CURRENCY_FIELD);
    }

    public void chooseCurrency(String currency) {
        clickElementByXpath("//select[@id='ember769']/option[text()='" + currency + "']");

    }
    public String getCurrencyFieldValue(){
        return getElementValue(CURRENCY_FIELD);
    }
    public boolean isPasswordErrorMessageVisible() {
        return isElementDisplayed(PASSWORD_ERROR_MESSAGE);
    }

    public void clickChangeLanguageButton(){
        clickElementByXpath(BUTTON_CHANGE_LANGUAGE);
    }

    public void chooseLanguage(String language) {
        clickElementByXpath("//a[text()='" + language + "']");
    }

    public String getEmailFieldPlaceHolder() {
        return getElementPlaceHolder(EMAIL_FIELD);
    }

    public String getNameFieldPlaceHolder() {
        return getElementPlaceHolder(NAME_FIELD);
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
    public String getButtonRegisterInnerText() {
        return getElementInnerText(BUTTON_REGISTER);
    }

    public String getSkypeFieldPlaceHolder() {
        return getElementPlaceHolder(SKYPE_FIELD);
    }

}
