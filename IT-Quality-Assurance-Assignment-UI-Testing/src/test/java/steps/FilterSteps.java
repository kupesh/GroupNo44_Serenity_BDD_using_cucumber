package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import pages.FilterPage;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class FilterSteps {

    @Steps
    private FilterPage filterPage;

    final String baseUrl = "http://singersl.com/brands/dell";

     @Given("User is on the product page")
    public void userIsOnTheProductPage() {
        filterPage.openWebPage(baseUrl);
    }

    @When("User filters with price range {string} to {string}")
    public void userFiltersWithPriceRange(String minPrice, String maxPrice) {
        filterPage.enterMinPrice(minPrice);
        filterPage.enterMaxPrice(maxPrice);
    }

    @Then("Products should be filtered to within that price range")
    public void productsShouldBeFilteredToWithinThatPriceRange() {
        assertTrue(filterPage.isProductInPriceRange(2000,10000));
    }

    @When("User filters by category {string}")
    public void userFiltersByCategory(String category) {
        filterPage.selectCategoryComputers();
    }

    @Then("Products should be filtered by category {string}")
    public void productsShouldBeFilteredByCategory(String category) {
        assertTrue(filterPage.isProductInCategory(category));
    }

    @When("User filters by {string}")
    public void userFiltersByAvailability(String option) {
        filterPage.selectExcludeStockOut();
    }

    @Then("Out of stock product should not be listed")
    public void outOfStockProductShouldNotBeListed() {
        assertFalse(filterPage.isOutOfStockProductListed()); 
    }

    @When("User filters by offer {string}")
    public void userFiltersByOffer(String offerPercentage) {
        filterPage.selectOffer20Percent();
    }

    @Then("Products that are not in the offer category should not be listed")
    public void productsThatAreNotInTheOfferCategoryShouldNotBeListed() {
        assertTrue(filterPage.isProductInOfferCategory("20% or More"));
    }

    @When("User applies category {string}, price range {string} to {string}, and offer {string}")
    public void userAppliesMultipleFilters(String category, String minPrice, String maxPrice, String offer) {
        filterPage.selectCategoryComputers();
        filterPage.enterMinPrice(minPrice);
        filterPage.enterMaxPrice(maxPrice);
        filterPage.selectOffer20Percent();
    }

    @Then("Products should be filtered by all specified criteria")
    public void productsShouldBeFilteredByAllCriteria() {
    //Assert as required
    }

   @When("User sorts by {string}")
   public void userSortsBy(String sortOption)
   {
     filterPage.selectSortOption(sortOption);
   }
  @Then("products should be sorted in {string} order.")
    public void productsShouldBeSortedIn(String sortOption)
  {
    assertTrue(filterPage.isProductSorted(sortOption));
  }
  @When("User filters with various options")
  public void userFiltersWithVariousOptions()
  {
      filterPage.selectCategoryComputers();
      filterPage.selectExcludeStockOut();
      filterPage.selectOffer20Percent();
  }
  @When("And clicks the clear all filter button")
    public void clicksTheClearAllFilterButton()
  {
      filterPage.clearAll();
  }
  @Then ("all filters should be cleared")
    public void allFiltersShouldBeCleared()
  {
    assertTrue(filterPage.areFiltersCleared());
  }

}