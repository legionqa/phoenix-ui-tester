package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.OverviewPage;
import pages.ProfilePage;

import static org.junit.jupiter.api.Assertions.*;

public class PhoenixUIOverviewPageTest {
    private OverviewPage overviewPage;
    private pages.myAdvertisement.CreateCampaignsPage createCampaignsPage;
    private pages.mySites.CreateSitePage createSitePage;
    private ProfilePage profilePage;

    public PhoenixUIOverviewPageTest() {
        overviewPage = new OverviewPage();
    }

    @Given("User navigates to overview page")
    public void userNavigatesToOverviewPage() {
        overviewPage.navigateToOverviewPage();
    }

//      Visibility of the elements of Overview page in all languages
    // Positive tests

    @When("User clicks on button Change language")
    public void userClicksOnButtonChangeLanguage() {
        overviewPage.clickChangeLanguageButton();

    }

    @When("User chooses {string} language")
    public void userChoosesLanguage(String language) {
        overviewPage.chooseLanguage(language);
    }

    @Then("Text info massage changed to {string}")
    public void textInfoMassageChangedTo(String text) {
        assertTrue(overviewPage.isTextInfoMassageDisplayed(text));
    }

    @And("Logo Phoenix Team changed to {string}")
    public void logoPhoenixTeamChangedTo(String logo) {
        assertTrue(overviewPage.isLogoDisplayed(logo));

    }

    @And("Element Quick Start changed to {string}")
    public void elementQuickStartChangedTo(String qStart) {
        assertTrue(overviewPage.isQstartDisplayed(qStart));

    }

    @And("Button Create... changed to {string}")
    public void buttonCreateChangedTo(String buton_create) {
        assertTrue(overviewPage.isButtonCreateDisplayed(buton_create));
    }

    @And("Button Edit Profile changed to {string}")
    public void buttonEditProfileChangedTo(String button_edit) {
        assertTrue(overviewPage.isButtonEditProfileDisplayed(button_edit));
    }


    @And("Video Screen is visible")
    public void videoScreenIsVisible() {
        assertTrue(overviewPage.isVideoPlayerDisplayed());

    }

    @And("Log out")
    public void verifyLogOut() {
        overviewPage.logOut();
    }


//Functionality in all languages

// Button Create


    @And("User clicks on {string}")
    public void userClicksOn(String createButton) {
        overviewPage.clickCreateButton(createButton);
    }

    @And("User chooses from drop down list {string}")
    public void userChoosesFromDropDownListButtonSite(String drop_button) {
        createSitePage = overviewPage.clickDropListButtonSite(drop_button);
    }

    @Then("{string} of the Site page is visible")
    public void isElementOfSitePageIsVisible(String pageName) {
        assertTrue(createSitePage.isPageNameNavigationBarVisible(pageName));

    }

    @And("User chooses from drop downlist {string}")
    public void userChoosesFromDropDownlistCampaign(String drop_button) {
        createCampaignsPage = overviewPage.clickDropListButtonCampaign(drop_button);
    }

    @Then("{string} of the Campaign page is visible")
    public void isElementOCampaignPageIsVisible(String pageName) {
        assertTrue(createCampaignsPage.isPageNameNavigationBarVisible(pageName));
    }


    // Button Edit
    @And("User clicks on the {string}")
    public void userClicksOnTheEditButton(String edit_button) {
        profilePage = overviewPage.clickEditProfileButton(edit_button);
    }


    @Then("{string} of the Profile page is visible")
    public void ofTheProfilePageIsVisible(String pageName) {
        assertTrue(profilePage.isPageNameNavigationBarVisible(pageName));
    }


    //Email link in all languages

    @And("User hovers over Phoenix email link")
    public void userHoversOverPhoenixEmailLink() {
        overviewPage.mouseHover();
    }

    @Then("Email link is highlighted")
    public void emailLinkIsHighlighted() {
        assertTrue(overviewPage.isEmailHighlighted());

    }


//     Video player in all languages



    @And("User clicks on video button in {string}")
    public void userClicksOnVideoButton(String fileName) {
        overviewPage.clickVideButton(fileName);
    }

    @Then("User verifys video is working")
    public void userVerifysVideoIsWorking() {
        assertEquals("https://www.youtube.com/embed/f7MklmZv1Tw",overviewPage.getVideoURL());
    }

}
