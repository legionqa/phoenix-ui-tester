package pages.mySites;

import org.openqa.selenium.TimeoutException;
import pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MySitesPage extends BasePage {
    public static final Logger logger = LogManager.getLogger(MySitesPage.class);

    public static String MY_SITES_PAGE_URL;
    public static String CREATE_SITE_PAGE_URL;

    public static final String SITES_HEADER = "//h5";
    public static final String SIDE_OPTION_NAME = "My sites";
    public static final String COUNTER_DIVIDER = ": ";
    public static final String ALL_SITES = "//div[@class='m-t-md']/strong";
    public static final String TABLE_LINE = "//tr";
    public static final String SIDE_MENU_SELECTED = "//ul//a[@class='ember-view active']";
    public static final String ADD_SITE_BUTTON = "//div[@class='m-t-md']//a[contains(@class, 'btn')]";
    public static final String CHANGE_LANGUAGE_BUTTON = "//button[contains(text(), 'Change language')]";
    public static final String LANGUAGE_OPTION = "//ul[@class='nav navbar-top-links navbar-right']//a[text()='%s']";
    public static final String UPDATE_BUTTON = "//button[@id='loading-example-btn']";
    public static final String SEARCH_FIELD = "//input";
    public static final String SEARCH_BUTTON = "//div[@class='input-group']//button";

    public static final String SITE_LINE_NAME = "//tr/td/a[text()='%s']";
    public static final String TEST_SITE_1_NAME = "Test site SearchKey1";
    public static final String TEST_SITE_1_PAGE_URL = "/users/5fa1d8ffc903de27cc069de4/sites/5fc6647437cb05dfbd15edb4";
    public static final String TEST_SITE_1_CREATE_WIDGET_URL = "/users/5fa1d8ffc903de27cc069de4/sites/5fc6647437cb05dfbd15edb4/widgets/create";
    public static final String TEST_SITE_1_SETTINGS_URL = "/users/5fa1d8ffc903de27cc069de4/sites/5fc6647437cb05dfbd15edb4/edit";
    public static final String TEST_SITE_2_NAME = "Test site searchkey2";
    public static final String TEST_SITE_2_URL = "http://test2.test";

    public static final String INACTIVATE_TIP = "Inactivate";
    public static final String ACTIVATE_TIP = "Activate";

    public static final String SEARCH_KEY_1 = "Searchkey";
    public static final String SEARCH_KEY_2 = "qwerty";

    public static final String ACTIVATION_SWITCH = "(//tr)[%d]//i[contains(@class, 'fa-toggle')]";
    public static final String ACTIVATION_SWITCH_ON = "(//tr)[%d]//i[contains(@class, 'fa-toggle-on')]";
    public static final String ACTIVATION_SWITCH_OFF = "(//tr)[%d]//i[contains(@class, 'fa-toggle-off')]";
    public static final String ACTIVATION_SWITCH_TIP = "(//tr)[%d]//i[contains(@class, 'fa-toggle')]/ancestor::a";
    public static final String SITE_NAME = "(//tr)[%d]/td[@class='project-title']/a[@href]";
    public static final String SITE_URL = "(//tr)[%d]//small[contains(text(), 'http://')]";
    public static final String ADD_WIDGET_BUTTON = "(//tr)[%d]//a[contains(@href, '/widgets/create')]";
    public static final String SETTINGS_BUTTON = "(//tr)[%d]//a[contains(@href, '/edit')]";

    public static final String ACTIVATION_MESSAGE = "//div[@class='sa-icon sa-warning']//following::div[@class='sa-icon sa-success animate']";
    public static final String INACTIVATION_MESSAGE = "//div[@class='sa-icon sa-warning pulseWarning']//following::div[@class='sa-icon sa-success animate']";
    public static final String MESSAGE = "//div[@class='sa-icon sa-success animate']";
    public static final String INACTIVATION_WARNING = "//div[@class='sa-icon sa-warning pulseWarning']//following::div[@class='sa-icon sa-success']";
    public static final String MESSAGE_OK_BUTTON = "//div[contains(@class, 'showSweetAlert')]//button[@class='confirm']";
    public static final String WARNING_CANCEL_BUTTON = "//div[contains(@class, 'showSweetAlert')]//button[@class='cancel']";
    public static final String ACTIVATION_MESSAGE_TEXT1 = "//div[contains(@class, 'visible')]/h2";
    public static final String ACTIVATION_MESSAGE_TEXT2 = "//div[contains(@class, 'visible')]/p";
    public static final String SAVED_MESSAGE = "//div[@class='toast-message']";

    public void navigateToMySitesPage() {
        driver.get(MY_SITES_PAGE_URL);
    }

    public void clickNavigationLink(String link) {
        clickElementByXpath(String.format(NAVIGATION_BAR_LINK, link));
    }

    public int getAllSitesNumber() {
        String counter = getElementText(ALL_SITES);
        counter = counter.substring(counter.indexOf(COUNTER_DIVIDER) + 2);
        return Integer.parseInt(counter);
    }

    public String getAllSitesText() {
        String counter = getElementText(ALL_SITES);
        counter = counter.substring(0, counter.indexOf(COUNTER_DIVIDER));
        return counter;
    }

    public int getLinesNumber() {
        try {
            return getElementsListByXpath(TABLE_LINE).size();
        } catch (Exception e) {
            return 0;
        }
    }

    public String getSideMenuOption() {
        return getElementText(SIDE_MENU_SELECTED);
    }

    public void clickAddSiteButton() {
        clickElementByXpath(ADD_SITE_BUTTON);
    }

    public String getAddSiteButtonText() {
        return getElementText(ADD_SITE_BUTTON);
    }

    public void clickChangeLanguageButton() {
        clickElementByXpath(CHANGE_LANGUAGE_BUTTON);
    }

    public void clickLanguageOption(String language) {
        clickElementByXpath(String.format(LANGUAGE_OPTION, language));
    }

    public String getSitesBlockHeader() {
        return getElementText(SITES_HEADER);
    }

    public String getUpdateButtonText() {
        return getElementText(UPDATE_BUTTON);
    }

    public String getSearchFieldPlaceholder() {
        return getElementPlaceHolder(SEARCH_FIELD);
    }

    public String getSearchButtonText() {
        return getElementText(SEARCH_BUTTON);
    }

    public boolean isActivateSwitchDisplayed() {
        for (int i = 1; i <= getLinesNumber(); i++) {
            if (!isElementDisplayed(String.format(ACTIVATION_SWITCH, i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isSiteNameDisplayed() {
        for (int i = 1; i <= getLinesNumber(); i++) {
            if (!isElementDisplayed(String.format(SITE_NAME, i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isSiteUrlDisplayed() {
        for (int i = 1; i <= getLinesNumber(); i++) {
            if (!isElementDisplayed(String.format(SITE_URL, i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isAddWidgetButtonDisplayed() {
        for (int i = 1; i <= getLinesNumber(); i++) {
            if (!isElementDisplayed(String.format(ADD_WIDGET_BUTTON, i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isSettingsButtonDisplayed() {
        for (int i = 1; i <= getLinesNumber(); i++) {
            if (!isElementDisplayed(String.format(SETTINGS_BUTTON, i))) {
                return false;
            }
        }
        return true;
    }

    public int getSiteLineNumberByName(String name) {
        for (int i = 1; i <= getLinesNumber(); i++) {
            if (getElementText(String.format(SITE_NAME, i)).equals(name)) {
                return i;
            }
        }
        return 0;
    }

    public void clickActivateSwitch() {
        clickElementByXpath(String.format(ACTIVATION_SWITCH, getSiteLineNumberByName(TEST_SITE_1_NAME)));
    }

    public boolean isActivationMessageDisplayed() {
        return isElementDisplayed(ACTIVATION_MESSAGE);
    }

    public boolean isInactivationMessageDisplayed() {
        return isElementDisplayed(INACTIVATION_MESSAGE);
    }

    public boolean isInactivationWarningDisplayed() {
        return isElementDisplayed(INACTIVATION_WARNING);
    }

    public void clickMessageOkButton() {
        clickElementByXpath(MESSAGE_OK_BUTTON);
    }

    public void waitForMessage() {
        waitForElementVisibility(MESSAGE);
    }

    public void clickWarningCancelButton() {
        clickElementByXpath(WARNING_CANCEL_BUTTON);
    }

    public boolean isActivationSwitchOn(String name) {
        return isElementDisplayed(String.format(ACTIVATION_SWITCH_ON, getSiteLineNumberByName(name)));
    }

    public boolean isActivationSwitchOff(String name) {
        return isElementDisplayed(String.format(ACTIVATION_SWITCH_OFF, getSiteLineNumberByName(name)));
    }

    public String getActivationSwitchTip(String name) {
        return getElementTitle(String.format(ACTIVATION_SWITCH_TIP, getSiteLineNumberByName(name)));
    }

    public String getAddWidgetButtonText() {
        return getElementText(String.format(ADD_WIDGET_BUTTON, getSiteLineNumberByName(TEST_SITE_1_NAME)));
    }

    public String getSettingsButtonTip() {
        return getElementTitle(String.format(SETTINGS_BUTTON, getSiteLineNumberByName(TEST_SITE_1_NAME)));
    }

    public void clickTest1SiteName() {
        clickElementByXpath(String.format(SITE_NAME, getSiteLineNumberByName(TEST_SITE_1_NAME)));
    }

    public void clickTest1SiteAddWidgetButton() {
        clickElementByXpath(String.format(ADD_WIDGET_BUTTON, getSiteLineNumberByName(TEST_SITE_1_NAME)));
    }

    public void clickSiteSettingsButton(String name) {
        clickElementByXpath(String.format(SETTINGS_BUTTON, getSiteLineNumberByName(name)));
    }

    public String getActivationMessageText() {
        return getElementText(ACTIVATION_MESSAGE_TEXT1).concat(getElementText(ACTIVATION_MESSAGE_TEXT2));
    }

    public String getActivationMessageOkButtonText() {
        return getElementText(MESSAGE_OK_BUTTON);
    }

    public String getActivationMessageCancelButtonText() {
        return getElementText(WARNING_CANCEL_BUTTON);
    }

    public boolean areSitesFound() {
        return (isElementDisplayed(String.format(SITE_LINE_NAME, TEST_SITE_1_NAME)) && isElementDisplayed(String.format(SITE_LINE_NAME, TEST_SITE_2_NAME)));
    }

    public void clickUpdateButton() {
        clickElementByXpath(UPDATE_BUTTON);
    }

    public String getSiteUrlBySiteName(String name) {
        return getElementText(String.format(SITE_URL, getSiteLineNumberByName(name)));
    }

    public String getSavedMessageText() {
        return getElementText(SAVED_MESSAGE);
    }
}
