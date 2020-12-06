package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ForgotPassPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class PhoenixUIForgotPassPageTest {

    private ForgotPassPage forgotPassPage;

    public PhoenixUIForgotPassPageTest() {
        forgotPassPage = new ForgotPassPage();
    }

    @Given("User navigates to Forgot password page")
    public void userNavigatesToPage() {
        forgotPassPage.navigateToForgotPassPage();
    }

    @Then("Apply button text is {string}")
    public void applyButtonTextIs(String text) {
        assertEquals(text, forgotPassPage.getApplyButtonText());
    }

    @And("Notification message is {string}")
    public void notificationMessageIs(String text) {
        assertEquals(text, forgotPassPage.getNotificationText());
    }

    @And("Sign in button text is {string}")
    public void signInButtonTextIs(String text) {
        assertEquals(text, forgotPassPage.getSigninButtonText());
    }

    @And("Phoenix logo is visible - Forgot password page")
    public void phoenixLogoIsVisible() {
        assertTrue(forgotPassPage.isPhoenixLogoVisible());
    }

    @And("Email form is visible")
    public void emailFormIsVisible() {
        assertTrue(forgotPassPage.isEmailFormVisible());
    }

    @And("Trade Up logo is visible - Forgot password page")
    public void tradeupLogoIsVisible() {
        assertTrue(forgotPassPage.isTradeupLogoVisible());
    }

    @When("User clicks Sign in link")
    public void userClicksSignInLink() {
        forgotPassPage.clickSigninButton();
    }

    @Then("Login page opens")
    public void loginPageOpens() {
        assertEquals(LoginPage.LOGIN_PAGE_URL, forgotPassPage.getCurrentPageUrl());
    }

//Positive tests

    @When("User types valid email in the email field")
    public void userTypeValidEmail() {
        forgotPassPage.typeValidEmail();
    }

    @And("User clicks Apply button")
    public void userClicksApplyButton() {
        forgotPassPage.clickApplyButton();
    }

    @Then("Message All the instructions are sent to your Email is visible")
    public void instructionsMessageIsVisible() {
        assertTrue(forgotPassPage.isInstructionMessageDisplayed());
    }

    @Then("Instructions message {string} is visible")
    public void instructionsMessageWithTextIsVisible(String text) {
        assertEquals(text, forgotPassPage.getInstructionsMessageText());
    }


//Negative tests

    @When("User types invalid {string} to the email field")
    public void userTypesInvalidToTheEmailField(String email) {
        forgotPassPage.typeValueEmailFieldOfAccount(email);
    }

    @And("User clicks on Apply_button")
    public void userClicksOnApply_button() {
        forgotPassPage.clickApplyButton();
    }

    @Then("Error message is visible")
    public void errorMessageIsVisible() {
        assertTrue(forgotPassPage.isErrorMessageDisplayed());
    }

    @Then("Error message {string} is visible - Forgot password page")
    public void errorMessageWithTextIsVisible(String text) {
        assertEquals(text, forgotPassPage.getErrorMessageText());
    }
}