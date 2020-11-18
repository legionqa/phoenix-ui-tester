package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.*;

public class PhoenixUIRegistrationPageTest {

    private RegistrationPage registrationPage;


    public PhoenixUIRegistrationPageTest() {
        registrationPage = new RegistrationPage();

    }

    @Given("User open {string} page")
    public void userOnenPage(String url) {
        registrationPage.navigateToRegistrationPage(url);

    }

    @Then("Verify that registration form is displayed")
    public void verifyThatRegistrationFormIsDisplayed() {
        assertTrue(registrationPage.isRegisterFormDisplayed());
    }
//Positive tests

    @When("User types valid {string} in Email field")
    public void userTypesValidInEmailField(String email) {
        registrationPage.typeValueEmailField(email);

    }

    @And("User clicks Registration button")
    public void userClicksRegistrationButton() {
        registrationPage.clickButtonRegister();
    }


    @Then("The Error message is not visible")
    public void theErrormessageThisFieldMustBeAValidEmailAddressIsNotVisible() {
        assertFalse(registrationPage.isEmailErrorMessaeVisible());
    }


    @When("User types {string} more than four chars in Name field")
    public void userTypesMoreThanCharsInNameField(String name) {
        registrationPage.typeValueNameField(name);
    }

    @And("User clicks Register button")
    public void userClicksRegisterButton() {
        registrationPage.clickButtonRegister();
    }

    @Then("Error message: This field is too short is not visible")
    public void errorMessageThisFieldIsTooShortMinimumIsCharactersIsNotVisible() {
        assertFalse(registrationPage.isNameErrorMessaeVisible());

    }

    @When("User types {string} in Enter your phone number  field")
    public void userTypesInEnterYourPhoneNumberField(String phone) {
        registrationPage.typeValuePhoneField(phone);
    }

    @And("User clicks button of Registration")
    public void userClicksButtonRegistration() {
        registrationPage.clickButtonRegister();
    }


    @Then("User verifies the {string}value is visible in Enter your phone number field")
    public void userVerifiesTheValueIsVisibleInEnterYourPhoneNumberField(String phone) {
        assertEquals(registrationPage.getPhoneFieldValue(), phone);
    }


    @When("User types {string} in Skype field")
    public void userTypesInSkypeField(String skype) {
        registrationPage.typeValueSkypeField(skype);
    }

    @And("User clicks button registration")
    public void userClicksButonRegistration() {
        registrationPage.clickButtonRegister();
    }

    @Then("User verifies the {string} value is visible in Skype field")
    public void userVerifiesTheValueIsVisibleInSkypeField(String skype) {
        assertEquals(registrationPage.getSkypeFieldValue(), skype);

    }


    @When("User types {string} in Password field")
    public void userTypesInPasswordField(String pass) {
        registrationPage.typeValuePasswordField(pass);
    }

    @And("User types {string} in Password confirmation field")
    public void userTypesInPasswordConfirmationField(String passConf) {
        registrationPage.typeValuePasswordConfField(passConf);
    }

    @And("User types valid email {string} in Email field")
    public void userTypesValidEmailInEmailField(String email) {
        registrationPage.typeValueEmailField(email);
    }

    @And("User types valid name {string} in Name field")
    public void userTypesValidNameInNameField(String name) {
        registrationPage.typeValueNameField(name);
    }

    @And("User clicks Registration Button")
    public void userClicksRegistratButton() {
        registrationPage.clickButtonRegister();
    }

    @Then("Button Sign in is not visible")
    public void registrationMenuIsNotVisible() {
        assertTrue(registrationPage.isButtonSignInVisible());

    }

    @When("User clicks on button Sign In")
    public void userClicksOnButtonSignIn() {
        registrationPage.clickSignInButton();

    }

    @Then("Button Sign in is not displayed")
    public void registrationFormIsNotDisplayed() {
        assertFalse(registrationPage.isButtonSignInVisible());


    }

    @When("User clicks on drop down currency list")
    public void userClicksOnDropDownCurrencyList() {
        registrationPage.clickCurrencyField();
    }

