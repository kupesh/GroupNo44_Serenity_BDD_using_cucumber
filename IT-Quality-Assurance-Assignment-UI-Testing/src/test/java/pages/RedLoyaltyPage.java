package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RedLoyaltyPage extends PageObject {

    private final String redLoyaltyTabSelector = "a[href='https://www.singersl.com/added-services/singer-red-loyalty-program']";
    private final String nicInputFieldSelector = "MyNIC";
    private final String submitButtonSelector = "submit";
    private final String pointsDisplaySelector = "div[style*='text-align:center;'] span b";
    private final String errorMessageSelector = "div[style='text-align:center;']";
    private final String checkRedPointsButtonSelector = "a.btn.mt-4.red-btn";


    public void clickRedLoyaltyTab() {
        WebElementFacade redLoyaltyTab = find(By.cssSelector(redLoyaltyTabSelector));
        redLoyaltyTab.waitUntilClickable().click();
    }

    public void clickCheckRedPointsButton() {
        WebElementFacade checkRedPointsButton = find(By.cssSelector(checkRedPointsButtonSelector));
        checkRedPointsButton.waitUntilClickable().click();

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("#data-fancybox"));
    }


    public void enterNIC(String nic) {
        WebElementFacade nicInputField = find(By.cssSelector(nicInputFieldSelector));
        nicInputField.waitUntilClickable().type(nic);
    }

    public void clickSubmitButton() {
        WebElementFacade submitButton = find(By.cssSelector(submitButtonSelector));
        submitButton.waitUntilClickable().click();
    }

    public String getPointsDisplayMessage() {
        WebElementFacade pointsDisplay = find(By.cssSelector(pointsDisplaySelector));
        return pointsDisplay.waitUntilVisible().getText();
    }

    public String getValidationMessage() {
        WebElementFacade nicInputField = find(By.cssSelector(nicInputFieldSelector));
        return nicInputField.getAttribute("validationMessage");
    }


    public String getErrorMessage() {
        try {
            WebElementFacade errorMessage = find(By.cssSelector(errorMessageSelector));
            return errorMessage.waitUntilVisible().getText();
        } catch (Exception e) {
            return null;
        }
    }

}
