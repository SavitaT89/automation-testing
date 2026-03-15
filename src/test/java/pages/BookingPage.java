package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.MobileBy;


public class BookingPage {

    IOSDriver driver;

    public BookingPage(IOSDriver driver){
        this.driver=driver;
    }

    public void handlePriceChange(){

        if(driver.findElements(
                AppiumBy.accessibilityId("price_change_modal")
        ).size()>0){

            driver.findElement(
                    AppiumBy.accessibilityId("continue_button")
            ).click();
        }
    }
    public void acceptPriceChange() {

        try {
            driver.findElement(MobileBy.AccessibilityId("acceptNewPriceButton")).click();
        } catch (Exception e) {
            driver.findElement(MobileBy.iOSNsPredicateString("label CONTAINS 'Accept'")).click();
        }
    }
}