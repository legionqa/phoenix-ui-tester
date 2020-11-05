package pages;

public class LoginPage extends BasePage {
    public final static String LOGO = "//h1[@class='logo-name']";
    public final static String LOGIN_BAR = "//*[@id='ember608']";


    public void navigateToLoginPage(String url) {
        driver.get(url);
    }

    public boolean isMainLogoDisplayed() {
        return isElementDisplayed(LOGO);
    }

    public boolean isLogInBarDisplayed() {
        return isElementDisplayed(LOGIN_BAR);
    }


}