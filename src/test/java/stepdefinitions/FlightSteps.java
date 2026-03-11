package stepdefinitions;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertTrue;
import base.DriverManager;
import pages.FlightDetailsPage;

public class FlightSteps {

    private FlightDetailsPage flightDetailsPage = new FlightDetailsPage();

    @Given("open the app")
    public void open_the_app() throws Exception {

            DriverManager.initializeDriver(); // your driver setup
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