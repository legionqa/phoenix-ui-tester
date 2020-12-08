package pages.myAdvertisement;

import pages.BasePage;

public class CreateCampaignsPage extends BasePage {
    public final static String NAVIGATION_BAR_CAMPAIGNS = "//a[text()='%s']";

    public boolean isPageNameNavigationBarVisible(String text) {
        return isElementDisplayed(String.format(NAVIGATION_BAR_CAMPAIGNS, text));
    }

}
