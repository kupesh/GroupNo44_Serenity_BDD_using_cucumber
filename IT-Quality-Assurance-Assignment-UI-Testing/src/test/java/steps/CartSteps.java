package steps;

import io.cucumber.java.en.And;
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
        boolean messageFound = false;
        int maxRetries = 10; // Retry up to 10 times
        int interval = 500; // Wait 500ms between retries

        for (int i = 0; i < maxRetries; i++) {
            if (productPage.checkVisibility(message)) {
                messageFound = true;
                break;
            }
            try {
                Thread.sleep(interval); // Wait before retrying
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Reset thread interrupt status
                throw new RuntimeException("Thread interrupted while waiting for message", e);
            }
        }

        assertTrue("Expected message not found: " + message, messageFound);
    }


    @And("the cart should show {int} item(s)")
    public void verifyCartItems(int itemCount) throws InterruptedException {
        assertTrue(productPage.getCartItemCount() == itemCount);
    }

    @Then("I should be prompted to log in or continue as a guest")
    public void verifyLoginPrompt() {
        assertTrue(productPage.isLoginPromptDisplayed());
    }
}