package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ProductDisplayPage extends PageObject {

    private By productImage = By.cssSelector(".product-image-class");  // Modify the selector according to your HTML
    private By productPrice = By.id("single_product_price"); // Adjusted to the correct ID
    private By productAvailability = By.id("single_product_id");  // Adjusted to check product availability

    public boolean isProductAvailable() {
        return getDriver().findElement(productAvailability).isDisplayed();
    }

    public boolean isProductImageDisplayed() {
        return getDriver().findElement(productImage).isDisplayed();
    }

    public boolean isProductPriceDisplayed() {
        return getDriver().findElement(productPrice).isDisplayed();
    }
    
    public void openPage(String url) {
        openUrl(url);  // Use openUrl() instead of open()
    }
}
