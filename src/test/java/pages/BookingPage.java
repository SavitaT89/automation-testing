package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;

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
}