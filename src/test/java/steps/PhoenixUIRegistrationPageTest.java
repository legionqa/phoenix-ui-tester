package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.LoginPage;
import pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.*;

public class PhoenixUIRegistrationPageTest {

    private RegistrationPage registrationPage;


    public PhoenixUIRegistrationPageTest() {
        registrationPage = new RegistrationPage();
    }

    @Given("User navigates to Registration page")
    public void userNavigatesToRegistrationPage() {
        registrationPage.navigateToRegistrationPage();
    }

//  visibility and links

    @When("User clicks Change language button - Registration page")
    public void userClicksChangeLanguageButton() {
        registrationPage.clickChangeLanguageButton();
    }

    @And("User clicks Registration button")
    public void userClicksRegistrationButton() {
        registrationPage.clickRegistrationButton();
    }

    @And("User chooses {string} language - Registration page")
    public void userChoosesLanguageRegistrationPage(String language) {
        registrationPage.chooseLanguage(language);
    }

    @Then("Greeting message {string} is visible - Registration page")
    public void greetingMessageTextIs(String text) {
        assertEquals(text, registrationPage.getGreetingText());
    }

    @And("Name field placeholder is {string}")
    public void nameFieldPlaceholderIs(String text) {
        assertEquals(text, registrationPage.getNameFieldPlaceHolder());
    }

    @And("Currency field placeholder is {string}")
    public void currencyFieldPlaceholderIs(String text) {
        assertEquals(text, registrationPage.getCurrencyPlaceholder());
    }

    @And("Phone field placeholder is {string}")
    public void phoneFieldPlaceholderIs(String text) {
        assertEquals(text, registrationPage.getPhoneFieldPlaceHolder());
    }

    @And("Password field placeholder is {string}")
    public void passwordFieldPlaceholderIs(String text) {
        assertEquals(text, registrationPage.getPassFieldPlaceHolder());
    }

    @And("Password Confirmation field placeholder is {string}")
    public void passwordConfirmationFieldPlaceholderIs(String text) {
        assertEquals(text, registrationPage.getPassConfFieldPlaceHolder());
    }

    @And("Registration button text is {string}")
    public void registrationButtonTextIs(String text) {
        assertEquals(text, registrationPage.getRegistrationButtonText());
    }

    @And("Sign in button text is {string} - Registration page")
    public void signInButtonTextIsRegistrationPage(String text) {
        assertEquals(text, registrationPage.getSigninButtonText());
    }

    @Then("Phoenix logo is visible - Registration page")
    public void phoenixLogoIsVisible() {
        assertTrue(registrationPage.isLogoVisible());
    }

    @And("Registration form is visible")
    public void registrationFormIsVisible() {
        assertTrue(registrationPage.isRegistrationFormDisplayed());
    }

    @And("Email field is visible")
    public void emailFieldIsVisible() {
        assertTrue(registrationPage.isEmailFieldVisible());
    }

    @And("Skype field is visible")
    public void skypeFieldIsVisible() {
        assertTrue(registrationPage.isSkypeFieldVisible());
    }

    @And("Change language button is visible - Registration page")
    public void changeLanguageButtonIsVisible() {
        assertTrue(registrationPage.isChangeLanguageButtonDisplayed());
    }

    @And("Trade Up logo is visible - Registration page")
    public void tradeUpLogoIsVisibleRegistrationPage() {
        assertTrue(registrationPage.isTradeupLogoVisible());
    }

    @And("User select English - Registration page")
    public void userSelectEnglish() {
        registrationPage.chooseLanguage("English");
    }

    @When("User clicks Sign in button - Registration page")
    public void userClicksSigninButton() {
        registrationPage.clickSignInButton();
    }

    @Then("Login page opens - Registration page")
    public void pageOpensRegistrationPage() {
        assertEquals(LoginPage.LOGIN_PAGE_URL, registrationPage.getCurrentPageUrl());
    }

// Negative tests

    @When("User sets E-mail field empty")
    public void userSetsEMailFieldEmpty() {
        registrationPage.sendValueToEmailField(registrationPage.EMPTY_STRING);
    }

    @When("User types {string} in Email field")
    public void userTypesInEmailField(String email) {
        registrationPage.sendValueToEmailField(email);
    }

    @When("User types {string} in Name field")
    public void userTypesInNameField(String name) {
        registrationPage.sendValueToNameField(name);
    }

    @Then("Error message This field can't be blank is visible")
    public void blankEmailMessageIsVisible() {
        assertTrue(registrationPage.isBlankEmailMessageVisible());
    }

    @And("Invalid sign in the E-mail field is visible")
    public void invalidEmailSignIsVisible() {
        assertTrue(registrationPage.isInvalidEmailSignVisible());
    }

    @And("Invalid sign in the Name field is visible")
    public void invalidNameSignIsVisible() {
        assertTrue(registrationPage.isInvalidNameSignVisible());
    }

