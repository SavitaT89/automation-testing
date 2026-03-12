package pages;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

import utils.ScrollUtil;

public class FlightResultsPage extends BasePage {

    public FlightResultsPage(IOSDriver driver){
        super(driver);
    }

    public boolean findFlight(String flight){

        By locator = By.xpath("//XCUIElementTypeStaticText[@name='"+flight+"']");

        int maxScroll = 10;

        while(driver.findElements(locator).size()==0 && maxScroll>0){

            ScrollUtil.scrollDown(driver);

            maxScroll--;
        }

        return driver.findElements(locator).size()>0;
    }
}