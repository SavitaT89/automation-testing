package stepdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.DriverManager;

public class passengerSteps {

    private AppiumDriver driver = DriverManager.getDriver();


    @Given("I go to passenger screen")
    public void goToPassengerScreen() {
        driver.findElement(MobileBy.AccessibilityId("passengerScreen")).click();
    }

//    @Given("I proceed to the passenger details screen")
//    public void goToPassengerScreen() {
//
//        WebElement continueButton =
//                driver.findElement(MobileBy.iOSNsPredicateString("label CONTAINS 'Continue'"));
//
//        continueButton.click();
//    }

//    @Given("I go to passenger screen")
//    public void goToPassengerScreen() {
//    }

}
