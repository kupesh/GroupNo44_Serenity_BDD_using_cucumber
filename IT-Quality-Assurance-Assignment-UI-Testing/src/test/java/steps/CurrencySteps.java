package steps;

import config.Constants;
import net.serenitybdd.annotations.Steps;
import pages.CurrencyPage;
import pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class CurrencySteps {

    @Steps
    private CurrencyPage currencyPage;
    @Steps
    private HomePage homePage;


    final String baseUrl = Constants.BASE_URL+Constants.HOME_PAGE_ENDPOINT;

    @Given("I open the HomePage for currency testing")
    public void openHomePage() {
        homePage.openWebPage(baseUrl);
    }


    @When("I change the currency to {string}")
    public void changeCurrency(String currency) {
        currencyPage.changeCurrency(currency);
    }
    @Then("the currency should be changed to {string}")
    public void verifyCurrencyChange(String currency) throws InterruptedException{
        Thread.sleep(1000);
        assertEquals(currencyPage.getSelectedCurrency(), currency);
    }

    @Then("I should verify the currency displayed is {string} across the website")
    public void verifyCurrencyDisplay(String currency) {
        assertTrue(currencyPage.verifyAllPricesInCurrency(currency));
    }
}