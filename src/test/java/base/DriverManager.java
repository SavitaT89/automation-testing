package base;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebElement;

import java.net.URL;

public class DriverManager {

    public static IOSDriver driver;

    public static IOSDriver getDriver() {
        return driver;
    }

    public static void initializeDriver() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "iOS");
        caps.setCapability("deviceName", "iPhone 11");
        caps.setCapability("platformVersion", "26.3.1");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("udid", "00008030-00161DC20290402E");
//        caps.setCapability("app", "/Users/savitakakade/Downloads/WizzAir.ipa");
        caps.setCapability("bundleId", "com.wizzair.WizzAirApp");

        driver = new IOSDriver(
                new URL("http://127.0.0.1:4723"),
                caps
        );
    }
}