package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FilterPage extends PageObject {

    private final By minPriceInputLocator = By.xpath("//input[@id='amount-min']");
    private final By maxPriceInputLocator = By.xpath("//input[@id='amount-max']");
    private final By categoryComputersCheckboxLocator = By.xpath("//div[@id='block-categories']//label[contains(.,'Mobile & Tablets, Computers, Printers, Projectors & Accessories')]");
    private final By stockOutCheckBoxLocator = By.xpath("//input[@id='stock-0']");
    private final By offer20PercentCheckboxLocator = By.xpath("//div[@id='block-offers']//label[contains(.,'20% or More')]");
    private final By sortDropdownLocator = By.xpath("//select[@class='form-select']");
    private final By clearAllButtonLocator = By.xpath("//button[contains(text(),'Clear All')]");


    //  Product listing
    @FindBy(xpath = "//div[@class = 'product-card-wrap']")
    List<WebElementFacade> productCards;

    public void openWebPage(String url) {
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        openAt(url);
    }
    public WebElementFacade waitForElement(By locator, int timeOutInSec){
          WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeOutInSec));
          WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
          return $(element);
    }

    public void enterMinPrice(String minPrice) {
         waitForElement(minPriceInputLocator,20).waitUntilVisible().type(minPrice);
    }

   public void enterMaxPrice(String maxPrice) {
        waitForElement(maxPriceInputLocator,20).waitUntilVisible().type(maxPrice);
    }


    public void selectCategoryComputers() {
       waitForElement(categoryComputersCheckboxLocator,20).waitUntilVisible().click();
    }

    public void selectExcludeStockOut() {
         waitForElement(stockOutCheckBoxLocator,20).waitUntilVisible().click();
    }

    public void selectOffer20Percent() {
         waitForElement(offer20PercentCheckboxLocator,20).waitUntilVisible().click();
    }

    public void selectSortOption(String option) {
        waitForElement(sortDropdownLocator,20).waitUntilVisible().click();
         find(By.xpath(String.format("//option[text()='%s']", option))).waitUntilVisible().click();
    }
    
    public void clearAll() {
        waitForElement(clearAllButtonLocator,20).waitUntilVisible().click();
    }


    public boolean isProductInPriceRange(int min, int max) {
        for (WebElementFacade productCard : productCards) {
            String priceText = productCard.find(By.xpath(".//div[@class = 'product-card-price']")).getText().replaceAll("[^0-9]", "");
            int price = Integer.parseInt(priceText);
            if (price < min || price > max) {
                return false;
            }
        }
        return true;
    }

    public boolean isProductInCategory(String category) {
        for(WebElementFacade productCard : productCards)
        {
           String categoryText = productCard.find(By.xpath(".//div[@class='product-card-category']")).getText();
           if(!categoryText.contains(category)) {
              return false;
           }
        }
        return true;
    }

    public boolean isOutOfStockProductListed() {
        for(WebElementFacade productCard : productCards) {
            List<WebElement> stockoutElements = productCard.findElements(By.xpath(".//span[contains(@class,'stockout-tag')]"));
            if(!stockoutElements.isEmpty()){
               return true;
            }
       }
      return false;
    }

    public boolean isProductInOfferCategory(String offer) {
         for (WebElementFacade productCard : productCards) {
            List<WebElement> offerElements = productCard.findElements(By.xpath(".//div[contains(@class,'product-card-discount')]"));
             if(!offerElements.isEmpty()) {
                 String offerText = productCard.find(By.xpath(".//div[contains(@class,'product-card-discount')]")).getText();
                 offerText = offerText.replaceAll("[^0-9]", "");
                  int offerValue = Integer.parseInt(offerText);
                 if(offer.equals("20% or More") && offerValue < 20) {
                   return false;
                }
            }
           else if(offer.equals("20% or More")){
               return false;
            }
         }
        return true;
    }

    public boolean isProductSorted(String order) {
      if (productCards.size() <= 1)
            return true;

       for (int i = 0; i < productCards.size() - 1; i++) {
          String priceText1 = productCards.get(i).find(By.xpath(".//div[@class = 'product-card-price']")).getText().replaceAll("[^0-9]", "");
          int price1 = Integer.parseInt(priceText1);
         String priceText2 = productCards.get(i + 1).find(By.xpath(".//div[@class = 'product-card-price']")).getText().replaceAll("[^0-9]", "");
         int price2 = Integer.parseInt(priceText2);

          if (order.equals("Price - Low to High") && price1 > price2)
            {
               return false;
           }
          if (order.equals("Price - High to Low") && price1 < price2) {
                return false;
          }
        }
          return true;
  }

    public boolean areFiltersCleared()
    {
        return  waitForElement(minPriceInputLocator,20).getValue().isEmpty() && waitForElement(maxPriceInputLocator,20).getValue().isEmpty() && !waitForElement(categoryComputersCheckboxLocator,20).isSelected() && !waitForElement(stockOutCheckBoxLocator,20).isSelected() && !waitForElement(offer20PercentCheckboxLocator,20).isSelected();

    }
}