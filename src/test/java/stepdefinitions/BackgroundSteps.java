package stepdefinitions;

import base.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.And;
import java.time.Duration;

public class BackgroundSteps {

    private IOSDriver driver = DriverManager.getDriver();

    @And("I send the app to background for 30 seconds")
    public void sendAppToBackground() {

        driver.runAppInBackground(Duration.ofSeconds(30));
    }
}
