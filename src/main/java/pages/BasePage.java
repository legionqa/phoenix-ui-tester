package pages;

import app.SharedDriver;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
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
    public static final String NAVIGATION_BAR_SECTION = "//ol//a[text()]";
    public static final String NAVIGATION_BAR_LAST_SECTION = "(//ol//a[text()])[last()]";
    public static final String NAVIGATION_BAR_LINK = "//ol//a[text()='%s']";



    public boolean isElementDisplayed(String xpath) {
        List<WebElement> webElementList = driver.findElements(By.xpath(xpath));
//        if (webElementList.size() == 0) {
//            logger.error(String.format("Element with xpath %s not found", xpath));
//        }
        return webElementList.size() > 0;
    }

    public void clickElementByXpath(String xpath) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            logger.error(String.format("Element with xpath %s not found", xpath));
        }
        driver.findElement(By.xpath(xpath)).click();
    }

    public List<WebElement> getElementsListByXpath(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return driver.findElements(By.xpath(xpath));
    }

    public String getElementText(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public String getElementInnerText(String xpath) {
        return driver.findElement(By.xpath(xpath)).getAttribute("innerText");
    }

    public String getElementTextContent(String xpath) {
        return driver.findElement(By.xpath(xpath)).getAttribute("textContent");
    }

    public String getElementValue(String xpath) {
        return driver.findElement(By.xpath(xpath)).getAttribute("value");
    }

    public String getElementPlaceHolder(String xpath) {
        return driver.findElement(By.xpath(xpath)).getAttribute("placeholder");
    }

    public String getElementTitle(String xpath) {
        return driver.findElement(By.xpath(xpath)).getAttribute("title");
    }

    public void sendKeyToField(String xpath, String key) {
        driver.findElement(By.xpath(xpath)).sendKeys(key);
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    public String waitAndGetCurrentPageUrl(String page) {
        wait.until(ExpectedConditions.urlContains(page));
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

    public void loginToDashboard() {
        driver.get(LoginPage.LOGIN_PAGE_URL);
        clickElementByXpath(LoginPage.CHANGE_LANGUAGE_BUTTON);
        clickElementByXpath(String.format(LoginPage.LANGUAGE_OPTION, "English"));
        sendKeyToField(LoginPage.EMAIL_FIELD, LoginPage.VALID_EMAIL);
        sendKeyToField(LoginPage.PASSWORD_FIELD, LoginPage.VALID_PASSWORD);
        clickElementByXpath(LoginPage.LOGIN_BUTTON);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SIDE_MENU)));
    }

    public String getNavigationBarText(String lastSection) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(NAVIGATION_BAR_LINK, lastSection))));
        List<WebElement> elements;
        elements = getElementsListByXpath(NAVIGATION_BAR_SECTION);
        String barText = "";
        for (WebElement element:elements) {
            barText += (element.getText());
        }
        return barText;
    }

    public String getNavigationBarPageName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAVIGATION_BAR_LAST_SECTION)));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getElementText(NAVIGATION_BAR_LAST_SECTION);
    }
}
