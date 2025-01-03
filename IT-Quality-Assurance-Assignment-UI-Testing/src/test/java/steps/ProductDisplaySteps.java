package steps;

import pages.ProductDisplayPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import static org.junit.Assert.assertTrue;

public class ProductDisplaySteps {

    @Steps
    private ProductDisplayPage productDisplayPage;

    @Given("I am on the product listing page to check the name")
    public void i_am_on_the_product_listing_page_to_check_the_name() {
        productDisplayPage.openProductPage();
    }

    @When("I check if the product name is visible")
    public void i_check_if_the_product_name_is_visible() {
        assertTrue("Product name should be visible", productDisplayPage.isProductNameVisible());
    }

    @Given("I am on the product listing page to check the image")
    public void i_am_on_the_product_listing_page_to_check_the_image() {
        productDisplayPage.openProductPage();
    }

    @When("I check if the product image is visible")
    public void i_check_if_the_product_image_is_visible() {
        assertTrue("Product image should be visible", productDisplayPage.isProductImageVisible());
    }

    @Given("I am on the product listing page to check the price")
    public void i_am_on_the_product_listing_page_to_check_the_price() {
        productDisplayPage.openProductPage();
    }

    @When("I check if the product price is visible")
    public void i_check_if_the_product_price_is_visible() {
        assertTrue("Product price should be visible", productDisplayPage.isProductPriceVisible());
    }
}
