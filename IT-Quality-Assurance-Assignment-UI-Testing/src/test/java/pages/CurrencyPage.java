package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CurrencyPage extends PageObject {

    final String currencyDropdownSelector = "currency-change-select";
    final String currencyOptionSelector = "//select[@id='currency-change-select']/option[@value='%s']";
    final String priceElementSelector = "//span[contains(@class,'price')]";
    // final String currencyDropdownSelector = "#block-switcher-currency select";


    public void changeCurrency(String currency) {
        WebElementFacade currencyDropdown = find(By.id(currencyDropdownSelector));
        Select dropdown = new Select(currencyDropdown);
        dropdown.selectByValue(currency);
    }


     public String getSelectedCurrency() {
        WebElementFacade currencyDropdown = find(By.id(currencyDropdownSelector));
         Select dropdown = new Select(currencyDropdown);
         return dropdown.getFirstSelectedOption().getText().trim();
     }

    public boolean verifyAllPricesInCurrency(String currency) {
        List<WebElementFacade> priceElements = findAll(By.xpath(priceElementSelector));
        boolean allPricesMatch = true;
        for (WebElementFacade priceElement : priceElements) {
            String priceText = priceElement.getText();
            if (!priceText.contains(currency)) {
                 allPricesMatch = false;
                 System.err.println("Price : "+priceText+" currency is not "+ currency);
                 break;
            }
        }
        return allPricesMatch;
    }
}