package pages.mySites;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SiteSettingsPage extends MySitesPage {

    public static final String SITE_SETTINGS_PAGE_URL = "/edit";
    public static final String SETTINGS_HEADER = "Settings";
    public static final String MAIN_SETTINGS_HEADER = "Main settings";
    public static final String BLOCK_WAITING = "(//div[@style='display: none;' or @style='display: block;'])[2]";

    public static final String SETTINGS_HEADER_BY_XPATH = "(//h5)[1]";
    public static final String MAIN_SETTINGS_HEADER_BY_XPATH = "(//h5)[2]";

    public static final String NAME_FIELD = "(//input)[1]";
    public static final String URL_FIELD = "//input[@placeholder='http://domain.com']";
    public static final String UTM_SOURCE_FIELD = "//input[@placeholder='?utm_source=phoenix']";
    public static final String CATEGORY_LIST = "(//select)[1]";
    public static final String CATEGORY_OPTIONS_LIST = "(//select)[1]/option";
    public static final String CATEGORY_OPTION = "((//select)[1]/option)[%d]";
    public static final String CATEGORY_BY_NAME = "(//select)[1]/option[text()='%s']";
    public static final String CATEGORY_PLACEHOLDER = "Choose the category";
    public static final String COUNTRY_LIST = "(//select)[2]";
    public static final String COUNTRY_OPTIONS_LIST = "(//select)[2]/option";
    public static final String COUNTRY_OPTION = "((//select)[2]/option)[%d]";
    public static final String COUNTRY_BY_NAME = "(//select)[2]/option[text()='%s']";
    public static final String COUNTRY_PLACEHOLDER = "Choose the country";
    public static final String LANGUAGE_LIST_INPUT = "//div[contains(@class, 'selectize-input')]/input";
    public static final String LANGUAGE_LIST = "//div[contains(@class, 'selectize-input')]";
    public static final String LANGUAGE_BY_NAME = "//div[text()='%s']";
    public static final String LANGUAGE_SELECTED_OPTION = "(//div[contains(@class, 'selectize-input')]/div)[1]";
    public static final String WORDS_BLACKLIST = "(//input)[4]";
    public static final String QUESTION_CIRCLE = "//i[contains(@class, 'question-circle')]";
    public static final String STATUS_LIST = "(//select)[4]";
    public static final String STATUS_OPTION = "((//select)[4]/option)[%d]";
    public static final String STATUS_ACTIVE = "((//select)[4]/option)[1]";
    public static final String STATUS_INACTIVE = "((//select)[4]/option)[2]";
    public static final String STATUS_INACTIVE_VALUE = "inactive";
    public static final String SAVE_BUTTON = "//button[@type='submit']";
    public static final String BACK_BUTTON = "//button[@type='button' and not(@role='button')]";
    public static final String MY_SITES_MENU = "//ul//a[@href='/users/5fa1d8ffc903de27cc069de4/sites']";

    public static final String DATA_LOST_MESSAGE = "//div[contains(@class, 'sweet-alert')]";
    public static final String DATA_LOST_TEXT1 = "//div[contains(@class, 'sweet-alert')]//h2";
    public static final String DATA_LOST_TEXT2 = "//div[contains(@class, 'sweet-alert')]//p";
    public static final String MESSAGE_GO_BUTTON = "//div[contains(@class, 'sweet-alert')]//button[@class='confirm']";
    public static final String MESSAGE_CANCEL_BUTTON = "//div[contains(@class, 'sweet-alert')]//button[@class='cancel']";

    public static final String CATEGORY_LABEL = "((//tr)[%d]/td)[3]/small";
    public static final String COUNTRY_LABEL = "((//tr)[%d]/td)[4]/small";

    public static final String NAME_INVALID_SIGN = "(//input)[1]//following-sibling::span[contains(@class, 'remove')]";
    public static final String NAME_VALID_SIGN = "(//input)[1]//following-sibling::span[contains(@class, 'glyphicon-ok')]";
    public static final String ERROR_MESSAGE = "//span[@class='help-block']";
    public static final String URL_INVALID_SIGN = "//input[@placeholder='http://domain.com']//following-sibling::span[contains(@class, 'remove')]";
    public static final String URL_VALID_SIGN = "//input[@placeholder='http://domain.com']//following-sibling::span[contains(@class, 'glyphicon-ok')]";
    public static final String NAME_FIELD_MESSAGE = "(//input)[1]//following-sibling::span[@class='help-block']";
    public static final String URL_FIELD_MESSAGE = "//input[@placeholder='http://domain.com']//following-sibling::span[@class='help-block']";
    public static final String GENERAL_ERROR_MESSAGE = "//div[@class='toast toast-error']";

    public static final String SHORT_NAME = "qwe";
    public static final String STRING_WITHOUT_DOT = "qwerty";
    public static final String URL_WITHOUT_HTTP = "qwerty.test";
    public static final String NEWS = "News";
    public static final String UKRAINE = "Ukraine";
    public static final String AWADHI = "Awadhi";
    public static final String TEST_SITE_4_NAME = "Test site 4";
    public static final String TEST_SITE_4_URL = "http://test4.test";
    public static final String TEST_SITE_1_URL = "http://test1.test";
    public static final String MESSAGE_VISIBLE_STYLE = "display: block;";
    public static final String MESSAGE_INVISIBLE_STYLE = "display: none;";



    public boolean isUrlFieldVisible() {
        return isElementDisplayed(URL_FIELD);
    }

    public boolean isUtmSourceFieldVisible() {
        return isElementDisplayed(UTM_SOURCE_FIELD);
    }

    public String getSettingsHeaderText() {
        return getElementText(SETTINGS_HEADER_BY_XPATH);
    }

    public String getMainSettingsHeaderText() {
        return getElementText(MAIN_SETTINGS_HEADER_BY_XPATH);
    }

    public String getNameFieldPlaceholder() {
        return getElementPlaceHolder(NAME_FIELD);
    }

    public String getSelectedCategory() {
        return getSelectedOption(CATEGORY_LIST);
    }

    public String getSelectedCountry() {
        return getSelectedOption(COUNTRY_LIST);
    }

    public String getSelectedLanguage() {
        try {
            return getElementText(LANGUAGE_SELECTED_OPTION);
        } catch (Exception e) {
            return "";
        }
    }

    public String getLanguageListPlaceholder() {
        return getElementPlaceHolder(LANGUAGE_LIST_INPUT);
    }

    public String getWordsBlacklistPlaceholder() {
        return getElementPlaceHolder(WORDS_BLACKLIST);
    }

    public String getWordsBlacklistTooltip() {
        return getElementTitle(QUESTION_CIRCLE);
    }

    public String getWordsBlacklistFieldContent() {
        return getElementValue(WORDS_BLACKLIST);
    }

    public String getUtmFieldContent() {
        return getElementValue(WORDS_BLACKLIST);
    }

    public String getStatusOption(int number) {
        return getElementText(String.format(STATUS_OPTION, number)).trim();
    }

    public String getSaveButtonText() {
        return getElementText(SAVE_BUTTON);
    }

    public String getBackButtonText() {
        return getElementText(BACK_BUTTON);
    }

    public void clickSaveButton() {
        clickElementByXpath(SAVE_BUTTON);
    }

    public void testCategoryOptions() {
        List<AssertionError> errors = new ArrayList<>();
        int listSize = getElementsListByXpath(CATEGORY_OPTIONS_LIST).size();
        for (int i = 1; i < listSize; i++) {
            String option = getElementText(String.format(CATEGORY_OPTION, i+1)).trim();
            selectCategoryByNumber(i+1);
            clickSaveButton();
            try {
                assertEquals(option, getElementText(String.format(CATEGORY_LABEL, getSiteLineNumberByName(TEST_SITE_1_NAME))));
            } catch (AssertionError ae) {
                logger.info(ae.getMessage());
                errors.add(ae);
            }
            try {
                clickSiteSettingsButton(TEST_SITE_1_NAME);
            } catch (ElementClickInterceptedException e) {
                closeMessenger();
                clickSiteSettingsButton(TEST_SITE_1_NAME);
            }
        }
        clickElementByXpath(CATEGORY_LIST);
        clickElementByXpath(String.format(CATEGORY_OPTION, 1));
        clickSaveButton();
        assertEquals(0, errors.size());
    }

    public void testCountryOptions() {
        List<AssertionError> errors = new ArrayList<>();
        int listSize = getElementsListByXpath(COUNTRY_OPTIONS_LIST).size();
        for (int i = 1; i < listSize; i++) {
            String option = getElementText(String.format(COUNTRY_OPTION, i+1)).trim();
            selectCountryByNumber(i+1);
            clickSaveButton();
            try {
                assertEquals(option, getElementText(String.format(COUNTRY_LABEL, getSiteLineNumberByName(TEST_SITE_1_NAME))));
            } catch (AssertionError ae) {
                logger.info(ae.getMessage());
                errors.add(ae);
            }
            try {
                clickSiteSettingsButton(TEST_SITE_1_NAME);
            } catch (ElementClickInterceptedException e) {
                closeMessenger();
                clickSiteSettingsButton(TEST_SITE_1_NAME);
            }
        }
        clickElementByXpath(COUNTRY_LIST);
        clickElementByXpath(String.format(COUNTRY_OPTION, 1));
        clickSaveButton();
        assertEquals(0, errors.size());
    }

    public void sendUrl(String url) {
        sendKeyToField(URL_FIELD, url);
    }

    public void sendName(String name) {
        sendKeyToField(NAME_FIELD, name);
    }

    public void sendBlackList(String text) {
        sendKeyToField(WORDS_BLACKLIST, text);
    }

    public void sendUtmSource(String text) {
        sendKeyToField(UTM_SOURCE_FIELD, text);
    }

    public void clearNameField() {
        clearFieldByXpath(NAME_FIELD);
    }

    public void clearUrlField() {
        clearFieldByXpath(URL_FIELD);
    }

    public void clearBlackListField() {
        clearFieldByXpath(WORDS_BLACKLIST);
    }

    public void clearUtmField() {
        clearFieldByXpath(UTM_SOURCE_FIELD);
    }

    public void clearLanguageField() {
        clickElementByXpath(LANGUAGE_LIST);
        sendKeyToField(LANGUAGE_LIST_INPUT, Keys.BACK_SPACE.toString());
    }

    public boolean isInvalidNameSignDisplayed() {
        return isElementDisplayed(NAME_INVALID_SIGN);
    }

    public boolean isValidNameSignDisplayed() {
        return isElementDisplayed(NAME_VALID_SIGN);
    }

    public boolean isInvalidUrlSignDisplayed() {
        return isElementDisplayed(URL_INVALID_SIGN);
    }

    public boolean isValidUrlSignDisplayed() {
        return isElementDisplayed(URL_VALID_SIGN);
    }

    public boolean isGeneralErrorMessageDisplayed() {
        return isElementDisplayed(GENERAL_ERROR_MESSAGE);
    }

    public boolean isAnyErrorMessageVisible() {
        return isElementDisplayed(ERROR_MESSAGE);
    }

    public String getNameFieldMessage() {
        return getElementText(NAME_FIELD_MESSAGE);
    }

    public String getUrlFieldMessage() {
        return getElementText(URL_FIELD_MESSAGE);
    }

    public void setSiteActive() {
        clickElementByXpath(STATUS_LIST);
        clickElementByXpath(STATUS_ACTIVE);
    }

    public void setSiteInactive() {
        clickElementByXpath(STATUS_LIST);
        clickElementByXpath(STATUS_INACTIVE);
    }

    public boolean isTestSite4LineVisible() {
        return isElementDisplayed(String.format(SITE_LINE_NAME, TEST_SITE_4_NAME));
    }

    public void resetTestSite1Data() {
            clearNameField();
            sendName(TEST_SITE_1_NAME);
            clearUrlField();
            sendUrl(TEST_SITE_1_URL);
            setSiteInactive();
            clearBlackListField();
            clearUtmField();
            selectCategoryByNumber(1);
            selectCountryByNumber(1);
            clearLanguageField();
            clickSaveButton();
            getSiteLineNumberByName(TEST_SITE_1_NAME); //wait for change saving
    }

    public void selectCategoryByName(String name) {
        clickElementByXpath(CATEGORY_LIST);
        clickElementByXpath(String.format(CATEGORY_BY_NAME, name));
    }

    public void selectCategoryByNumber(int number) {
        clickElementByXpath(CATEGORY_LIST);
        clickElementByXpath(String.format(CATEGORY_OPTION, number));
    }

    public void selectCountryByName(String name) {
        clickElementByXpath(COUNTRY_LIST);
        clickElementByXpath(String.format(COUNTRY_BY_NAME, name));
    }

    public void selectCountryByNumber(int number) {
        clickElementByXpath(COUNTRY_LIST);
        clickElementByXpath(String.format(COUNTRY_OPTION, number));
    }

    public void selectLanguageByName(String name) {
        clickElementByXpath(LANGUAGE_LIST);
        clickElementByXpath(String.format(LANGUAGE_BY_NAME, name));
    }

    public void clickMySitesMenu() {
        clickElementByXpath(MY_SITES_MENU);
    }

    public void clickGoButton() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickElementByXpath(MESSAGE_GO_BUTTON);
    }

    public void clickCancelButton() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickElementByXpath(MESSAGE_CANCEL_BUTTON);
    }

    public void clickBackButton() {
        clickElementByXpath(BACK_BUTTON);
    }

    public String getDataLostMessageText() {
        return getElementText(DATA_LOST_TEXT1).concat(getElementText(DATA_LOST_TEXT2));
    }

    public String getDataLostMessageStyle() {
        return getElementStyle(DATA_LOST_MESSAGE);
    }

    public String getCancelButtonText() {
        return getElementText(MESSAGE_CANCEL_BUTTON);
    }

    public String getGoButtonText() {
        return getElementText(MESSAGE_GO_BUTTON);
    }
}
