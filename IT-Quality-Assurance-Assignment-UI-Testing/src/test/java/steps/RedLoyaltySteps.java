package steps;

import config.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import pages.HomePage;
import pages.RedLoyaltyPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RedLoyaltySteps {

    @Steps
    private HomePage homePage;
    @Steps
    private RedLoyaltyPage redLoyaltyPage;

    final String baseUrl = Constants.BASE_URL+Constants.HOME_PAGE_ENDPOINT;
    final String loyaltyurl = Constants.BASE_URL+Constants.LOYALTY_PAGE_ENDPOINT;


    @Given("I am on the homepage")
    public void openHomePage() {
        homePage.openWebPage(baseUrl);
    }

    @When("I click the Red Loyalty Tab")
    public void clickRedLoyaltyTab() {
        redLoyaltyPage.clickRedLoyaltyTab();
    }

    @Then("I should be redirected to the Red Loyalty page")
    public void verifyRedLoyaltyPage() {
        assertTrue(redLoyaltyPage.getDriver().getCurrentUrl().contains("added-services/singer-red-loyalty-program"));
    }

    @Given("I am on the Red Loyalty page")
    public void openRedLoyaltyPage() {
        homePage.openWebPage(loyaltyurl);
    }

    @When("I click the \"Check Red Points and Loyalty Status\" button")
    public void clickCheckRedPointsButton() {
        redLoyaltyPage.clickCheckRedPointsButton();
    }

    @When("I submit the form without entering a NIC")
    public void submitWithoutNIC() {
        redLoyaltyPage.clickSubmitButton();
    }

    @Then("I should see a validation message asking to enter a NIC")
    public void verifyValidationMessage() {
        String validationMessage = redLoyaltyPage.getValidationMessage();
        assertEquals("Please fill out this field.", validationMessage);
    }

    @When("I enter a valid NIC {string}")
    public void enterValidNIC(String nic) {
        redLoyaltyPage.enterNIC(nic);
    }

    @When("I enter an invalid NIC {string}")
    public void enterInvalidNIC(String nic) {
        redLoyaltyPage.enterNIC(nic);
    }

    @When("I enter a random NIC {string}")
    public void enterRandomNIC(String nic) {
        redLoyaltyPage.enterNIC(nic);
    }

    @When("I click the Submit button")
    public void clickSubmitButton() {
        redLoyaltyPage.clickSubmitButton();
    }

    @Then("I should see the available red points")
    public void verifyRedPoints() {
        String points = redLoyaltyPage.getPointsDisplayMessage();
        assertTrue(points.matches("\\d+")); // Points should be a numeric value
    }

    @Then("I should see the message as {string}")
    public void verifyErrorMessage(String expectedMessage) {
        String actualMessage = redLoyaltyPage.getErrorMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Then("the system should not return points but show an error message")
    public void verifyInvalidPointsResponse() {
        String message = redLoyaltyPage.getErrorMessage();
        assertTrue(message.equals("Invalid NIC") || message.equals("0 points found"));
    }

}
