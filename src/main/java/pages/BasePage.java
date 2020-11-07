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
    protected WebDriverWait wait = new WebDriverWait(driver, 5);

    public boolean isElementDisplayed(String xpath) {

        List<WebElement> webElementList = driver.findElements(By.xpath(xpath));
        return webElementList.size() > 0;

    }

    public void clickElementByXpath(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
    }

    public String getElementValue(String xpath) {
        String value = driver.findElement(By.xpath(xpath)).getAttribute("outerText");
        return value;
    }

    public void sendTheKeyToField(String xpath, String key) {
        driver.findElement(By.xpath(xpath)).sendKeys(key);
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