    @And("User chooses {string}")
    public void userChooses(String currency) {
        registrationPage.chooseCurrency(currency);

    }

    @Then("Currency field shows chosen currency {string}")
    public void currencyFieldShowsChosenCurrency(String currency) {

        assertEquals(registrationPage.getCurrencyFieldValue(), currency);
    }


    //Negative tests

    @When("User types {string} in Email field")
    public void userTypesInEmailField(String email) {
        registrationPage.typeValueEmailField(email);
    }

    @And("Use clicks Registration button")
    public void useClicksRegistrationButton() {
        registrationPage.clickButtonRegister();
    }

    @Then("Error message: This field must be a valid email address is visible")
    public void errormessageThisFieldMustBeAValidEmailAddressIsVisible() {
        assertTrue(registrationPage.isEmailErrorMessaeVisible());

    }

    @When("User types {string} in Name field")
    public void userTypesInNameField(String name) {
        registrationPage.typeValueNameField(name);
    }

    @And("Use clicks Registration buton")
    public void useClicksRegistrationButon() {
        registrationPage.clickButtonRegister();
    }

    @Then("Error message This field is too short is visible")
    public void errormessageThisFieldIsTooShortMinimumIsFourCharactersIsVisible() {
        assertTrue(registrationPage.isNameErrorMessaeVisible());
    }


    @When("User types {string} in Password_field")
    public void userTypesInPassword_field(String pass) {
        registrationPage.typeValuePasswordField(pass);
    }

    @And("User types {string} in Password_confirmation field")
    public void userTypesInPassword_confirmationField(String passConf) {
        registrationPage.typeValuePasswordConfField(passConf);
    }

    @And("User types valid email {string} in Email_field")
    public void userTypesValidEmailInEmail_field(String email) {
        registrationPage.typeValueEmailField(email);
    }

    @And("User types valid name {string} in Name_field")
    public void userTypesValidNameInName_field(String name) {
        registrationPage.typeValueNameField(name);
    }

    @And("User clicks Registration_Button")
    public void userClicksRegistration_Button() {
        registrationPage.clickButtonRegister();
    }

    @Then("Error message: Пароли не совпадают is visible")
    public void errorMessageIsVisible() {
        assertTrue(registrationPage.isPasswordErrorMessageVisible());
    }


    @When("User clicks on Change language button")
    public void userClicksOnChangeLanguageButton() {
        registrationPage.clickChangeLanguageButton();
    }

    @And("User clicks on {string}")
    public void userClicksOn(String language) {
        registrationPage.chooseLanguage(language);
    }

    @Then("In Email field is displayed {string}")
    public void inEmailFieldIsDisplayed(String email) {
        assertEquals(registrationPage.getEmailFieldPlaceHolder(), email);
    }

    @And("In Name field is displayed {string}")
    public void inNameFieldIsDisplayed(String name) {
        assertEquals(registrationPage.getNameFieldPlaceHolder(), name);
    }

    @And("In Phone field is displayed {string}")
    public void inPhoneFieldIsDisplayed(String phone) {
        assertEquals(registrationPage.getPhoneFieldPlaceHolder(), phone);
    }

    @And("In Password field is displayed {string}")
    public void inPasswordFieldIsDisplayed(String pass) {
        assertEquals(registrationPage.getPassFieldPlaceHolder(), pass);
    }

    @And("In Password Confirmation field is displayed {string}")
    public void inPasswordConfirmationFieldIsDisplayed(String passConf) {
        assertEquals(registrationPage.getPassConfFieldPlaceHolder(), passConf);
    }

    @And("Registration button changed to {string}")
    public void registrationButtonChangedTo(String button) {
        assertEquals(registrationPage.getButtonRegisterInnerText(), button);
    }

    @And("In Skype field is displayed {string}")
    public void inSkypeFieldIsDisplayed(String skype) {
        assertEquals(registrationPage.getSkypeFieldPlaceHolder(), skype);
    }
}
