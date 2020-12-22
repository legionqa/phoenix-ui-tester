package steps.profile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.login.LoginPage;
import pages.profile.ProfilePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pages.profile.ProfilePage.TEST_USER_NEW_PASSWORD;
import static pages.profile.ProfilePage.TEST_USER_PASSWORD;

public class ProfilePositiveTest extends BasePage {
    ProfilePage profile;

    public ProfilePositiveTest(){
        profile = new ProfilePage();
    }

    @Then("Data in the email field is 'legion.qaservices@gmail.com'")
    public void MailPlaceholderText() {
        assertEquals("legion.qaservices@gmail.com", profile.getMailFieldText());
    }
    @And("Data in the name field is 'Legion QA'")
    public void dataNameFieldIsLegionQA(){
        assertEquals("Legion QA", profile.getNameFieldText());
    }
    @And("Data in the phone field is '4578974'")
    public void dataInPhoneField(){
        assertEquals("4578974", profile.getDataFromPhoneField());
    }
    @Then("Cancel button is appeared")
        public void cancelButtonIsAppeared(){
            assertTrue(profile.isCancelButtonDisplayed());
        }

    @Then ("Verify that user name is 'Legion QA' in the User panel")
    public void verifyUserNameInUserPanel(){
        assertEquals("Legion QA", profile.getNameFromUserPanel());
    }
    @And ("Verify that user email  is 'legion.qaservices@gmail.com' in the User Panel")
    public void verifyEmailInUserPanel(){
       assertTrue(profile.getEmailFromUserPanel().contains("legion.qaservices@gmail.com"));
    }
    @When("User types new data {string} in email field")
    public void userTypeDataInMailField(String text){
        profile.typeNewDataInMailField(text);
    }
    @And ("User types new data {string} in name field")
    public void userTypeInNameField(String text){
        profile.typeNewDataInNameField(text);
    }
    @And ("{string} data displayed in the User panel")
    public void newNameDisplayedInUserPanel(String text){
        assertEquals(text, profile.getNameFromUserPanel());
    }
    @Then("User panel contains new {string}")
    public void dataUserPanelContainsNewMail(String text){
        assertTrue(profile.getEmailFromUserPanel().contains(text));
    }
    @When("User send {string} in the Phone number field")
    public void userSendNumberInPhoneField(){
        profile.sendNumberInPhoneField("030003333378910");
    }
    @And("User send {string} in the Skype number field")
    public void userSendNewNameInSkypeField(String name){
        profile.sendNameInSkypeField("Ivan Ivanov");
    }
    @And ("click on button Save")
     public void userClickButtonSave(){
        profile.clickSaveButton();
    }
    @When("Success message is displayed")
    public void successMessageIsDisplayed(){
        assertTrue(profile.successMessageIsVisible());
    }
    @And ("Return all the data to its original: tel '4578974' and Skype 'Legion QA'")
    public void returnDataPhoneAndSkypeToItsOriginal(){
        profile.returnPhoneAndSkypeToOriginal();
    }
    @When ("User send 'was@ist.das' in the mail field")
    public void userSendNewMailInMailField(){
        profile.typeNewDataInMailField("was@ist.das");
    }
    @And("Click cancel button")
    public void clickCancelButton(){
        profile.clickCancel();
    }
    @Then("Verify that 'legion.qaservices@gmail.com' is displayed in mail field")
    public void verifyDisplayedMailAddress(){
        assertEquals("legion.qaservices@gmail.com", profile.getMailFieldText());
    }
    @When ("User type valid data {string} in the mail field")
    public void enteringTextToMailField(String mail){
        profile.typeNewDataInMailField(mail);
    }
    @Then ("Valid sign in the e-mail field are displayed")
    public void validSignInMailFieldIsDisplayed(){
        assertTrue(profile.isValidSignInMailFIELDDisplayed());
    }
    @When("User type valid data {string} in the name field")
    public void enteringTextToNameField(String name){
        profile.typeNewDataInNameField(name);
    }
    @Then("Valid sign in the name field is displayed")
    public void validSignInNameFieldDisplayed(){
        assertTrue(profile.isValidSignInNameFieldDisplayed());
    }
    @And("User login with test email and password legionqa.test@gmail.com : legiongq123")
    public void userLoginWithTestEmail(){
        profile.loginWithTestEmail();
    }
    @And ("User go to new Profile page")
    public void userGoToNewProfilePage(){
        profile.goToProfilePageNewUser();
    }
    @And("User sends current password in the Current password field")
    public void inputCurrentPasswordInCurrentPasswordField(){
        profile.sendPasswordInCurrentField(TEST_USER_PASSWORD);
    }
    @And("qwert123 in New password and Password confirmation fields")
    public void sendStringInNewPasswordAndConfirmationFields(){
        profile.sendStringInNewPasswordAndConfirmationFields(TEST_USER_NEW_PASSWORD);
    }
    @And("Clicks Change button")
    public void clickChangeButton(){
        profile.clickChangeButton();
    }
    @Then("success message is displayed")
    public void changePasswordSuccessMassageDisplayed(){
        assertTrue(profile.changePasswordSuccessMassageDisplayed());
    }
    @And("Return all the data to its original")
    public void returnOldPassword(){
        profile.returnPasswordToOriginal();
    }
    @And("User sends test.test@gm.com in the mail field")
    public void changeMailToNewTestMail(){
        profile.changeMailToNewTestMail();
    }
    @When("User clicks Log out button")
    public void userClicksLogOutButton(){
        profile.clickElementWithJS();
    }
    @And ("User login with new test email and password test.test@gm.com : legiongq123")
    public void loginWithNewTestMailAndOldsPassword(){
        profile.loginWithNewTestMail();
    }
    @Then("Verify that opened page is Main Page")
    public void isMainPage(){
        assertEquals(LoginPage.MAIN_PAGE_URL, profile.getCurrentPageUrl());
    }
    @And("User types legionqa.test@gmail.com in the mail field")
    public void changeMailToMailTestUser(){
        profile.changeMailToTestMail();
    }





}



