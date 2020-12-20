import app.SharedDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import properties.PropertiesFile;

@CucumberOptions(
        features = {"src/test/resources/mySites/PhoenixUIMySitesPageTest.feature",
                "src/test/resources/mySites/PhoenixUISitesActivationTests.feature",
                "src/test/resources/mySites/PhoenixUISiteSettingsPageTest.feature",
                "src/test/resources/mySites/PhoenixUISiteSettingsTestDataReset.feature"},

//       features = {"src/test/resources/mySites/PhoenixUIMySitesPageTest.feature"},
//       features = {"src/test/resources/mySites/PhoenixUISitesActivationTests.feature"},
//       features = {"src/test/resources/mySites/PhoenixUISiteSettingsPageTest.feature"},
//       features = {"src/test/resources/mySites/PhoenixUISiteSettingsTestDataReset.feature"},
        plugin = {"pretty", "html:target/cucumber-reports/"},
        glue = {"steps"}
)

@RunWith(Cucumber.class)
public class TestRunnerMySitesPackage {


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