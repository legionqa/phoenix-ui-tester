package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class PhoenixUILoginPageTest {

    private LoginPage loginPage;

    public PhoenixUILoginPageTest() {
        loginPage = new LoginPage();

    }

    @Given("User navigates to {string} page")
    public void userNavigatesToPage(String url) {
        loginPage.navigateToLoginPage(url);

    }

    @Then("Verify that Phoenix logo is displayed")
    public void verifyThatPhoenixLogoIsDisplayed() {
        loginPage.takeScreenshot("MainLogoIsDisplayed");
        assertTrue(loginPage.isMainLogoDisplayed());

    }

    @And("Verify the Log in bar is visible")
    public void verifyTheLogInBarIsVisible() {
        loginPage.takeScreenshot("LogInBarIsDisplayed");
        assertTrue(loginPage.isLogInBarDisplayed());
    }
}
