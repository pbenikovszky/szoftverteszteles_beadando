package hu.unideb.inf;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class SearchSteps extends StepDefinitions {

    @Given("The search button is clicked")
    public void theSearchButtonIsClicked() {
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
    }


    @Then("Please enter search keyword message is shown")
    public void pleaseEnterASearchKeywordMessageIsShown() {
        assertEquals("Please enter a search keyword",driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText());
    }

    @Given("User entered {string} in {string}")
    public void userEnteredValueInField(String value, String field) {
        driver.findElement(By.id(field)).sendKeys(value);
    }

    @Then("The {string} is shown")
    public void theMessageIsShown(String message) {
        assertEquals(message, driver.findElement(By.className("heading-counter")).getText());
    }
}
