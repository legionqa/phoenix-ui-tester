package pages;

public class LoginPage extends BasePage {
    public final static String LOGO = "//h1[@class='logo-name']";
    public final static String LOGIN_BAR = "//*[@id='ember608']";
    public final static String BUTTON = "//*[@id='ember696']";

    public final static String ENGLISH = "//*[@id='ember1024']/li[1]/a";
    public final static String RUSSIAN = "//*[@id='ember1024']/li[2]/a";
    public final static String UKRAINIAN = "//*[@id='ember1024']/li[3]/a";
    public final static String PORTUGUESA = "//*[@id='ember1024']/li[4]/a";


//    public final static String XPATH_ENG_GREETING = "//*[contains(text(),'Welcome to')]";
//    public final static String RUS_GREETING = "//*[@id='ember1024']/li[4]/a";
//    public final static String UKR_GREETING = "//*[@id='ember1024']/li[4]/a";
//    public final static String PORT_GREETING = "//*[@id='ember1024']/li[4]/a";


    public void navigateToLoginPage(String url) {
        driver.get(url);
    }

    public boolean isMainLogoDisplayed() {
        return isElementDisplayed(LOGO);
    }

    public boolean isLogInBarDisplayed() {
        return isElementDisplayed(LOGIN_BAR);
    }

    public void clickButton() {
        clickElementByXpath(BUTTON);
    }

    public void chooseLanguage(String language) {
        clickElementByXpath("//a[text()='" + language + "']");
    }


    public boolean isGreetingTextDisplayed(String greeting) {
        return isElementDisplayed("//*[contains(text(),'" + greeting + "')]");
    }
}