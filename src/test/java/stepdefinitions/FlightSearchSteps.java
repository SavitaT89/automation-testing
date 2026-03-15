package stepdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.MobileBy;


import base.DriverManager;
import utils.MobileActions;
import java.util.List;


public class FlightSearchSteps {

    private AppiumDriver driver = (AppiumDriver) DriverManager.getDriver("ios");

    @Given("I am on the flight search screen")
    public void openFlightSearchScreen() {

//        WebElement searchButton = MobileActions.waitForElement(MobileBy.xpath("//XCUIElementTypeButton[@name='Search flights']"), 10);
//        searchButton.click();
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

    @When("I search for flights from Brussels Charleroi to Budapest on {int}-{int}-{int}")
    public void i_search_for_flights_from_brussels_charleroi_to_budapest_on(Integer year, Integer month, Integer day) {

        String date = year + "-" + month + "-" + day;

        // Search
        WebElement searchButton = MobileActions.waitForElement(MobileBy.xpath("//XCUIElementTypeButton[@name='Search flights']"), 10);
        searchButton.click();
    }

    @Then("I should see the flight {string} in the results")
    public void iShouldSeeFlightInResults(String flightNumber) {
        boolean flightFound = false;
        WebElement resultsList = MobileActions.waitForElement(MobileBy.AccessibilityId("flightResultsList"));

        int maxScrolls = 10; // Avoid infinite loop
        for (int i = 0; i < maxScrolls; i++) {
            List<WebElement> flights = driver.findElements(MobileBy.iOSNsPredicateString(
                    "type == 'XCUIElementTypeCell' AND name CONTAINS '" + flightNumber + "'"
            ));

            if (!flights.isEmpty()) {
                flightFound = true;
                break;
            }

            // Scroll down
            MobileActions.scrollDown(resultsList);
        }

        if (!flightFound) {
            throw new RuntimeException("Flight " + flightNumber + " not found in the results.");
        }
    }

    @Given("Select Flight")
    public void SelectFlight() {

        WebElement searchButton = MobileActions.waitForElement(MobileBy.xpath("//XCUIElementTypeButton[@name='CONTINUE TO HOME']"), 10);
        searchButton.click();
    }
}
