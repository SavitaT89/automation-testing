package stepdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.MobileBy;


import base.DriverManager;
import utils.MobileActions;

public class FlightSearchSteps {

    private AppiumDriver driver = DriverManager.getDriver();

    @Given("I am on the flight search screen")
    public void openFlightSearchScreen() {

        WebElement searchButton = MobileActions.waitForElement(
                MobileBy.xpath("//XCUIElementTypeButton[@name='Search flights']" // Replace with the correct Accessibility ID
                        // wait up to 10 seconds
        ), 10);
        searchButton.click();
    }

    @When("I enter flight details from {string} to {string} on {string}")
    public void enterFlightDetails(String from, String to, String date) {
        MobileActions.waitForElement(driver, By.id("from_field"), 5).sendKeys(from);
        driver.findElement(By.id("to_field")).sendKeys(to);
        driver.findElement(By.id("date_field")).sendKeys(date);
    }

    @When("I tap on the search button")
    public void tapSearchButton() {
        driver.findElement(By.id("search_button")).click();
    }

    @Then("I scroll through the results to find flight {string}")
    public void scrollToFlight(String flightNumber) {
        boolean found = MobileActions.scrollUntilElementVisible(driver,
                By.xpath("//XCUIElementTypeStaticText[contains(@label,'" + flightNumber + "')]"),
                "up", 10);
        assert found : "Flight not found after scrolling!";
    }

    @Then("I verify the flight is visible")
    public void verifyFlightVisible() {
        WebElement flightLabel = driver.findElement(By.xpath("//XCUIElementTypeStaticText[contains(@label,'W6 123')]"));
        assert flightLabel.isDisplayed() : "Flight label is not displayed!";
    }
}