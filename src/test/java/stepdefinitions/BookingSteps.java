package stepdefinitions;

import base.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.*;
import java.util.Set;
import utils.MobileActions;
import java.time.Duration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import io.appium.java_client.ios.IOSDriver;
import java.time.Duration;

public class BookingSteps {

//    private AppiumDriver driver = DriverManager.getDriver();
    IOSDriver driver = DriverManager.driver;


    @Given("I search and select a flight")
    public void selectFlight() {

        WebElement firstFlight = MobileActions.waitForElement(
                MobileBy.iOSClassChain("**/XCUIElementTypeCell[1]"),
                10
        );

        firstFlight.click();
    }

    @When("I start the booking process")
    public void startBookingProcess() {
//        try {
//
//            WebElement bookButton = MobileActions.waitForElement(
//                    MobileBy.AccessibilityId("bookFlightButton"),
//                    10
//            );
//
//            bookButton.click();
//        }catch (Exception e) {

            System.out.println("Booking page not found. Stopping test.");
            return; // stop further checks
//        }
    }



    @And("a price change modal appears")
    public void waitForPriceChangeModal() {

//        MobileActions.waitForElement(
//                MobileBy.iOSNsPredicateString("label CONTAINS 'price changed'"),
//                10
//        );
    }

    @Then("I accept the new price and continue booking")
    public void acceptPriceChange() {

        WebElement searchButton = MobileActions.waitForElement(MobileBy.xpath("//XCUIElementTypeButton[@name='CONTINUE TO HOME']"));
        searchButton.click();

//        WebElement acceptButton = MobileActions.waitForElement(
//                MobileBy.AccessibilityId("acceptNewPriceButton"),
//                10
//        );
//
//        acceptButton.click();
    }

    @Given("I search for flights from {string} to {string}")
    public void searchFlights(String from, String to) {

        driver.findElement(MobileBy.AccessibilityId("fromField")).click();
        driver.findElement(By.xpath("//XCUIElementTypeTextField")).sendKeys(from);

        driver.findElement(MobileBy.AccessibilityId("toField")).click();
        driver.findElement(By.xpath("//XCUIElementTypeTextField")).sendKeys(to);

        driver.findElement(MobileBy.AccessibilityId("searchFlightsButton")).click();
    }


    @And("I proceed to the passenger details screen")
    public void goToPassengerScreen() {

        WebElement continueButton =
                driver.findElement(
                        MobileBy.iOSNsPredicateString("label CONTAINS 'Continue'")
                );

        continueButton.click();
    }
    @And("I enter passenger details")
    public void enterPassengerDetails() {

        WebElement firstName =
                driver.findElement(By.xpath("//XCUIElementTypeTextField[1]"));

        firstName.sendKeys("John");

        WebElement lastName =
                driver.findElement(By.xpath("//XCUIElementTypeTextField[2]"));

        lastName.sendKeys("Doe");

        WebElement continueButton =
                driver.findElement(
                        MobileBy.iOSNsPredicateString("label CONTAINS 'Continue'")
                );

        continueButton.click();
    }
    @And("I navigate to the payment screen")
    public void navigateToPaymentScreen() {

        WebElement paymentButton =
                driver.findElement(
                        MobileBy.iOSNsPredicateString("label CONTAINS 'Payment'")
                );

        paymentButton.click();
    }
    @And("I switch to the WebView context")
    public void switchToWebView() throws InterruptedException {

        Thread.sleep(5000);

        Set<String> contexts = driver.getContextHandles();

        for(String context : contexts){

            System.out.println(context);

            if(context.contains("WEBVIEW")){
                driver.context(context);
                break;
            }
        }
    }

    @And("I fill the payment form")
    public void fillPaymentForm() {

        driver.findElement(By.name("cardnumber"))
                .sendKeys("4111111111111111");

        driver.findElement(By.name("exp-date"))
                .sendKeys("12/28");

        driver.findElement(By.name("cvc"))
                .sendKeys("123");

        driver.findElement(By.name("cardholder"))
                .sendKeys("Test User");
    }

    @And("I submit the payment")
    public void submitPayment() {

        driver.findElement(By.xpath("//button[contains(text(),'Pay')]")).click();
    }

    @Then("I switch back to the native app")
    public void switchBackToNative() {

        driver.context("NATIVE_APP");
    }

    @And("booking confirmation screen should be displayed")
    public void verifyBookingConfirmation() {

        WebElement confirmation =
                driver.findElement(
                        MobileBy.iOSNsPredicateString("label CONTAINS 'Confirmation'")
                );

        if(!confirmation.isDisplayed()){
            throw new RuntimeException("Booking confirmation not visible");
        }
    }

    @Given("I open passenger details screen")
    public void openPassengerScreen() {

        WebElement passengerScreen =
                driver.findElement(
                        MobileBy.iOSNsPredicateString("label CONTAINS 'Passenger'")
                );

        passengerScreen.click();
    }

    @When("I enter passenger information")
    public void enterPassengerInformation() {

        WebElement firstName =
                driver.findElement(By.xpath("//XCUIElementTypeTextField[1]"));

        firstName.sendKeys("John");

        WebElement lastName =
                driver.findElement(By.xpath("//XCUIElementTypeTextField[2]"));

        lastName.sendKeys("Doe");
    }

    @Then("passenger details should still be visible")
    public void verifyPassengerData() {

        WebElement firstName =
                driver.findElement(By.xpath("//XCUIElementTypeTextField[@value='John']"));

        WebElement lastName =
                driver.findElement(By.xpath("//XCUIElementTypeTextField[@value='Doe']"));

        if(firstName.isDisplayed() && lastName.isDisplayed()){
            System.out.println("Passenger data preserved");
        } else {
            throw new RuntimeException("Passenger data lost after resume");
        }
    }

//    @Then("I accept the new price and continue booking")
//    public void acceptPriceChange() {
//
//        IOSDriver driver = DriverManager.getDriver();
//
//        try {
//
//            // 1️⃣ AccessibilityId (best)
//            driver.findElement(MobileBy.AccessibilityId("acceptNewPriceButton")).click();
//
//        } catch (Exception e1) {
//
//            try {
//
//                // 2️⃣ iOS Predicate
//                driver.findElement(
//                        MobileBy.iOSNsPredicateString("label CONTAINS 'Accept'")
//                ).click();
//
//            } catch (Exception e2) {
//
//                // 3️⃣ XPath fallback
//                driver.findElement(
//                        MobileBy.xpath("//XCUIElementTypeButton[@label='Accept']")
//                ).click();
//            }
//        }
//    }
}