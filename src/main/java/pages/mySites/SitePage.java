package pages.mySites;

import pages.BasePage;

public class SitePage extends BasePage {
    public final static String NAVIGATION_BAR_SITE = "//li[text()='%s']";

    public boolean isPageNameNavigationBarVisible(String text) {
        return isElementDisplayed(String.format(NAVIGATION_BAR_SITE, text));
    }
}
