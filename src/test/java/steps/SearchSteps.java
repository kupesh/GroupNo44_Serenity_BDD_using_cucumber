package steps;

import net.serenitybdd.annotations.Steps;
import pages.DarazHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

public class SearchSteps {

    @Steps
    private DarazHomePage darazHomePage;
    final String baseUrl = "https://www.daraz.lk";

    @Given("I open the Daraz.lk homepage")
    public void i_open_the_daraz_lk_homepage() {
        darazHomePage.openWebPage(baseUrl);
    }

    @When("I search for {string}")
    public void i_search_for(String product) {
        darazHomePage.searchForProduct(product);
    }

    @Then("I should see search results related to {string}")
    public void i_should_see_search_results_related_to(String product) {
        assertTrue(darazHomePage.getDriver().getPageSource().contains(product));
    }

    @Then("I should see a message indicating no search results were found")
    public void i_should_see_no_results_message() {
        assertTrue(darazHomePage.noSearchResultsMessageIsDisplayed());
    }
}