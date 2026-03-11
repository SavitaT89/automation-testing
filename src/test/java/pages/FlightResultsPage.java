package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

import utils.ScrollUtil;

public class FlightResultsPage {

    IOSDriver driver;

    public FlightResultsPage(IOSDriver driver){
        this.driver=driver;
    }

    public boolean findFlight(String flightNumber){

        for(int i=0;i<10;i++){

            if(driver.findElements(
                    AppiumBy.iOSNsPredicateString("label CONTAINS '"+flightNumber+"'")
            ).size()>0){

                return true;
            }

            ScrollUtil.scrollDown(driver);
        }

        return false;
    }
}