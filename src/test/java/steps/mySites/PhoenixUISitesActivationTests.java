package steps.mySites;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.mySites.MySitesPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PhoenixUISitesActivationTests {
    private MySitesPage mySitesPage;
    public static List<AssertionError> errors;


    public PhoenixUISitesActivationTests() {
        mySitesPage = new MySitesPage();
    }

    @When("User clicks activate-inactivate switch in the Test site SearchKey1 line")
    public void userClicksActivateSwitch() {
        mySitesPage.clickActivateSwitch();
    }

    @Then("Activation message is displayed")
    public void activationMessageIsDisplayed() {
        assertTrue(mySitesPage.isActivationMessageDisplayed());
    }

    @When("User clicks OK button of the activation message")
    public void userClicksActivationMessageOKButton() {
        mySitesPage.clickMessageOkButton();
    }

    @Then("Activation message is disappearing")
    public void activationMessageIsDisappearing() {
        assertFalse(mySitesPage.isActivationMessageDisplayed());
    }

    @And("Activate-inactivate switch in Test site SearchKey1 line is on")
    public void activateSwitchIsOn() {
        assertTrue(mySitesPage.activateSwitchIsOn());
    }

    @And("Switch tooltip text is Inactivate")
    public void switchTooltipTextIsInactivate() {
        try {
            assertEquals(mySitesPage.INACTIVATE_TIP, mySitesPage.getActivateSwitchTip());
        } catch (AssertionError error) {
            errors.add(error);
            mySitesPage.logger.info("Switch tooltip text is Inactivate step failed");
            mySitesPage.logger.info(String.format("Actual tip is %s", mySitesPage.getActivateSwitchTip()));
        }
    }

    @Then("Switch tooltip is {string}")
    public void switchTooltipIs(String tip) {
        try {
            assertEquals(tip, mySitesPage.getActivateSwitchTip());
        } catch (AssertionError error) {
            errors.add(error);
            mySitesPage.logger.info(String.format("Switch tooltip is %s step failed", tip));
            mySitesPage.logger.info(String.format("Actual tip is %s", mySitesPage.getActivateSwitchTip()));

        }
    }

    @Then("Inactivation warning is displayed")
    public void inactivationWarningIsDisplayed() {
        assertTrue(mySitesPage.isInactivationWarningDisplayed());
    }

    @When("User clicks Cancel button of the inactivation warning")
    public void userClicksInactivationCancelButton() {
        mySitesPage.clickWarningCancelButton();
    }

    @Then("Inactivation warning is disappearing")
    public void inactivationWarningIsDisappearing() {
        assertFalse(mySitesPage.isInactivationWarningDisplayed());
    }

    @And("User clicks Go button of the Inactivation warning")
    public void userClicksInactivationGoButton() {
        mySitesPage.clickMessageOkButton();
        mySitesPage.waitForMessage();
    }

    @Then("Inactivation message is displayed")
    public void inactivationMessageIsDisplayed() {
        assertTrue(mySitesPage.isInactivationMessageDisplayed());
    }

    @When("User clicks Ok button of the inactivation message")
    public void userClicksInactivationMessageOKButton() {
        mySitesPage.clickMessageOkButton();
    }

    @Then("Inactivation message is disappearing")
    public void inactivationMessageIsDisappearing() {
        assertFalse(mySitesPage.isActivationMessageDisplayed());
    }

    @And("Activate-inactivate switch in Test site SearchKey1 line is off")
    public void activateSwitchIsOff() {
        assertTrue(mySitesPage.activateSwitchIsOff());
    }

    @And("Switch tooltip text is Activate")
    public void switchTooltipTextIsActivate() {
        try {
            assertEquals(mySitesPage.ACTIVATE_TIP, mySitesPage.getActivateSwitchTip());
        } catch (AssertionError error) {
            errors.add(error);
            mySitesPage.logger.info("Switch tooltip text is Activate step failed");
            mySitesPage.logger.info(String.format("Actual tip is %s", mySitesPage.getActivateSwitchTip()));
        }
    }

    @Then("Pop-up message with {string} text and {string} button appears")
    public void popUpMessageText(String text, String button) {
        try {
        assertEquals(text, mySitesPage.getActivationMessageText());
        assertEquals(button, mySitesPage.getActivationMessageOkButtonText());
        } catch (AssertionError error) {
            errors.add(error);
            mySitesPage.logger.info(String.format("Pop-up message with %s text and %s button appears step failed", text, button));
            mySitesPage.logger.info(String.format("Actual message is %s", mySitesPage.getActivationMessageText()));
        }
    }

    @Then("Pop-up warning with text {string}, {string} and {string} buttons appears")
    public void popUpWarningText(String text, String cancel, String go) {
        try {
            assertEquals(text, mySitesPage.getActivationMessageText());
            assertEquals(cancel, mySitesPage.getActivationMessageCancelButtonText());
            assertEquals(go, mySitesPage.getActivationMessageOkButtonText());
        } catch (AssertionError error) {
            errors.add(error);
            mySitesPage.logger.info(String.format("Pop-up warning with text %s, %s and %s buttons appears step failed", text, cancel, go));
            mySitesPage.logger.info(String.format("Actual message is %s", mySitesPage.getActivationMessageText()));

        }
    }

}
