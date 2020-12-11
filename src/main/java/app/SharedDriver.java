package app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class SharedDriver {

    private static WebDriver driver;

    public static void startWebDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("headless");
//            options.addArguments("window-size=1800x900");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
    }
}
