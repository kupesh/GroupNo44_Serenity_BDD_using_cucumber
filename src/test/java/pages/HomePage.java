package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class HomePage extends PageObject {

    final String searchBarSelector = "edit-search";
    final String noResultsMsgSelector = ".lzd-search-common-icon.ic-common-ic-Noresult";

    public void openWebPage(String url) {
        openAt(url);
    }

    public void searchForProduct(String product) {
        WebElementFacade searchBar = find(By.id(searchBarSelector));
        searchBar.waitUntilVisible().waitUntilClickable().typeAndEnter(product);
    }

    public boolean verifyNoSearchResultsMessage() {
        WebElementFacade noResultsMessage = find(By.cssSelector(noResultsMsgSelector));
        try {
            noResultsMessage.shouldBeVisible();
            return true;
        } catch (AssertionError e) {
            return false;
        }
    }
}
