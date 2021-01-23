import app.SharedDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import pages.login.LoginPage;
import properties.PropertiesFile;

@CucumberOptions(
        features = {"src/test/resources/login/PhoenixUILoginPageTest.feature",
                "src/test/resources/login/PhoenixUIForgotPassPageTest.feature",
                "src/test/resources/login/PhoenixUIRegistrationPageTest.feature"},

//        features = {"src/test/resources/login/PhoenixUILoginPageTest.feature"},
//        features = {"src/test/resources/login/PhoenixUIForgotPassPageTest.feature"},
//       features = {"src/test/resources/login/PhoenixUIRegistrationPageTest.feature"},
        plugin = {"pretty", "html:target/cucumber-reports/"},
        glue = {"steps"}
)

@RunWith(Cucumber.class)
public class TestRunnerLoginPackage {

    @BeforeClass
    public static void setup() {
        SharedDriver.startWebDriver();
        PropertiesFile.readPropertiesFile();
    }

    @AfterClass
    public static void tearDown() {
        SharedDriver.closeDriver();
    }
}