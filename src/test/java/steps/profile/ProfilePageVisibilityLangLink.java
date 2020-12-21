package steps.profile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.profile.ProfilePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfilePageVisibilityLangLink {
    private ProfilePage profile;

    public ProfilePageVisibilityLangLink() {
        profile = new ProfilePage();
    }


    @Given("User navigates to Profile page")
    public void userNavigatesToProfilePage() {
        profile.navigateToProfilePage();
    }
    @Then("E-mail field is visible")
    public void eMailFieldIsVisible() {
        assertTrue(profile.isEmailFieldDisplayed());
    }
    @And("Skype field is visible - Profile page")
    public void skypeFieldIsVisible() {
        assertTrue(profile.isSkypeFieldDisplayed());
    }
    @And("Currency field is visible")
    public void currencyFieldIsVisible() {
        Assert.assertTrue(profile.isCurrencyFieldDisplayed());
    }
    @Then("Profile in the main menu is highlighted")
    public void profileMainMenuIsHighlighted() {
        assertTrue(profile.profileIsActivesMainMenu());
    }
    @When("Click on Drop-down menu the user panel")
    public void clickOnDropDownMenuFTheUserPanel() {
        profile.openUserPanelMenu();
    }
    @Then("My Profile option is highlighted in the drop-down menu of the user panel")
    public void myProfileIsHighlightedInTheUserPanel() {
        assertTrue(profile.myProfileIsActivesUserPanel());
    }
    @When("User clicks on Change language button")
    public void userClicksOnChangeLanguageButton() {
        profile.clickChangeLanguageButton();
    }
    @And("Editing of the profile block text is {string}")
    public void editingOfTheProfileBlockTextIs(String text) {
        assertEquals(text, profile.getEditingProfileBlockText());
    }
    @And("Name field placeholders text is {string}")
    public void nameFieldPlaceholdersTextIs(String text) {
        assertEquals(text, profile.getNamePlaceHolder());
    }
    @And("Phone field placeholders text is {string}")
    public void phoneFieldPlaceholdersTextIs(String text) {
        assertEquals(text, profile.getPhonePlaceHolder());
    }
    @And("Changing the password block is {string}")
    public void changingThePasswordBlockIs(String text) {
        assertEquals(text, profile.getChangingPasswordBlockBlockText());
    }
    @When("User clicks expand or collapse button of the Changing the password block")
    public void userClicksExpandCollapseButtonOfTheChangingThePasswordBlock() {
        profile.clickCollapsingChangePasswordBlock();
    }
    @Then("Current password placeholder is {string}")
    public void currentPasswordPlaceholderIs(String text) {
        assertEquals(text, profile.getCurrentPasswordPlaceHolder(text));
    }
    @And("New password placeholder is {string}")
    public void newPasswordPlaceholderIs(String text) {
        assertEquals(text, profile.getNewPasswordPlaceHolder(text));
    }
    @And("Password confirmation placeholder is {string}")
    public void passwordConfirmationPlaceholderIs(String text) {
        assertEquals(text, profile.getPasswordConfirmationPlaceHolder(text));
    }
    @And("Save button text is {string} - Profile page")
    public void saveButtonTextIs(String text) {
        assertEquals(text, profile.getSaveButtonText());
    }
    @And("Change button text is {string}")
    public void changeButtonTextIs(String text) {
        assertEquals(text, profile.getChangeButtonText());
    }
    @When("User sends string {string} in the name field")
    public void userSendsStringInTheNameField(String text) {
        profile.sendTextToNameField();
    }
    @Then("Cancel button text is {string}")
    public void cancelButtonTextIs(String text) {
        assertEquals(text, profile.getCancelButtonText());
    }
    @And("User go to Main Page and back to Profile page")
    public void userGoToMainPageAndBackToProfilePage() {
        profile.reloadPage();
    }


}
