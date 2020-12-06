package pages;

import app.SharedDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver = SharedDriver.getWebDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 20);

    public boolean isElementDisplayed(String xpath) {
        List<WebElement> webElementList = driver.findElements(By.xpath(xpath));
        return webElementList.size() > 0;
    }

    public void clickElementByXpath(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
    }

//    public List<WebElement> getElementsListByXpath(String xpath) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
//        return driver.findElements(By.xpath(xpath));
//    }

    public String getElementInnerText(String xpath) {
        String innerText = driver.findElement(By.xpath(xpath)).getAttribute("innerText");
        return innerText;
    }
    public String getElementValue(String xpath) {
        String value = driver.findElement(By.xpath(xpath)).getAttribute("value");
        return value;
    }
    public String getElementPlaceHolder(String xpath) {
        String placeholder = driver.findElement(By.xpath(xpath)).getAttribute("placeholder");
        return placeholder;
    }

//    public String getElementTextContent(String xpath) {
//        String textContent = driver.findElement(By.xpath(xpath)).getAttribute("textContent");
//        return textContent;
//    }

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
}