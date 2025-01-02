package steps;

import net.serenitybdd.annotations.Steps;
import pages.ProductDetailsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertTrue;

public class ProductDetailsSteps {

    @Steps
    private ProductDetailsPage productDetailsPage;

    @Given("I navigate to the product detail page for product {string}")
    public void navigateToProductDetailPage(String productId) {
        productDetailsPage.openProductDetailPage("https://www.singersl.com/products/" + productId);
    }

    @Then("I should see the product title {string}")
    public void verifyProductTitle(String expectedTitle) {
        assertTrue("The product title is not displayed correctly.",
                productDetailsPage.verifyProductTitle(expectedTitle));
    }

    @Then("I should see a product description that is not empty")
    public void verifyProductDescriptionIsNotEmpty() {
        assertTrue("The product description is empty.",
                productDetailsPage.verifyProductDescriptionIsNotEmpty());
    }

    @Then("I should see a price displayed in {string}")
    public void verifyProductPrice(String expectedCurrency) {
        assertTrue("The product price is not displayed in the expected currency.",
                productDetailsPage.verifyProductPrice(expectedCurrency));
    }

    @Then("I should see a high-quality main product image")
    public void verifyMainProductImage() {
        assertTrue("The product image gallery is not displayed.",
                productDetailsPage.verifyImageGalleryIsDisplayed());
    }

    @Then("I should be able to navigate through the image gallery")
    public void verifyImageGalleryNavigation() {
        assertTrue("Image gallery navigation is not functional.",
                productDetailsPage.verifyImageGalleryNavigation());
    }

    @Then("I should see the zoom feature working on the product image")
    public void verifyZoomFeature() {
        assertTrue("Zoom feature verification needs to be implemented.",
                productDetailsPage.verifyZoomFeature());
    }

    @Then("I should see a message indicating {string}")
    public void verifyOutOfStockMessage(String message) {
        if (message.equalsIgnoreCase("Out of Stock")) {
            assertTrue("The 'Out of Stock' message is not displayed.",
                    productDetailsPage.verifyOutOfStockMessage());
        } else if (message.equalsIgnoreCase("Product not found")) {
            assertTrue("The 'Product not found' message is not displayed.",
                    productDetailsPage.verifyNoProductFoundMessage());
        }
    }

    @Then("The {string} button should be {string}")
    public void verifyAddToCartButtonState(String buttonName, String state) {
        if (buttonName.equalsIgnoreCase("Add to Cart") && state.equalsIgnoreCase("enabled")) {
            assertTrue("The 'Add to Cart' button is not enabled.",
                    productDetailsPage.verifyAddToCartButtonIsEnabled());
        } else if (buttonName.equalsIgnoreCase("Add to Cart") && state.equalsIgnoreCase("disabled")) {
            assertTrue("The 'Add to Cart' button is not disabled.",
                    !productDetailsPage.verifyAddToCartButtonIsEnabled());
        }
    }
}
