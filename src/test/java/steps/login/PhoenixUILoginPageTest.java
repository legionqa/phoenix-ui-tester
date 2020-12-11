package steps.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.login.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class PhoenixUILoginPageTest {

    private LoginPage loginPage;

    public PhoenixUILoginPageTest() {
        loginPage = new LoginPage();
    }

    @Given("User navigates to login page")
    public void userNavigatesToPage() {
//        loginPage.logger.info("Login page opens, test class");
        loginPage.navigateToLoginPage();
    }

// visibility and links

    @Then("Phoenix logo is visible")
    public void phoenixLogoIsVisible() {
//        loginPage.takeScreenshot("MainLogoIsDisplayed");
        assertTrue(loginPage.isMainLogoDisplayed());
    }

    @And("Change language button is visible")
    public void changeLanguageButtonIsVisible() {
//        loginPage.takeScreenshot("LogInBarIsDisplayed");
        assertTrue(loginPage.isChangeLanguageButtonDisplayed());
    }

    @And("Trade Up logo is visible")
    public void tradeUpLogoIsVisible() {
//        loginPage.takeScreenshot("LogInBarIsDisplayed");
        assertTrue(loginPage.isTradeUpLogoDisplayed());
    }

    @And("Login form is visible")
    public void logInFormIsVisible() {
//        loginPage.takeScreenshot("LogInBarIsDisplayed");
        assertTrue(loginPage.isLogInFormDisplayed());
    }

    @When("User clicks {string} link")
    public void userClicksLink(String link) {
        loginPage.clickLink(link);
    }

    @Then("{string} page opens")
    public void pageOpens(String page) {
        assertEquals(loginPage.ROOT_URL.concat(page), loginPage.getCurrentPageUrl());
    }

    @And("User clicks Forgot password link")
    public void userClicksForgotPasswordLink() {
        loginPage.clickForgotPasswordLink();
    }

    // languages

    @When("User clicks Change language button")
    public void userClicksChangeLanguageButton() {
        loginPage.clickChangeLanguageButton();
    }

    @And("User select English")
    public void userSelectEnglish() {
        loginPage.chooseLanguage("English");
    }

    @And("User select {string} language")
    public void userSelectLanguage(String language) {
        loginPage.chooseLanguage(language);
    }

    @Then("Greeting message {string} is visible")
    public void greetingMessageIsVisible(String greeting) {
//        loginPage.takeScreenshot("GreeetingMessage");
        assertTrue(loginPage.isGreetingTextDisplayed(greeting));
    }

    @And("Login button text is {string}")
    public void logInButtonText(String loginText) {
//        loginPage.takeScreenshot("ButtonChangeLanguage");
        assertEquals(loginText, loginPage.getLoginButtonText());
    }

    @And("Create an account button text is {string}")
    public void createAnAccountButtonText(String createAccountText) {
//        loginPage.takeScreenshot("CreateAccount");
        assertEquals(createAccountText, loginPage.getCreateAnAccountButtonText());
    }

    @And("Forgot your password text is {string}")
    public void forgotYorPasswordLink(String forgotPasswordText) {
//        loginPage.takeScreenshot("ForgetPasswordVisible");
        assertEquals(forgotPasswordText, loginPage.getForgotPasswordLinkText());
    }

    // positive test

    @When("User types valid email in the Email field")
    public void sendTextToEmailField() {
        loginPage.sendTextToEmailField(loginPage.VALID_EMAIL);
    }

    @And("User types valid password in the Password field")
    public void sendTextToPasswordField() {
        loginPage.sendTextToPasswordField(loginPage.VALID_PASSWORD);
    }

    @And("User clicks Login button")
    public void userClicksLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("Main page with correct username opens")
    public void mainPageOpens() {
        assertEquals(loginPage.MAIN_PAGE_URL, loginPage.waitAndGetCurrentPageUrl(loginPage.MAIN_PAGE_URL));
        assertEquals(loginPage.USERNAME, loginPage.getUserName());
    }

//Negative test

    @When("User types {string} in the Email field")
    public void userTypesToTheEmailField(String email) {
        loginPage.sendTextToEmailField(email);
    }

    @And("User types {string} in the Password field")
    public void userTypesToThePasswordField(String pass) {
        loginPage.sendTextToPasswordField(pass);
    }

    @Then("Error massage is visible")
    public void errorMassageIsVisible() {
        assertTrue(loginPage.isErrorMessageVisible());
    }

    @Then("Error message {string} is visible")
    public void errorMessageIsVisible(String message) {
        assertTrue(loginPage.isErrorMessageWithTextVisible(message));
    }

    @Given("Click Log Out button")
    public void clickLogOutButton() {
        loginPage.clickLogoutButton();
    }
}
