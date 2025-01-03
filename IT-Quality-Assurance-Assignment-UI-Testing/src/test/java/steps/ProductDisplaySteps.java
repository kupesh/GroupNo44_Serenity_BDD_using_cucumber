package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ProductDisplayPage;
import static org.junit.Assert.assertTrue;

public class ProductDisplaySteps {

    private ProductDisplayPage productDisplayPage = new ProductDisplayPage();

    @Given("I open the product page for Dell Optical Wired Mouse MS116")
    public void i_open_the_product_page() {
        productDisplayPage.openPage("https://www.singersl.com/product/dell-optical-wired-mouse-ms116");
    }

    @Then("I check if the product is available")
    public void i_check_if_a_product_is_available() {
        boolean isProductAvailable = productDisplayPage.isProductAvailable();
        assertTrue("Product is not available", isProductAvailable);
    }

    @Then("I should see the product image and price displayed")
    public void i_should_see_the_product_image_and_price_displayed() {
        assertTrue("Product image is not displayed", productDisplayPage.isProductImageDisplayed());
        assertTrue("Product price is not displayed", productDisplayPage.isProductPriceDisplayed());
    }
}
