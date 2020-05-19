package hu.unideb.inf;

import io.cucumber.java.en.Given;

public class CommonSteps extends StepDefinitions {


    @Given("User is on landing page")
    public void userIsOnLandingPage() {
        driver.get("http://automationpractice.com/");
    }

}
