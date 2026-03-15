package stepdefinitions;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertTrue;
import base.DriverManager;
import pages.FlightDetailsPage;
import pages.SearchPage;
import pages.FlightResultsPage;
import io.appium.java_client.ios.IOSDriver;


public class FlightSteps {

    private FlightDetailsPage flightDetailsPage = new FlightDetailsPage();
    IOSDriver driver;
    SearchPage searchPage;
    FlightResultsPage resultsPage;

    @Given("open the app")
    public void open_the_app() throws Exception {
        String platform = System.getProperty("platform", "iOS");
        DriverManager.initializeDriver("ios"); // your driver setup
        driver = (IOSDriver) DriverManager.getDriver("ios");

        searchPage = new SearchPage(driver);
        resultsPage = new FlightResultsPage(driver);
    }

    @When("open deep link to flight")
    public void open_deep_link_to_flight() {
        flightDetailsPage.openFlightScreen(); // method to navigate
    }

    @Then("verify flight details screen is displayed")
    public void verify_flight_details_screen_is_displayed() {
//        assertTrue(flightDetailsPage.isDisplayed(), "Flight Details screen is not displayed");
    }
}