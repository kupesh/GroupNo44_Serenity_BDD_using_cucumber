package com.example.steps;

import io.cucumber.java.en.*;

public class LoginSteps {

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        System.out.println("Navigating to the login page.");
    }

    @When("the user enters valid credentials")
    public void userEntersValidCredentials() {
        System.out.println("Entering valid credentials.");
    }

    @Then("the user should see the dashboard")
    public void userSeesDashboard() {
        System.out.println("User is redirected to the dashboard.");
    }
}
