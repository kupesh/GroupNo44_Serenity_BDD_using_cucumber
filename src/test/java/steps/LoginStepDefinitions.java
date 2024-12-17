package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginStepDefinitions {

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        System.out.println("User navigates to login page.");
    }

    @When("they enter valid credentials")
    public void userEntersValidCredentials() {
        System.out.println("User enters username and password.");
    }

    @Then("they should be redirected to the dashboard")
    public void userRedirectedToDashboard() {
        System.out.println("User is redirected to the dashboard.");
    }
}