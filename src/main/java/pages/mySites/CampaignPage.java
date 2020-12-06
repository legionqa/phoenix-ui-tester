package pages.mySites;

import pages.BasePage;

public class CampaignPage extends BasePage {

    public final static String NAVIGATION_BAR_CAMPAIGNS = "//a[text()='%s']";

    public boolean isPageNameNavigationBarVisible(String text) {
        return isElementDisplayed(String.format(NAVIGATION_BAR_CAMPAIGNS, text));
    }
}
