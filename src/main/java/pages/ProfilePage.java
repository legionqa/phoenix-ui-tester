package pages;

public class ProfilePage extends BasePage{
    public final static String NAVIGATION_BAR_EDIT_PROFILE = "//li[text()='%s']";

    public boolean isPageNameNavigationBarVisible(String text) {
        return isElementDisplayed(String.format(NAVIGATION_BAR_EDIT_PROFILE, text));
    }

}
