package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ContactUsSteps extends StepDefinitions {

    @Given("User clicks on the contact us button")
    public void userClicksOnTheContactUsButton() {
        driver.findElement(By.id("contact-link")).click();
    }

    @Given("User enters valid email address")
    public void userEntersValidEmailAddress() {
        driver.findElement(By.id("email")).sendKeys("test@email.com");
    }

    @And("User clicks on the Send button")
    public void userClicksOnTheSendButton() {
        driver.findElement(By.id("submitMessage")).click();
    }

    @Then("The message cannot be blank error message is shown")
    public void theMessageCannotBeBlankErrorMessageIsShown() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"center_column\"]/div/ol/li"));
        assertNotEquals(0, elements.size());
        assertEquals("The message cannot be blank.", elements.get(0).getText());
    }

    @Given("User enters invalid email address")
    public void userEntersInvalidEmailAddress() {
        driver.findElement(By.id("email")).sendKeys("test.email.com");
    }

    @Then("Invalid email address error message is shown")
    public void invalidEmailAddressErrorMessageIsShown() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"center_column\"]/div/ol/li"));
        assertNotEquals(0, elements.size());
        assertEquals("Invalid email address.", elements.get(0).getText());
    }

    @And("User enters message")
    public void userEntersMessage() {
        driver.findElement(By.id("message")).sendKeys("Test message");
    }

    @And("User selects a subject")
    public void userSelectsASubject() {
        Select subjectDropdown = new Select(driver.findElement(By.id("id_contact")));
        subjectDropdown.selectByIndex(1);
    }

    @Then("Your message has been successfully sent to our team message is shown")
    public void yourMessageHasBeenSuccessfullySentToOurTeamMessageIsShown() {
        assertEquals("Your message has been successfully sent to our team.", driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText());
    }
}
