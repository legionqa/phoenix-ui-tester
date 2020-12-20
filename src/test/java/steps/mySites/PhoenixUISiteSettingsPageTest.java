package steps.mySites;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.mySites.SiteSettingsPage;

import java.security.Key;

import static org.junit.jupiter.api.Assertions.*;


public class PhoenixUISiteSettingsPageTest {
    private SiteSettingsPage siteSettingsPage;

    public PhoenixUISiteSettingsPageTest() {
        siteSettingsPage = new SiteSettingsPage();
    }

    @Then("URL field is visible")
    public void urlFieldIsVisible() {
        assertTrue(siteSettingsPage.isUrlFieldVisible());
    }

    @And("utm_source field is visible")
    public void utm_sourceFieldIsVisible() {
        assertTrue(siteSettingsPage.isUtmSourceFieldVisible());
    }

    @And("User clicks expand-collapse button of the Settings block")
    public void userClicksExpandButtonSettingsBlock() {
        siteSettingsPage.clickCollapseButton(siteSettingsPage.SETTINGS_HEADER);
    }

    @Then("Settings block collapses")
    public void settingsBlockCollapses() {
        siteSettingsPage.waitForElementPresence(siteSettingsPage.BLOCK_WAITING);
        assertTrue(siteSettingsPage.isBlockCollapsed(siteSettingsPage.SETTINGS_HEADER));
    }

    @Then("Settings block expands")
    public void settingsBlockExpands() {
        siteSettingsPage.waitForElementPresence(siteSettingsPage.BLOCK_WAITING);
        assertTrue(siteSettingsPage.isBlockExpanded(siteSettingsPage.SETTINGS_HEADER));
    }

    @When("User clicks expand-collapse button of the Main settings block")
    public void userClicksExpandButtonMainSettingsBlock() {
        siteSettingsPage.clickCollapseButton(siteSettingsPage.MAIN_SETTINGS_HEADER);
    }

    @Then("Main settings block collapses")
    public void mainSettingsBlockCollapses() {
        siteSettingsPage.waitForElementPresence(siteSettingsPage.BLOCK_WAITING);
        assertTrue(siteSettingsPage.isBlockCollapsed(siteSettingsPage.MAIN_SETTINGS_HEADER));
    }

    @Then("Main settings block expands")
    public void mainSettingsBlockExpands() {
        siteSettingsPage.waitForElementPresence(siteSettingsPage.BLOCK_WAITING);
        assertTrue(siteSettingsPage.isBlockExpanded(siteSettingsPage.MAIN_SETTINGS_HEADER));
    }

    @Then("Settings block header is {string}")
    public void settingsBlockHeaderIs(String header) {
        assertEquals(header, siteSettingsPage.getSettingsHeaderText());
    }

    @And("Main settings block header is {string}")
    public void mainSettingsBlockHeaderIs(String header) {
        assertEquals(header, siteSettingsPage.getMainSettingsHeaderText());
    }

    @And("Site's name field placeholder is {string}")
    public void siteSNameFieldPlaceholderIs(String placeholder) {
        assertEquals(placeholder, siteSettingsPage.getNameFieldPlaceholder());
    }

    @And("Category drop-down list placeholder is {string}")
    public void categoryDropDownListPlaceholderIs(String category) {
        assertEquals(category, siteSettingsPage.getSelectedCategory());
    }

    @And("Country drop-down list placeholder is {string}")
    public void countryDropDownListPlaceholderIs(String country) {
        assertEquals(country, siteSettingsPage.getSelectedCountry());
    }

    @And("Language list is placeholder is {string}")
    public void languageListIsPlaceholderIs(String language) {
        assertEquals(language, siteSettingsPage.getLanguageListPlaceholder());
    }

    @And("Black words list field placeholder is {string}")
    public void blackWordsListFieldPlaceholderIs(String placeholder) {
        assertEquals(placeholder, siteSettingsPage.getWordsBlacklistPlaceholder());
    }

    @And("Black words list tooltip is {string}")
    public void blackWordsListTooltipIs(String tip) {
        assertEquals(tip, siteSettingsPage.getWordsBlacklistTooltip());
    }

    @And("Options of Status drop-down menu are {string} and {string}")
    public void optionsOfStatusDropDownMenuAreAnd(String option1, String option2) {
        assertEquals(option1, siteSettingsPage.getStatusOption(1));
        assertEquals(option2, siteSettingsPage.getStatusOption(2));
    }

    @And("Save button text is {string}")
    public void saveButtonTextIs(String text) {
        assertEquals(text, siteSettingsPage.getSaveButtonText());
    }

    @And("Back button text is {string}")
    public void backButtonTextIs(String text) {
        assertEquals(text, siteSettingsPage.getBackButtonText());
    }

    @And("User clicks Save button")
    public void userClicksSaveButton() {
        siteSettingsPage.clickSaveButton();
    }

