package pages;

public class ForgotPassPage extends BasePage {

    public final static String MAIL_FIELD_OF_ACCOUNT = "//input[@placeholder='E-mail']";
    public final static String BUTTON_SUBMIT = "//button[@type='submit']";
    public final static String INSTRUCTIONS_MESSAGE = "//*[contains(text(),'All the instructions')]";
    public final static String ERROR_MESSAGE = "//*[contains(text(),'Произошла ошибка')]";
    public final static String NOTIFICATION_MESSAGE = "//h3";


    public void typeValuePasswordConfField(String email) {
        sendTheKeyToField(MAIL_FIELD_OF_ACCOUNT, email);
    }

    public void clickButtonApply() {
        clickElementByXpath(BUTTON_SUBMIT);
    }

    public void navigateToForgotPassPage(String url) {
        driver.get(url);
    }

    public boolean isNotificationDisplayed() {
        return isElementDisplayed(INSTRUCTIONS_MESSAGE);
    }

    public void typeValueEmailFieldOfAccount(String email) {
        sendTheKeyToField(MAIL_FIELD_OF_ACCOUNT, email);
    }

    public boolean isErrorMessageDisplayed() {
        return isElementDisplayed(ERROR_MESSAGE);
    }

    public String getButtonApplyInnerText() {
        String innertext = getElementInnerText(BUTTON_SUBMIT);
        return innertext;
    }

    public String getNotificationMessageInnerText() {
        String innerText = getElementInnerText(NOTIFICATION_MESSAGE);
        return innerText;
    }
}
