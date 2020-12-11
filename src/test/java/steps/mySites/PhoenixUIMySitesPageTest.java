package steps.mySites;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.login.LoginPage;
import pages.mySites.MySitesPage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class PhoenixUIMySitesPageTest {
    private MySitesPage mySitesPage;

    public PhoenixUIMySitesPageTest() {
        mySitesPage = new MySitesPage();
    }

    @Given("User navigates to My sites page")
    public void navigateToThePage() {
        mySitesPage.navigateToMySitesPage();
    }

    @Then("The Navigation bar text is DASHBOARD LEGION QA SITES")
    public void navigationBarText() {
        assertEquals(mySitesPage.NAVIGATION_BAR_TEXT, mySitesPage.getNavigationBarText(mySitesPage.PAGE_NAME));
    }

    @When("User clicks {string} link of the Navigation bar")
    public void navigationBarLink(String link) {
        mySitesPage.clickNavigationLink(link);
    }

    @Then("{string} page opens - My sites")
    public void pageOpensMySites(String page) {
        assertEquals(LoginPage.ROOT_URL.concat(page), mySitesPage.getCurrentPageUrl());
    }

    @Then("The number in All sites counter equals to the number of strings in the Sites table")
    public void allSitesCounter() {
        assertEquals(mySitesPage.getAllSitesNumber(), mySitesPage.getLinesNumber());
    }

    @Then("My sites option in the main menu is highlighted")
    public void mySitesIsHighlighted() {
        assertEquals(mySitesPage.SIDE_OPTION_NAME, mySitesPage.getSideMenuOption());
    }

    @When("User clicks Add the site button")
    public void clickAddTheSiteButton() {
        mySitesPage.clickAddSiteButton();
    }

    @Then("Create the site page opens")
    public void createTheSitePageOpens() {
        assertEquals(mySitesPage.CREATE_SITE_PAGE_URL, mySitesPage.getCurrentPageUrl());
    }

    @When("User clicks Change language button - My sites")
    public void userClicksChangeLanguageButton() {
        mySitesPage.clickChangeLanguageButton();
    }

    @And("User chooses {string} language")
    public void userChoosesLanguage(String language) {
        mySitesPage.clickLanguageOption(language);
    }

    @Then("Sites block header is {string}")
    public void sitesBlockHeaderIs(String header) {
        assertEquals(header, mySitesPage.getSitesBlockHeader());
    }

    @And("Update button text is {string}")
    public void updateButtonTextIs(String text) {
        assertEquals(text, mySitesPage.getUpdateButtonText());
    }

    @And("Search field placeholder is {string}")
    public void searchFieldPlaceholderIs(String placeholder) {
        assertEquals(placeholder, mySitesPage.getSearchFieldPlaceholder());
    }

    @And("Search button text is {string}")
    public void searchButtonTextIs(String text) {
        assertEquals(text, mySitesPage.getSearchButtonText());
    }

    @And("All sites counter text is {string}")
    public void allSitesCounterTextIs(String text) {
        assertEquals(text, mySitesPage.getAllSitesText());
    }

    @And("Add the site button text is {string}")
    public void addTheSiteButtonTextIs(String text) {
        assertEquals(text, mySitesPage.getAddSiteButtonText());
    }

    @Then("The last section of the Navigation bar is {string}")
    public void navigationBarPageNameIs(String name) {
//        mySitesPage.clickElementByXpath("//a[@href='/contacts']");
//        mySitesPage.clickElementByXpath("//a[contains(@href, '/sites')]");
        assertEquals(name, mySitesPage.getNavigationBarPageName());
    }

    @Then("Every site line has activate-inactivate switch")
    public void everySiteLineHasActivateSwitch() {
        assertTrue(mySitesPage.isActivateSwitchDisplayed());
    }

    @And("Every site line has site name")
    public void everySiteLineHasSiteName() {
        assertTrue(mySitesPage.isSiteNameDisplayed());
    }

    @And("Every site line has URL")
    public void everySiteLineHasURL() {
        assertTrue(mySitesPage.isSiteUrlDisplayed());
    }

    @And("Every site line has Add the widget button")
    public void everySiteLineHasAddTheWidgetButton() {
        assertTrue(mySitesPage.isAddWidgetButtonDisplayed());
    }

    @And("Every site line has Settings button")
    public void everySiteLineHasSettingsButton() {
        assertTrue(mySitesPage.isSettingsButtonDisplayed());
    }



    @When("User clicks Site name link of the Test site SearchKey1 line")
    public void userClicksTest1SiteName() {
        mySitesPage.clickTest1SiteName();
    }

    @When("User clicks Add the widget button of the Test site SearchKey1 line")
    public void userClicksTest1SiteAddWidgetButton() {
        mySitesPage.clickTest1SiteAddWidgetButton();
    }

    @When("User clicks Settings button of the Test site SearchKey1 line")
    public void userClicksTest1SiteSettingsButton() {
        mySitesPage.clickTest1SiteSettingsButton();
    }

    @Then("Site page of the Test site SearchKey1 site opens")
    public void test1SitePageOpens() {
        assertEquals(mySitesPage.ROOT_URL.concat(mySitesPage.TEST_SITE_1_URL), mySitesPage.waitAndGetCurrentPageUrl(mySitesPage.ROOT_URL.concat(mySitesPage.TEST_SITE_1_URL)));
    }

    @Then("Create the widget page of the Test site SearchKey1 site opens")
    public void test1SiteCreateWidgetPageOpens() {
        assertEquals(mySitesPage.ROOT_URL.concat(mySitesPage.TEST_SITE_1_CREATE_WIGET_URL), mySitesPage.waitAndGetCurrentPageUrl(mySitesPage.ROOT_URL.concat(mySitesPage.TEST_SITE_1_CREATE_WIGET_URL)));
    }

    @Then("Settings page of the Test site SearchKey1 site opens")
    public void test1SiteSettingsPageOpens() {
        assertEquals(mySitesPage.ROOT_URL.concat(mySitesPage.TEST_SITE_1_SETTINGS_URL), mySitesPage.waitAndGetCurrentPageUrl(mySitesPage.ROOT_URL.concat(mySitesPage.TEST_SITE_1_SETTINGS_URL)));
    }

    @Then("Add the widget button text in the Test site SearchKey1 line is {string}")
    public void addTheWidgetButtonTextIs(String text) {
        assertEquals(text, mySitesPage.getAddWidgetButtonText());
    }

    @And("Settings button tooltip in the Test site SearchKey1 line is {string}")
    public void settingsButtonTooltipInTheTestSiteSearchKeyLineIs(String tip) {
        assertEquals(tip, mySitesPage.getSettingsButtonTip());
    }

    @When("User types Searchkey in the Search field")
    public void userTypesSearchkeyInTheSearchField() {
    }

    @Then("The sites table with two sites Test site SearchKey{int} and Test site searchkey{int} only is displayed")
    public void theSitesTableWithTwoSitesTestSiteSearchKeyAndTestSiteSearchkeyOnlyIsDisplayed(int arg0, int arg1) {
    }

    @And("All sites counter number is {int}")
    public void allSitesCounterNumberIs(int arg0) {
    }

    @When("User types qwerty in the Search field")
    public void userTypesQwertyInTheSearchField() {
    }

    @When("User clicks Update button")
    public void userClicksUpdateButton() {
    }

    @Then("The sites table with four sites is displayed")
    public void theSitesTableWithFourSitesIsDisplayed() {
    }
}