    @Then("Category label in the Test site SearchKey1 site line of the Sites table is matching the selected category")
    public void categoryLabelIsMatchingSelectedCategory() {
        siteSettingsPage.testCategoryOptions();
    }

    @Then("Country label in the Test site SearchKey1 site line of the Sites table is matching the selected country")
    public void countryLabelIsMatchingSelectedCountry() {
        siteSettingsPage.testCountryOptions();
    }

    @And("User sets Site's name field blank")
    public void userSetsSiteSNameFieldBlank() {
        siteSettingsPage.clearNameField();
    }

    @Then("Invalid sign in the Site's name field is visible")
    public void invalidSignInTheSiteSNameFieldIsVisible() {
        assertTrue(siteSettingsPage.isInvalidNameSignDisplayed());
    }

    @And("Error message in the Site's name field with text {string} is visible")
    public void siteNameFieldErrorMessageText(String message) {
        assertEquals(message, siteSettingsPage.getNameFieldMessage());
    }

    @And("Error message in the URL field with text {string} is visible")
    public void urlFieldErrorMessageText(String message) {
        assertEquals(message, siteSettingsPage.getUrlFieldMessage());
    }

    @And("User types que in the Site's name field")
    public void userTypesQueInTheSiteSNameField() {
        siteSettingsPage.clearNameField();
        siteSettingsPage.sendName(siteSettingsPage.SHORT_NAME);
    }

    @And("User sets URL field blank")
    public void userSetsURLFieldBlank() {
        siteSettingsPage.clearUrlField();
    }

    @Then("Invalid sign in the URL field is visible")
    public void invalidSignInTheURLFieldIsVisible() {
        assertTrue(siteSettingsPage.isInvalidUrlSignDisplayed());
    }

    @And("User types qwerty in the URL field")
    public void userTypesQwertyInTheURLField() {
        siteSettingsPage.clearUrlField();
        siteSettingsPage.sendUrl(siteSettingsPage.STRING_WITHOUT_DOT);
    }

    @And("User types qwerty.test in the URL field")
    public void userTypesQwertyTestInTheURLField() {
        siteSettingsPage.clearUrlField();
        siteSettingsPage.sendUrl(siteSettingsPage.URL_WITHOUT_HTTP);
    }

    @Then("Error message is displayed")
    public void errorMessageIsDisplayed() {
        assertTrue(siteSettingsPage.isGeneralErrorMessageDisplayed());
    }

    @And("User types Test site searchkey2 URL in the URL field")
    public void userTypesUrlInTheURLField() {
        siteSettingsPage.clearUrlField();
        siteSettingsPage.sendUrl(siteSettingsPage.TEST_SITE_2_URL);
    }

    @When("User types Test site 4 in the Site's name field")
    public void userTypesTestSiteInTheSiteSNameField() {
        siteSettingsPage.clearNameField();
        siteSettingsPage.sendName(siteSettingsPage.TEST_SITE_4_NAME);
    }

    @And("User types Test site 4 URL in the URL field")
    public void userTypesNewUrlInTheURLField() {
        siteSettingsPage.clearUrlField();
        siteSettingsPage.sendUrl(siteSettingsPage.TEST_SITE_4_URL);
    }

    @And("User selects Active in the Status drop-down menu")
    public void userSelectsActiveInTheStatusDropDownMenu() {
        siteSettingsPage.setSiteActive();
    }

    @Then("My Sites page opens")
    public void mySitesPageOpens() {
        assertEquals(siteSettingsPage.MY_SITES_PAGE_URL, siteSettingsPage.waitAndGetCurrentPageUrl(siteSettingsPage.MY_SITES_PAGE_URL));
    }

    @And("There is the Test site 4 line in the Sites table")
    public void thereIsTheTestSite4LineInTheSitesTable() {
        assertTrue(siteSettingsPage.isTestSite4LineVisible());
    }

    @And("URL of Test site 4 is correct")
    public void urlOfTestSiteIsHttpTestTest() {
        assertEquals(siteSettingsPage.TEST_SITE_4_URL, siteSettingsPage.getSiteUrlBySiteName(siteSettingsPage.TEST_SITE_4_NAME));
    }

    @And("Test site 4 status is Active")
    public void testSiteStatusIsActive() {
        assertTrue(siteSettingsPage.isActivationSwitchOn(siteSettingsPage.TEST_SITE_4_NAME));
    }

    @When("User selects News in the Category list")
    public void userSelectsNewsInTheCategoryList() {
        siteSettingsPage.selectCategoryByName(siteSettingsPage.NEWS);
    }

    @And("User selects Ukraine in the Country list")
    public void userSelectsUkraineInTheCountryList() {
        siteSettingsPage.selectCountryByName(siteSettingsPage.UKRAINE);
    }

