package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class ProductPage extends PageObject {

    final String addToCartButtonSelector = "/html[1]/body[1]/div[3]/main[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[2]/a[1]";
    final String addToCartAlertSelector = ".add-to-card-alert";

    public void openProductPage(String baseUrl, String product) {
        openAt("https://www.singersl.com/products");
    }

    public void clickAddToCartButton() {
        List<WebElementFacade> addToCartButtons = findAll(By.xpath("//a[contains(@class, 'cart-link-btn')]"));

        if (!addToCartButtons.isEmpty()) {
            WebElementFacade firstAddToCartButton = addToCartButtons.get(0); // Get the first button

            if (firstAddToCartButton.isEnabled() && firstAddToCartButton.isDisplayed()) {
                firstAddToCartButton.click();
            } else {
                System.out.println("The first Add to Cart button is not enabled or visible.");
            }
        } else {
            System.out.println("No Add to Cart buttons found on the page.");
        }
    }

    public void setQuantity(String quantity) {
        WebElementFacade quantityField = find(By.id("quantity"));
        quantityField.waitUntilVisible().clear();
        quantityField.type(quantity);
    }

    public int getCartItemCount() throws InterruptedException {
        System.out.println("Getting cart item count");
        Thread.sleep(5000);
        WebElementFacade cartBadge = find(By.cssSelector(".cart-block-count"));
        System.out.println("Getting cart item count : "+ Integer.parseInt(cartBadge.getText()));
        return Integer.parseInt(cartBadge.getText());
    }

    public boolean checkVisibility(String message) {
        WebElementFacade messageElement = find(By.xpath("//*[contains(@class, addToCartAlertSelector)]"));
        return messageElement != null && messageElement.isDisplayed();
    }

    public String getPageSource() {
        return getDriver().getPageSource();
    }

    public boolean isLoginPromptDisplayed() {
        WebElementFacade loginPrompt = find(By.id("login-prompt"));
        return loginPrompt.isVisible();
    }
}