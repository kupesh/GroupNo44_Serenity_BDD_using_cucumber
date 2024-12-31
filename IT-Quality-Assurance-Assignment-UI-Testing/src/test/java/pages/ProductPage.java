package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class ProductPage extends PageObject {

    final String addToCartButtonSelector = "/html[1]/body[1]/div[3]/main[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[2]/a[1]";
                public void openProductPage(String baseUrl, String product) {
        openAt(baseUrl + "/products/filter?search=" + product.replace(" ", "-").toLowerCase());
    }

    public void clickAddToCartButton() {
        WebElementFacade addToCartButton = find(By.xpath("//a[contains(@class, 'cart-link-btn')]"));
        if (addToCartButton.isEnabled() && addToCartButton.isDisplayed()) {
            addToCartButton.click();
        }
        else {
            System.out.println("Button is not enabled.");
        }
    }

    public void setQuantity(String quantity) {
        WebElementFacade quantityField = find(By.id("quantity"));
        quantityField.waitUntilVisible().clear();
        quantityField.type(quantity);
    }

    public int getCartItemCount() {
        WebElementFacade cartBadge = find(By.cssSelector(".cart-badge"));
        return Integer.parseInt(cartBadge.getText());
    }

    public String getPageSource() {
        return getDriver().getPageSource();
    }

    public boolean isLoginPromptDisplayed() {
        WebElementFacade loginPrompt = find(By.id("login-prompt"));
        return loginPrompt.isVisible();
    }
}
