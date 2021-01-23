package pages;

import app.SharedDriver;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.login.LoginPage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class BasePage {
    public static final Logger logger = LogManager.getLogger(BasePage.class);

    protected WebDriver driver = SharedDriver.getWebDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 5);

    public static String ROOT_URL;

    public static final String SIDE_MENU = "//ul[@id='side-menu']";
    public static final String NAVIGATION_BAR = "//ol";
    public static final String NAVIGATION_BAR_SECTION = "(//ol/li)[%d]";
    public static final String NAVIGATION_BAR_LINK = "//ol//*[text()='%s']";

    public static final String BLOCK_HEADER = "//h5[text()='%s']";
    public static final String BLOCK_BODY = "//h5[text()='%s']/ancestor::div/following-sibling::div[@class='ibox-content']";
    public static final String COLLAPSE_BUTTON = "//h5[text()='%s']//following-sibling::div//i";
    public static final String COLLAPSED_BLOCK = "display: none;";
    public static final String EXPANDED_BLOCK = "display: block;";
    public static final String CHEVRON_DOWN = "fa fa-chevron-down";
    public static final String CHEVRON_UP = "fa fa-chevron-up";

    public static final String CLOSE_MESSENGER_BUTTON = "//jdiv[contains(@class, 'closeButton')]";


    public boolean isElementDisplayed(String xpath) {
        waitForElementVisibility(xpath);
        List<WebElement> webElementList = driver.findElements(By.xpath(xpath));
        return webElementList.size() > 0;
    }

    public void clickElementByXpath(String xpath) {
        waitForElementVisibility(xpath);
        driver.findElement(By.xpath(xpath)).click();
    }

    public List<WebElement> getElementsListByXpath(String xpath) {
        waitForElementVisibility(xpath);
        return driver.findElements(By.xpath(xpath));
    }

    public String getElementText(String xpath) {
        waitForElementVisibility(xpath);
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public String getElementInnerText(String xpath) {
        waitForElementVisibility(xpath);
        return driver.findElement(By.xpath(xpath)).getAttribute("innerText");
    }

    public String getElementTextContent(String xpath) {
        waitForElementVisibility(xpath);
        return driver.findElement(By.xpath(xpath)).getAttribute("textContent");
    }

    public String getElementValue(String xpath) {
        waitForElementVisibility(xpath);
        return driver.findElement(By.xpath(xpath)).getAttribute("value");
    }

    public String getElementPlaceHolder(String xpath) {
        waitForElementVisibility(xpath);
        return driver.findElement(By.xpath(xpath)).getAttribute("placeholder");
    }

    public String getElementTitle(String xpath) {
        waitForElementVisibility(xpath);
        return driver.findElement(By.xpath(xpath)).getAttribute("title");
    }

    public String getElementClass(String xpath) {
        waitForElementVisibility(xpath);
        return driver.findElement(By.xpath(xpath)).getAttribute("class");
    }

    public String getElementStyle(String xpath) {
        waitForElementVisibility(xpath);
        return driver.findElement(By.xpath(xpath)).getAttribute("style");
    }

    public void sendKeyToField(String xpath, String key) {
        waitForElementVisibility(xpath);
        driver.findElement(By.xpath(xpath)).sendKeys(key);
    }

    public void clearFieldByXpath(String xpath) {
        waitForElementVisibility(xpath);
        driver.findElement(By.xpath(xpath)).clear();
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    public String waitAndGetCurrentPageUrl(String page) {
        try {
            wait.until(ExpectedConditions.urlToBe(page));
        } catch (TimeoutException te) {
            logger.error(te.getMessage());
        }
        return driver.getCurrentUrl();
    }

    public void takeScreenshot(String name) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("Screenshots/" + name + ".jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loginToDashboard(String email, String password) {
        driver.get(LoginPage.LOGIN_PAGE_URL);
        clickElementByXpath(LoginPage.CHANGE_LANGUAGE_BUTTON);
        clickElementByXpath(String.format(LoginPage.LANGUAGE_OPTION, "English"));
        sendKeyToField(LoginPage.EMAIL_FIELD, email);
        sendKeyToField(LoginPage.PASSWORD_FIELD, password);
        clickElementByXpath(LoginPage.LOGIN_BUTTON);
        waitForElementVisibility(SIDE_MENU);
    }

    public String getNavigationBarText(int number) {
        waitForElementVisibility(String.format(NAVIGATION_BAR_SECTION, number));
        return getElementInnerText(NAVIGATION_BAR);
    }

    public void waitForElementVisibility(String xpath) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (TimeoutException te) {
            logger.error(te.getMessage());
        }
    }

    public void waitForElementPresence(String xpath) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        } catch (TimeoutException te) {
            logger.error(te.getMessage());
        }
    }

    public void clickCollapseButton(String blockHeader) {
        clickElementByXpath(String.format(COLLAPSE_BUTTON, blockHeader));
    }

    public boolean isBlockCollapsed(String header) {
        return (isElementDisplayed(String.format(BLOCK_HEADER, header))
                && (getElementStyle(String.format(BLOCK_BODY, header)).equals(COLLAPSED_BLOCK))
                && (getElementClass(String.format(COLLAPSE_BUTTON, header)).equals(CHEVRON_DOWN)));
    }

    public boolean isBlockExpanded(String header) {
        return (isElementDisplayed(String.format(BLOCK_HEADER, header))
                && (getElementStyle(String.format(BLOCK_BODY, header)).equals(EXPANDED_BLOCK))
                && (getElementClass(String.format(COLLAPSE_BUTTON, header)).equals(CHEVRON_UP)));
    }

    public String getSelectedOption(String xpath) {
        Select select = new Select(driver.findElement(By.xpath(xpath)));
        return select.getFirstSelectedOption().getText();
    }

    public void closeMessenger() {
        clickElementByXpath(CLOSE_MESSENGER_BUTTON);
    }
}
