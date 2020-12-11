import app.SharedDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import pages.login.LoginPage;
import properties.PropertiesFile;

@CucumberOptions(
//        features = {"src/test/resources/mySites/PhoenixUIMySitesPageTest.feature",
//                "src/test/resources/mySites/PhoenixUISitesActivationTests.feature",
//                },

//       features = {"src/test/resources/mySites/PhoenixUIMySitesPageTest.feature"},
       features = {"src/test/resources/mySites/PhoenixUISitesActivationTests.feature"},
        plugin = {"pretty", "html:target/cucumber-reports/"},
        glue = {"steps"}
)

@RunWith(Cucumber.class)
public class TestRunnerMySitesPackage {
    public static LoginPage loginPage;


    @BeforeClass
    public static void setup() {
        SharedDriver.startWebDriver();
        PropertiesFile.readPropertiesFile();
//        loginPage = new LoginPage();
//        loginPage.loginToDashboard();
    }

    @AfterClass
    public static void tearDown() {
        SharedDriver.closeDriver();
    }
}