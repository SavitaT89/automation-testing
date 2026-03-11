package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;

public class PassengerPage {

    IOSDriver driver;

    public PassengerPage(IOSDriver driver){
        this.driver=driver;
    }

    public void enterPassenger(){

        driver.findElement(
                AppiumBy.accessibilityId("first_name")
        ).sendKeys("John");
    }

    public boolean verifyData(){

        return driver.findElement(
                AppiumBy.accessibilityId("first_name")
        ).getText().equals("John");
    }
}