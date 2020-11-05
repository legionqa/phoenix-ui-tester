import app.SharedDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = {"src/test/resources/PhoenixUILoginPageTest.feature"},
        plugin = {"pretty", "html:target/cucumber-reports/"},
        glue = {"steps"}
)

@RunWith(Cucumber.class)
public class TestRunner {


    @BeforeClass
    public static void setup() {
        SharedDriver.startWebDriver();

    }

    @AfterClass
    public static void tearDown() {
        SharedDriver.closeDriver();
    }
}