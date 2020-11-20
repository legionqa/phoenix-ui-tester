package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ForgotPassPage;
import static org.junit.jupiter.api.Assertions.*;

public class PhoenixUIForgotPassPageTest {

    private ForgotPassPage forgotPassPage;


    public PhoenixUIForgotPassPageTest() {
        forgotPassPage = new ForgotPassPage();

    }
//Positive tests
    @Given("User opens {string} page")
    public void userOpensPage(String url) {
        forgotPassPage.navigateToForgotPassPage(url);

    }

    @When("User types valid {string} to the email field")
    public void userTypeValdEmail(String email) {
        forgotPassPage.typeValuePasswordConfField(email);

    }

    @And("User clicks on Apply button")
    public void userClicksOnApplyButton() {
        forgotPassPage.clickButtonApply();

    }

    @Then("Message All the instructions are sent to your Email is visible")
    public void messageAllTheInstructionsIsVisible() {
        assertTrue(forgotPassPage.isNotificationDisplayed());
    }


//Negative tests

    @When("User types invalid {string} to the email field")
    public void userTypesInvalidToTheEmailField(String email) {
        forgotPassPage.typeValueEmailFieldOfAccount(email);
    }

    @And("User clicks on Apply_button")
    public void userClicksOnApply_button() {
        forgotPassPage.clickButtonApply();
    }

    @Then("Error message is visible")
    public void errorMessageIsVisible() {
       assertTrue(forgotPassPage.isErrorMessageDisplayed());
    }
}