package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.ForgotPassPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class PhoenixUILoginPageTest {

    private LoginPage loginPage;
    private ForgotPassPage forgotPassPage;

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

    @And("Verify the Log in menu is visible")
    public void verifyTheLogInBarIsVisible() {
        loginPage.takeScreenshot("LogInBarIsDisplayed");
        assertTrue(loginPage.isLogInBarDisplayed());
    }

    // Testing drop down language list

    @When("User clicks on drop down languages list")
    public void userClicksOnDropDownLanguagesList() {
        loginPage.clickButtonChangeLanguage();
    }

    @And("User chooses {string} language")
    public void userChoosesLanguage(String language) {
        loginPage.chooseLanguage(language);

    }

    @Then("{string} according to chosen language is visible")
    public void accordingToChosenLanguageIsVisible(String greeting) {
        loginPage.takeScreenshot("GreeetingMessage");
        assertTrue(loginPage.isGreetingTextDisplayed(greeting));
    }

    @And("Log in button changed to {string}")
    public void logInButtonChangedTo(String buttonName) {
        loginPage.takeScreenshot("ButtonChangeLanguage");
        assertEquals(loginPage.buttonNameDisplayed(), buttonName);
    }

    @And("Create an account button changed to {string}")
    public void createAnAccountButtonChangedTo(String accountName) {
        loginPage.takeScreenshot("CreateAccount");
        assertEquals(loginPage.accountNameDisplayed(), accountName);
    }

    @And("Forget password message changed to {string}")
    public void forgetPasswordMessageChangedTo(String forgetPass) {
        loginPage.takeScreenshot("ForgetPasswordVisible");
        assertEquals(loginPage.forgetPasswordDisplayed(), forgetPass);
    }
//      Testing Log in menu
//     Positive tests

    @When("User types {string} into the Email field")
    public void userTypesTheIntoTheEmailField(String email) {
        loginPage.typeValueEmailField(email);
    }

    @And("User types {string} into the Password field")
    public void userTypesTheIntoThePasswordField(String pass) {
        loginPage.typeValuePasswordField(pass);
    }

    @And("User clicks button Log in")
    public void userClicksButtonLogIn() {
        forgotPassPage = loginPage.clickForgotPasswordLink();

    }

    @Then("Login form is not visible")
    public void loginFormIsNotVisible() {
        assertTrue(loginPage.isMainLogoDisplayed());
    }


    @When("User  clicks Change language button")
    public void userClicksChangeLanguageButton() {
        loginPage.clickButtonChangeLanguage();
    }

    @And("User select {string} language")
    public void userSelectLanguage(String language) {
        loginPage.chooseLanguage(language);
    }

    @And("User clicks on Forgot password link")
    public void userClicksOnForgotPasswordLink() {
        forgotPassPage = loginPage.clickForgotPasswordLink();
    }

    @Then("Apply button changed to {string} according chosen language")
    public void applyButtonChangedToAccordingChosenLanguage(String button) {
        assertEquals(forgotPassPage.getButtonApplyInnerText(), button);

    }

    @And("Notification is displayed {string} according chosen language")
    public void notificationIsDisplayedAccordingChosenLanguage(String note) {
        assertEquals(forgotPassPage.getNotificationMessageInnerText(), note);
    }


    //Negative test

    @When("User types {string} to the Email field")
    public void userTypesToTheEmailField(String email) {
        loginPage.typeValueEmailField(email);
    }

    @And("User types {string} to the Password field")
    public void userTypesToThePasswordField(String pass) {
        loginPage.typeValuePasswordField(pass);
    }

    @And("User clicks Log in button")
    public void userClicksLogInButton() {
        loginPage.clickButtonLogIn();
    }

    @Then("Error massage Неверный логин и пароль is visible")
    public void errorMassageIsVisible() {
        assertTrue(loginPage.isErrorMessaeVisible());
    }


}