    @And("User selects Awadhi in the Language list")
    public void userSelectsAwadhiInTheLanguageList() {
        siteSettingsPage.selectLanguageByName(siteSettingsPage.AWADHI);
    }

    @And("User types qwerty in the Black list of words field")
    public void userTypesQwertyInTheBlackListOfWordsField() {
        siteSettingsPage.clearBlackListField();
        siteSettingsPage.sendBlackList(siteSettingsPage.STRING_WITHOUT_DOT);
    }

    @And("User types qwerty in the ?utm_source=phoenix field")
    public void userTypesQwertyInTheUtm_sourcePhoenixField() {
        siteSettingsPage.clearUtmField();
        siteSettingsPage.sendUtmSource(siteSettingsPage.STRING_WITHOUT_DOT);
    }

    @Then("News is selected in the Category list")
    public void newsIsSelectedInTheCategoryList() {
        assertEquals(siteSettingsPage.NEWS, siteSettingsPage.getSelectedCategory().trim());
    }

    @And("Ukraine is selected in the Country list")
    public void ukraineIsSelectedInTheCountryList() {
        assertEquals(siteSettingsPage.UKRAINE, siteSettingsPage.getSelectedCountry().trim());
    }

    @And("Awadhi is selected in the Language list")
    public void awadhiIsSelectedInTheLanguageList() {
        assertEquals(siteSettingsPage.AWADHI, siteSettingsPage.getSelectedLanguage());
    }

    @And("Black list of words field contains qwerty")
    public void blackListOfWordsFieldContainsQwerty() {
        assertEquals(siteSettingsPage.STRING_WITHOUT_DOT, siteSettingsPage.getWordsBlacklistFieldContent());
    }

    @And("?utm_source=phoenix field contains qwerty")
    public void utm_sourcePhoenixFieldContainsQwerty() {
        assertEquals(siteSettingsPage.STRING_WITHOUT_DOT, siteSettingsPage.getUtmFieldContent());
    }

    @And("User clicks My sites in the Main menu")
    public void userClicksMySitesInTheMainMenu() {
        siteSettingsPage.clickMySitesMenu();
    }

    @When("User clicks Go button in the pop-up message")
    public void userClicksGoButtonInThePopUpMessage() {
        siteSettingsPage.clickGoButton();
    }

    @When("User clicks Cancel button in the pop-up message")
    public void userClicksCancelButtonInThePopUpMessage() {
        siteSettingsPage.clickCancelButton();
    }

    @Then("No category selected in the Category list")
    public void noCategorySelectedInTheCategoryList() {
        assertEquals(siteSettingsPage.CATEGORY_PLACEHOLDER, siteSettingsPage.getSelectedCategory());
    }

    @And("User clicks Back button")
    public void userClicksBackButton() {
        siteSettingsPage.clickBackButton();
    }

    @Then("Pop-up message with text {string} and buttons {string} and {string} appears")
    public void popUpMessageWithTextAndButtonsAndAppears(String message, String cancelButton, String goButton) {
        assertEquals(message, siteSettingsPage.getDataLostMessageText());
        assertEquals(cancelButton, siteSettingsPage.getCancelButtonText());
        assertEquals(goButton, siteSettingsPage.getGoButtonText());
    }

    @Then("Data will be lost message is displayed")
    public void dataWillBeLostMessageIsDisplayed() {
        assertTrue(siteSettingsPage.getDataLostMessageStyle().contains(siteSettingsPage.MESSAGE_VISIBLE_STYLE));
    }

    @Then("Data will be lost message is closed")
    public void dataWillBeLostMessageIsClosed() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(siteSettingsPage.getDataLostMessageStyle().contains(siteSettingsPage.MESSAGE_INVISIBLE_STYLE));
    }

    @Then("Site settings page still open")
    public void siteSettingsPageStillOpen() {
        assertTrue(siteSettingsPage.getCurrentPageUrl().contains(siteSettingsPage.SITE_SETTINGS_PAGE_URL));
    }

    @Then("Valid sign in the Site's name field is visible")
    public void validSignInTheSiteSNameFieldIsVisible() {
        assertTrue(siteSettingsPage.isValidNameSignDisplayed());
    }

    @And("Valid sign in the URL field is visible")
    public void validSignInTheURLFieldIsVisible() {
        assertTrue(siteSettingsPage.isValidUrlSignDisplayed());
    }

    @And("No error message is visible")
    public void noErrorMessageIsVisible() {
        assertFalse(siteSettingsPage.isAnyErrorMessageVisible());
    }

    @And("User pres the Enter key")
    public void userPresTheEnterKey() {
        siteSettingsPage.sendName(Keys.ENTER.toString());
    }

    @And("The message with text {string} is displayed")
    public void theMessageWithTextIsDisplayed(String text) {
        assertEquals(text, siteSettingsPage.getSavedMessageText());
    }
}
