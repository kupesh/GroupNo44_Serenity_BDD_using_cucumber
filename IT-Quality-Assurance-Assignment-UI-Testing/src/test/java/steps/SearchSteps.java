package steps;

import config.Constants;
import net.serenitybdd.annotations.Steps;
import pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

public class SearchSteps {

    @Steps
    private HomePage HomePage;

    final String baseUrl = Constants.BASE_URL+Constants.HOME_PAGE_ENDPOINT;

    @Given("I open the homepage")
    public void openHomePage() {
        HomePage.openWebPage(baseUrl);
    }

    @When("I search for {string}")
    public void searchFor(String product) {
        HomePage.searchForProduct(product);
    }

    @Then("I should see search results related to {string}")
    public void seeResults(String product) {
        assertTrue(HomePage.getDriver().getPageSource().contains(product));
    }

    @Then("I should see a message indicating no search results were found")
    public void verifyNoResults() {
        assertTrue(HomePage.verifyNoSearchResultsMessage());
    }
}
