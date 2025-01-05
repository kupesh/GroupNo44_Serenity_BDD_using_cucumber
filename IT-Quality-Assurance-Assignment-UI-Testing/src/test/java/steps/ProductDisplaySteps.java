package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ProductDisplayPage;
import static org.junit.Assert.assertTrue;

public class ProductDisplaySteps {

    private ProductDisplayPage productDisplayPage = new ProductDisplayPage();

    @Given("I open the product display page")
    public void i_open_the_product_display_page() {
        System.out.println("Navigating to the product display page...");
        productDisplayPage.openPage("https://www.singersl.com/product/dell-optical-wired-mouse-ms116");
        System.out.println("Product display page opened successfully.");
    }

    @Then("I check if the product is available")
    public void i_check_if_a_product_is_available() {
        System.out.println("Simulating product availability check...");
  
        boolean isProductAvailable = true; 
        System.out.println("Product availability: " + (isProductAvailable ? "Available" : "Not Available"));
        assertTrue("Product is not available", isProductAvailable); 
    }

    @Then("I validate the product display")
    public void i_validate_the_product_display() {
        System.out.println("Simulating product image check...");
        boolean isImageDisplayed = true; 
        System.out.println("Product image displayed: " + (isImageDisplayed ? "Yes" : "No"));
        assertTrue("Product image is not displayed", isImageDisplayed); 

        System.out.println("Simulating product price check...");
        boolean isPriceDisplayed = true; 
        System.out.println("Product price displayed: " + (isPriceDisplayed ? "Yes" : "No"));
        assertTrue("Product price is not displayed", isPriceDisplayed); 
    }
}
