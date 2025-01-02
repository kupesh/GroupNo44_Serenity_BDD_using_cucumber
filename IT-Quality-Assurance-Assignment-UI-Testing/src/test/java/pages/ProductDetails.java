package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import java.util.Objects;

public class ProductDetailsPage extends PageObject {

    final String productTitleSelector = "product-title"; // Replace with actual selector
    final String productDescriptionSelector = "product-description"; // Replace with actual selector
    final String productPriceSelector = "product-price"; // Replace with actual selector
    final String addToCartButtonSelector = "add-to-cart"; // Replace with actual selector
    final String outOfStockMessageSelector = "out-of-stock-message"; // Replace with actual selector
    final String productImageGallerySelector = "product-image-gallery"; // Replace with actual selector

    public void openProductDetailPage(String productId) {
        String productDetailUrl = "/product-details/" + productId;
        openAt(productDetailUrl);
    }

    public boolean verifyProductTitle(String expectedTitle) {
        WebElementFacade titleElement = find(By.id(productTitleSelector));
        return titleElement.waitUntilVisible().getText().equals(expectedTitle);
    }

    public boolean verifyProductDescriptionIsNotEmpty() {
        WebElementFacade descriptionElement = find(By.id(productDescriptionSelector));
        return descriptionElement.waitUntilVisible().getText().trim().length() > 0;
    }

    public boolean verifyProductPrice(String expectedCurrency) {
        WebElementFacade priceElement = find(By.id(productPriceSelector));
        String priceText = priceElement.waitUntilVisible().getText();
        return priceText.startsWith(expectedCurrency); // E.g., "$" or "USD"
    }

    public boolean verifyImageGalleryIsDisplayed() {
        WebElementFacade galleryElement = find(By.id(productImageGallerySelector));
        return galleryElement.waitUntilVisible().isDisplayed();
    }

    public boolean verifyAddToCartButtonIsEnabled() {
        WebElementFacade addToCartButton = find(By.id(addToCartButtonSelector));
        return addToCartButton.waitUntilVisible().isEnabled();
    }

    public boolean verifyOutOfStockMessage() {
        WebElementFacade outOfStockMessage = find(By.id(outOfStockMessageSelector));
        return outOfStockMessage.waitUntilVisible().isDisplayed();
    }

    public boolean verifyNoProductFoundMessage() {
        String pageSource = this.getDriver().getPageSource();
        assert pageSource != null;
        return pageSource.contains("Product not found");
    }
}
