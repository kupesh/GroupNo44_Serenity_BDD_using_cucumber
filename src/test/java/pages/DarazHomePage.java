package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DarazHomePage extends PageObject {

    private By searchBarId = By.id("q");
    private By noResultsMessage = By.cssSelector("div.FWSEp div.ant-row.FrEdP.css-1bkhbmc.app:nth-child(2) div.ant-col.ant-col-24.css-1bkhbmc.app:nth-child(1) div.ant-row.css-1bkhbmc.app div.ant-col.ant-col-20.ant-col-push-4.Jv5R8.css-1bkhbmc.app:nth-child(1) div.pcoj4 div.Eu9FH > i.lzd-search-common-icon.ic-common-ic-Noresult");

    public void openWebPage(String url) {
        getDriver().get(url);
    }

    public void searchForProduct(String product) {
        WebElement searchBox = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(searchBarId));
        searchBox.sendKeys(product);
        searchBox.submit();
    }

    public boolean noSearchResultsMessageIsDisplayed() {
        WebElement noResultsMessageElement = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(noResultsMessage));
        return noResultsMessageElement.isDisplayed();
    }
}
