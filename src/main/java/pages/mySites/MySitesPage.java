package pages.mySites;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MySitesPage extends BasePage {
    public static final Logger logger = LogManager.getLogger(MySitesPage.class);

    public static String MY_SITES_PAGE_URL;
    public static String CREATE_SITE_PAGE_URL;

    public static final String SITES_HEADER = "//h5";
    public static final String NAVIGATION_BAR_LINK = "//ol//a[text()='%s']";
    //    public static final String NAVIGATION_BAR_SITES = "//ol//a[text()='Sites']";
//    public static final String NAVIGATION_BAR_SECTION = "//ol//a[text()]";
    public static final String PAGE_NAME = "Sites";
    public static final String SIDE_OPTION_NAME = "My sites";
    public static final String COUNTER_DIVIDER = ": ";
    public static final String NAVIGATION_BAR_TEXT = "DASHBOARDLEGION QASITES";
    public static final String ALL_SITES = "//div[@class='m-t-md']/strong";
    public static final String TABLE_LINE = "//tr";
    public static final String SIDE_MENU_SELECTED = "//ul//a[@class='ember-view active']";
    public static final String ADD_SITE_BUTTON = "//div[@class='m-t-md']//a[contains(@class, 'btn')]";
    public static final String CHANGE_LANGUAGE_BUTTON = "//button[contains(text(), 'Change language')]";
    public static final String LANGUAGE_OPTION = "//ul[@class='nav navbar-top-links navbar-right']//a[text()='%s']";
    public static final String UPDATE_BUTTON = "//button[@id='loading-example-btn']";
    public static final String SEARCH_FIELD = "//input";
    public static final String SEARCH_BUTTON = "//div[@class='input-group']//button";

    public static final String TEST_SITE_1_NAME = "Test site SearchKey1";
    public static final String TEST_SITE_1_URL = "/users/5fa1d8ffc903de27cc069de4/sites/5fc6647437cb05dfbd15edb4";
    public static final String TEST_SITE_1_CREATE_WIGET_URL = "/users/5fa1d8ffc903de27cc069de4/sites/5fc6647437cb05dfbd15edb4/widgets/create";
    public static final String TEST_SITE_1_SETTINGS_URL = "/users/5fa1d8ffc903de27cc069de4/sites/5fc6647437cb05dfbd15edb4/edit";
    public static final String TEST_SITE_2_NAME = "Test site searchkey2";

    public static final String INACTIVATE_TIP = "Inactivate";
    public static final String ACTIVATE_TIP = "Activate";

    public static final String ACTIVATE_SWITCH = "//tr[%d]//i[contains(@class, 'fa-toggle')]";
    public static final String ACTIVATE_SWITCH_ON = "//tr[%d]//i[contains(@class, 'fa-toggle-on')]";
    public static final String ACTIVATE_SWITCH_OFF = "//tr[%d]//i[contains(@class, 'fa-toggle-off')]";
    public static final String ACTIVATE_SWITCH_TIP = "//tr[%d]//i[contains(@class, 'fa-toggle')]/ancestor::a";
    public static final String SITE_NAME = "//tr[%d]/td[@class='project-title']/a[@href]";
    public static final String SITE_URL = "//tr[%d]//small[contains(text(), 'http://')]";
    public static final String ADD_WIDGET_BUTTON = "//tr[%d]//a[text()='Add the widget']";
    public static final String ADD_WIDGET_BUTTON_TEXT = "//tr[%d]//a[contains(@href, '/widgets/create')]";
    public static final String SETTINGS_BUTTON = "//tr[%d]//a[@title='Settings']";
    public static final String SETTINGS_BUTTON_TIP = "//tr[%d]//a[contains(@href, '/edit')]";

    public static final String ACTIVATION_MESSAGE = "//div[@class='sa-icon sa-warning']//following::div[@class='sa-icon sa-success animate']";
    public static final String INACTIVATION_MESSAGE = "//div[@class='sa-icon sa-warning pulseWarning']//following::div[@class='sa-icon sa-success animate']";
    public static final String MESSAGE = "//div[@class='sa-icon sa-success animate']";
    public static final String INACTIVATION_WARNING = "//div[@class='sa-icon sa-warning pulseWarning']//following::div[@class='sa-icon sa-success']";
    public static final String MESSAGE_OK_BUTTON = "//div[contains(@class, 'showSweetAlert')]//button[@class='confirm']";
    public static final String WARNING_CANCEL_BUTTON = "//div[contains(@class, 'showSweetAlert')]//button[@class='cancel']";
    public static final String ACTIVATION_MESSAGE_TEXT1 = "//div[contains(@class, 'visible')]/h2";
    public static final String ACTIVATION_MESSAGE_TEXT2 = "//div[contains(@class, 'visible')]/p";

    public static final String TEST_SITE_1_HEADER = "//h5[text()='Test site SearchKey1']";

    public void navigateToMySitesPage() {
//        logger.info("Login page is open, page class");
        driver.get(MY_SITES_PAGE_URL);
    }

    public boolean isSitesHeaderVisible() {
        return isElementDisplayed(SITES_HEADER);
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
        return getElementsListByXpath(TABLE_LINE).size();
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
        boolean isVisible = true;
        for (int i = 1; i <= 4; i++) {
            if (!isElementDisplayed(String.format(ACTIVATE_SWITCH, i))) {
                isVisible = false;
            }
        }
        return isVisible;
    }

    public boolean isSiteNameDisplayed() {
        boolean isVisible = true;
        for (int i = 1; i <= getLinesNumber(); i++) {
            if (!isElementDisplayed(String.format(SITE_NAME, i))) {
                isVisible = false;
            }
        }
        return isVisible;
    }

    public boolean isSiteUrlDisplayed() {
        boolean isVisible = true;
        for (int i = 1; i <= getLinesNumber(); i++) {
            if (!isElementDisplayed(String.format(SITE_URL, i))) {
                isVisible = false;
            }
        }
        return isVisible;
    }

    public boolean isAddWidgetButtonDisplayed() {
        boolean isVisible = true;
        for (int i = 1; i <= getLinesNumber(); i++) {
            if (!isElementDisplayed(String.format(ADD_WIDGET_BUTTON, i))) {
                isVisible = false;
            }
        }
        return isVisible;
    }

    public boolean isSettingsButtonDisplayed() {
        boolean isVisible = true;
        for (int i = 1; i <= getLinesNumber(); i++) {
            if (!isElementDisplayed(String.format(SETTINGS_BUTTON, i))) {
                isVisible = false;
            }
        }
        return isVisible;
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
        clickElementByXpath(String.format(ACTIVATE_SWITCH, getSiteLineNumberByName(TEST_SITE_1_NAME)));
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MESSAGE)));
    }

    public void clickWarningCancelButton() {
        clickElementByXpath(WARNING_CANCEL_BUTTON);
    }

    public boolean activateSwitchIsOn() {
        return isElementDisplayed(String.format(ACTIVATE_SWITCH_ON, getSiteLineNumberByName(TEST_SITE_1_NAME)));
    }

    public boolean activateSwitchIsOff() {
        return isElementDisplayed(String.format(ACTIVATE_SWITCH_OFF, getSiteLineNumberByName(TEST_SITE_1_NAME)));
    }

    public String getActivateSwitchTip() {
        return getElementTitle(String.format(ACTIVATE_SWITCH_TIP, getSiteLineNumberByName(TEST_SITE_1_NAME)));
    }

    public String getAddWidgetButtonText() {
        return getElementText(String.format(ADD_WIDGET_BUTTON_TEXT, getSiteLineNumberByName(TEST_SITE_1_NAME)));
    }

    public String getSettingsButtonTip() {
        return getElementTitle(String.format(SETTINGS_BUTTON_TIP, getSiteLineNumberByName(TEST_SITE_1_NAME)));
    }

    public void clickTest1SiteName() {
        clickElementByXpath(String.format(SITE_NAME, getSiteLineNumberByName(TEST_SITE_1_NAME)));
    }

    public void clickTest1SiteAddWidgetButton() {
        clickElementByXpath(String.format(ADD_WIDGET_BUTTON, getSiteLineNumberByName(TEST_SITE_1_NAME)));
    }

    public void clickTest1SiteSettingsButton() {
        clickElementByXpath(String.format(SETTINGS_BUTTON, getSiteLineNumberByName(TEST_SITE_1_NAME)));
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

}
