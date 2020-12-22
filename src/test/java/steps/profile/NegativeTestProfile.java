package steps.profile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.login.LoginPage;
import pages.profile.ProfilePage;
import pages.profile.ProfilePageNegativeTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static pages.profile.ProfilePage.*;
import static pages.profile.ProfilePageNegativeTest.NAME_FIELD;

public class NegativeTestProfile {

        private ProfilePageNegativeTest negative;


    public NegativeTestProfile(){
            negative = new ProfilePageNegativeTest();

        }

        @When("User types short text message in name field")
    public void shortTextMassageInNameField(){
        negative.shortTextNameField();
    }
    @Then("Red cross is visible in the field")
    public void RedCrossIsVisibleInNameField(){
        assertTrue(negative.isRedCrossVisible());
    }
    @And("Error message This field is too short is displayed")
    public void errorMessageTextTooShortDisplayed(){
        assertTrue(negative.isErrorMassageTextTooShort());
    }
    @When("User send incorrect data {string} in the mail field")
    public void sendIncorrectDataInMailFields(String text){
        negative.sendIncorrectDataMailField(text);
    }
    @Then("Error message {string} is displayed")
    public void verifyTextOfErrorMessageInMailField(String text){
        assertEquals(text, negative.getTextErrorInMailField());
    }
    @When("User types new data {string} in the field {string}")
    public void typesTextInTheFields(String text, String field){
        negative.textInField(field, text);
    }
    @And("User click to Main in the left menu")
    public void clickMainMenu(){
        negative.clickMainMenu();
    }
    @Then("Pop-up message Data will be lost is appearing")
    public void popUpMessageDataWillBeLostIsAppearing(){
        assertTrue(negative.IsPopUpMessageAppearing());
    }
    @When("User changing the password block unwrapping")
    public void passwordBlockUnwrapping(){
        negative.clickCollapsingChangePasswordBlock();   }
    @And ("User type invalid password qqq in the field Current password")
    public void userTypeInvalidPasswordInCurrentPassField(){
            negative.sendPasswordInCurrentField("qqq");
    }
    @And ("Type in New Password and Password confirmation fields same text data qwe123")
    public void sendTextInNewPasswordAndPasswordConfirm(){
       negative.sendStringInNewPasswordAndConfirmationFields("qwe123");
    }
    @Then("The error message is displayed")
    public void errorMessageIsDisplayed(){
        assertTrue(negative.isErrorMessageDisplayed());
    }
    @When("User types valid password legion777 in the Password field")
    public void sendValidPasswordInPasswordField(){
        negative.clickCollapsingChangePasswordBlock();
        negative.sendPasswordInCurrentField(LoginPage.VALID_PASSWORD);
    }
    @And("Not equals data in New password and Password confirmation fields")
    public void sendNotEqualsDataInNewConfirmationFields(){
        negative.sendNotEqualsDataInNewConfirmationFields();
    }
    @And ("User  leave all fields blank")
    public void allFieldsChandePassIsBlank(){
        negative.clearFieldByXpath(CURRENT_PASSWORD_FIELD);
        negative.clearFieldByXpath(NEW_PASSWORD_FIELD);
        negative.clearFieldByXpath(CONFIRMATION_PASSWORD_FIELD);
    }
    @And("User send wwe@as in the mail field")
    public void sendTextInMailField(){
        negative.typeNewDataInMailField("wwe@as");
    }
    @Then("Error message bad password {string} is displayed")
    public void textMessageBadPass(String text){
        assertEquals(text, negative.getTextBadPasswordErrorMessage());
    }
    @And("User type invalid password qqq in the {string} field")
    public void sendDataInCurrentPassFieldLang(String field){
        negative.sendDataAnyPasswordField(field, "qqq");
    }
    @And("Sends in {string} New Password data qwe123")
    public void sendDataInNewPassField(String field1){
        negative.sendDataAnyPasswordField(field1, "qwe12");
    }
    @And("Types in {string} Password confirmation fields data qwe123")
    public void sendDataInConfirmField(String field2){
        negative.sendDataAnyPasswordField(field2, "qwe12");
    }
    @And("User types abc in the name field")
    public void sendABCInNameField(){
        negative.clearFieldByXpath(NAME_FIELD);
        negative.sendKeyToField(NAME_FIELD, "abc");
    }
    @Then("Verify that error message is message {string}")
    public void textErrorMassageNameFieldIs(String text){
        assertEquals(text, negative.textErrorMessageFromNameOrMailField());
    }
    @And("User clears mail field")
    public void clearMailField(){
        negative.clearFieldByXpath(MAIL_FIELD);
    }
    @Then("User clicks on Logout button in UserPanel")
        public void clickLogoutInUserPanel(){
            negative.clickLogOutMenu();
        }
    @Then("User navigates to LoginPage")
    public void isLogonPage(){
       assertEquals(LoginPage.LOGIN_PAGE_URL, negative.getCurrentPageUrl());
    }


}
