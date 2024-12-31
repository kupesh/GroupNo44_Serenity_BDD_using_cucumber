package steps;

import net.serenitybdd.annotations.Steps;
import pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

public class CartSteps {

    @Steps
    private ProductPage productPage;

    final String baseUrl = "https://www.singersl.com/";

    @Given("I open the product page for {string}")
    public void openProductPage(String product) {
        productPage.openProductPage(baseUrl, product);
    }

    @When("I click Add to Cart")
    public void clickAddToCartButton() {
        productPage.clickAddToCartButton();
    }

    @When("I set the quantity to {string}")
    public void setQuantity(String quantity) {
        productPage.setQuantity(quantity);
    }

    @Then("I should see the message {string}")
    public void verifyMessage(String message) {
        assertTrue(productPage.getPageSource().contains(message));
    }

    @Then("the cart should show {int} item(s)")
    public void verifyCartItems(int itemCount) {
        assertTrue(productPage.getCartItemCount() == itemCount);
    }

    @Then("I should be prompted to log in or continue as a guest")
    public void verifyLoginPrompt() {
        assertTrue(productPage.isLoginPromptDisplayed());
    }
}
