package pages.profile;

public class ProfilePageNegativeTest extends ProfilePage {
    public final static String RED_CROSS_SING = "//span[@class='form-control-feedback glyphicon glyphicon-remove']";
    public final static String MESSAGE_TEXT_TOO_SHORT = "//span[contains(text(), 'This field is too short')]";
    public final static String FIELD = "//input[@placeholder ='%s']";
    public final static String MAIN_PAGE_LINK = "//a[@href ='/overview']";
    public final static String POPUP_MESSAGE_DATA_LOST = "//div[@class ='sweet-alert showSweetAlert visible']";
    public final static String HEADER_POPUP_MESSAGE_DATA_LOST = "//div[@class='sweet-alert showSweetAlert visible']//h2";
    public final static String BAD_PASSWORD_ERROR_MESSAGE = "//div[@class ='toast-message']";
    public static final String PASSWORD_FIELD = "//input[@placeholder ='%s']";
    public static final String NAME_FIELD = "(//input[@class ='ember-view ember-text-field form-control'])[2]";
    public static final String MAIL_FIELD = "(//input[@class ='ember-view ember-text-field form-control'])[1]";
    public static final String ERROR_NAME_AND_MAIL_FIELDS = "//span[@class ='help-block']";


    public void shortTextNameField() {
        clearFieldByXpath(NAME_FIELD);
        sendKeyToField(NAME_FIELD, "sen");
    }

    public boolean isRedCrossVisible() {
        return isElementDisplayed(RED_CROSS_SING);
    }

    public boolean isErrorMassageTextTooShort() {
        return isElementDisplayed(MESSAGE_TEXT_TOO_SHORT);
    }

    public void sendIncorrectDataMailField(String text) {
        clearFieldByXpath(MAIL_FIELD);
        sendKeyToField(MAIL_FIELD, text);
    }


    public void textInField(String field, String text) {
        sendKeyToField(String.format(FIELD, field), text);
    }

    public void clickMainMenu() {
        clickElementByXpath(MAIN_PAGE_LINK);
    }

    public boolean IsPopUpMessageAppearing() {
        return isElementDisplayed(POPUP_MESSAGE_DATA_LOST);
    }

    public boolean isErrorMessageDisplayed() {
        return isElementDisplayed(BAD_PASSWORD_ERROR_MESSAGE);
    }

    public void sendNotEqualsDataInNewConfirmationFields() {
        sendKeyToField(NEW_PASSWORD_FIELD, "notdata");
        sendKeyToField(CONFIRMATION_PASSWORD_FIELD, "data");
    }

    public String getTextBadPasswordErrorMessage() {
        return getElementText(BAD_PASSWORD_ERROR_MESSAGE);
    }

    public void sendDataAnyPasswordField(String nameField, String text) {
        sendKeyToField(String.format(PASSWORD_FIELD, nameField), text);
    }

    public String textErrorMessageFromNameOrMailField() {
        return getElementText(ERROR_NAME_AND_MAIL_FIELDS);
    }


    public String textHeaderErrorDataWillBeLost() {
        return getElementInnerText(HEADER_POPUP_MESSAGE_DATA_LOST);
    }
}