    @And("Valid sign in the E-mail field is visible")
    public void validSignInTheEMailFieldIsVisible() {
        assertTrue(registrationPage.isValidEmailSignVisible());
    }

    @And("Valid sign in the Name field is visible")
    public void validSignInTheNameFieldIsVisible() {
        assertTrue(registrationPage.isValidNameSignVisible());
    }

    @Then("Error massage This field must be a valid email address is visible")
    public void incorrectEmailMessageIsVisible() {
        assertTrue(registrationPage.isIncorrectEmailMessageVisible());
    }

    @Then("Error massage This field is too short is visible")
    public void incorrectNameMessageIsVisible() {
        assertTrue(registrationPage.isInvalidNameMessageVisible());
    }

    @When("User types qwerty@qwerty.com in the E-mail field")
    public void typeCorrectField() {
        registrationPage.sendValueToEmailField(registrationPage.CORRECT_EMAIL);
    }

    @And("User types qwerty in the Name field")
    public void typeCorrectName() {
        registrationPage.sendValueToNameField(registrationPage.CORRECT_NAME);
    }

    @And("User selects Account currency in the Currency menu")
    public void selectNoCurrency() {
        registrationPage.chooseCurrency(registrationPage.NO_CURRENCY);
    }

    @Then("Currency not selected error massage is visible")
    public void noCurrencyErrorMassageIsVisible() {
        assertTrue(registrationPage.isNoCurrencyErrorMessageVisible());
    }

    @Then("Check your data error massage is visible")
    public void checkDataErrorMassageIsVisible() {
        assertTrue(registrationPage.isCheckDataErrorMessageVisible());
    }

    @Then("Passwords don't match error massage is visible")
    public void passwordsErrorMassageIsVisible() {
        assertTrue(registrationPage.isPasswordsErrorMessageVisible());
    }

    @And("User selects USD in the Currency menu")
    public void userSelectsUSDInTheCurrencyMenu() {
        registrationPage.chooseCurrency(registrationPage.VALID_CURRENCY);
    }

    @And("User sets Password field empty")
    public void userSetsPasswordFieldEmpty() {
        registrationPage.sendValueToPasswordField(registrationPage.EMPTY_STRING);
    }

    @And("User sets Password confirmation field empty")
    public void userSetsPasswordConfirmationFieldEmpty() {
        registrationPage.sendValueToPasswordConfirmationField(registrationPage.EMPTY_STRING);
    }

    @And("User enters {string} into the Password field")
    public void userEntersIntoThePasswordField(String text) {
        registrationPage.sendValueToPasswordField(text);
    }

    @And("User enters {string} into the Password confirmation field")
    public void userEntersIntoThePasswordConfirmationField(String text) {
        registrationPage.sendValueToPasswordConfirmationField(text);
    }

// Language tests

    @Then("Blank field error massage {string} is visible")
    public void blankFieldErrorMassageIsVisible(String text) {
        assertEquals(text, registrationPage.getBlankEmailFieldMessageText());
    }

    @When("User types qwerty in the E-mail field")
    public void userTypesQwertyInTheEMailField() {
        registrationPage.sendValueToEmailField(registrationPage.INCORRECT_EMAIL);
    }

    @Then("Invalid E-mail message {string} is visible")
    public void invalidEMailMessageIsVisible(String text) {
        assertEquals(text, registrationPage.getInvalidEmailFieldMessageText());
    }

    @When("User sets Name field empty")
    public void userSetsNameFieldEmpty() {
        registrationPage.sendValueToNameField(registrationPage.EMPTY_STRING);
    }

    @Then("Short name error message {string} is visible")
    public void shortNameRrorMessageIsVisible(String text) {
        assertEquals(text, registrationPage.getInvalidNameFieldMessageText());
    }

    @And("User selects {string} in the Currency menu")
    public void userSelectsInTheCurrencyMenu(String text) {
        registrationPage.chooseCurrency(text);
    }

    @Then("Currency not selected message {string} is visible")
    public void currencyNotSelectedMessageIsVisible(String text) {
        assertEquals(text, registrationPage.getNoCurrencyMessageText());
    }

    @Then("Check data message {string} is visible")
    public void checkDataMessageText(String text) {
        assertEquals(text, registrationPage.getCheckDataErrorMessageText());
    }

    @And("User enters qwerty into the Password field")
    public void userEntersPassword() {
        registrationPage.sendValueToPasswordField(registrationPage.PASSWORD);
    }

    @Then("Passwords don't match error massage {string} is visible")
    public void passwordsErrorMassageText(String text) {
        assertEquals(text, registrationPage.getPasswordErrorMessageText());
    }

    @And("The page is reloaded")
    public void pageIsReloaded() {
        registrationPage.reloadPage();
    }
}