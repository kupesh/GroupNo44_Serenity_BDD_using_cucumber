package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RedLoyaltyPage extends PageObject {

    final String redLoyaltyTabSelector = "a[href='https://www.singersl.com/added-services/singer-red-loyalty-program']";

    final String pointsDisplaySelector = "div[style*='text-align:center;'] span b";
    final String errorMessageSelector = "div[style='text-align:center;']";
    final String checkRedPointsButtonSelector = "a.btn.mt-4.red-btn";


    public void clickRedLoyaltyTab() {
        WebElementFacade redLoyaltyTab = find(By.cssSelector(redLoyaltyTabSelector));
        redLoyaltyTab.waitUntilClickable().click();
    }

    public void clickCheckRedPointsButton() {
        WebElementFacade checkRedPointsButton = find(By.cssSelector(checkRedPointsButtonSelector));
        checkRedPointsButton.waitUntilClickable().click();

    }

    public boolean isOnFormPage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("data-fancybox")); // Replace "formPage" with the actual URL or identifier of the form page.
        return getDriver().getCurrentUrl().contains("data-fancybox");
    }

    public void openFormPageDirectly() {
        getDriver().get("https://www.singersl.com/added-services/singer-red-loyalty-program#data-fancybox"); // Update with the actual URL.
    }


    public void enterNIC(String nic) {

        System.out.println("Locating NIC input field using XPath: //*[@id='MyNIC']");
        WebElementFacade nicInputField = find(By.xpath("//input[@id='MyNIC']"));
//        WebElement field = driver.findElement(By.xpath("//form[@id='formID']//input[@id='MyNIC']"));

        // Wait until the field is visible
        nicInputField.waitUntilVisible();

        // Click the field to ensure it is enabled
        nicInputField.click();

        // Wait until the field becomes enabled and clickable
        nicInputField.waitUntilEnabled().waitUntilClickable();

        // Type the NIC value
        nicInputField.type(nic);

    }

    public void clickSubmitButton() {

        WebElementFacade submitButton = find(By.xpath("//*[@id=\"submit\"]"));
        submitButton.waitUntilVisible().waitUntilClickable().click();

    }

    public String getPointsDisplayMessage() {
        WebElementFacade pointsDisplay = find(By.cssSelector(pointsDisplaySelector));
        return pointsDisplay.waitUntilVisible().getText();
    }

    public String getValidationMessage() {

        WebElementFacade nicInputField = find(By.xpath("//*[@id='MyNIC']"));
        nicInputField.waitUntilVisible().waitUntilClickable().click();
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
