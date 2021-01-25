import app.SharedDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import pages.profile.ProfilePage;
import properties.PropertiesFile;

@CucumberOptions(
//        features = {"src/test/resources/profile/VisibilityLanguagesAndLinks.feature"},
//        features = {"src/test/resources/profile/PositiveTests.feature"},
//       features = {"src/test/resources/profile/ChangeAndSaveUserData.feature"},
//       features = {"src/test/resources/profile/ErrorMessagesInLanguages.feature"},
        features = {"src/test/resources/profile/ChangeAndSaveUserData.feature",
                "src/test/resources/profile/NegativeTestsFields.feature",
                "src/test/resources/profile/VisibilityLanguagesAndLinks.feature",
                "src/test/resources/profile/PositiveTests.feature",
                "src/test/resources/profile/ErrorMessagesInLanguages.feature"},
        plugin = {"pretty", "html:target/cucumber-reports/"},
        glue = {"steps"}

)

@RunWith(Cucumber.class)
public class TestRunnerProfilePackage {
    public static ProfilePage profilePage;

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
