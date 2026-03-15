package base;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class DriverManager {

    public static AndroidDriver androidDriver;
    public static IOSDriver iosDriver;
    public static IOSDriver driver;

    public static Object getDriver(String platform) {
        if (platform.equalsIgnoreCase("android")) {
            return androidDriver;
        } else if (platform.equalsIgnoreCase("ios")) {
            return iosDriver;
        }
        return null;
    }
    public static void initializeDriver(String platform) throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();
        if (platform.equalsIgnoreCase("android")) {
            // Android capabilities
            caps.setCapability("platformName", "Android");
            caps.setCapability("deviceName", "Pixel 5"); // change to your device/emulator name
            caps.setCapability("platformVersion", "13.0"); // actual Android version
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("appPackage", "com.wizzair.android");
            caps.setCapability("appActivity", "com.wizzair.android.MainActivity");
            caps.setCapability("noReset", true);

            androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        } else if (platform.equalsIgnoreCase("ios")) {
            // iOS capabilities

            caps.setCapability("platformName", "iOS");
            caps.setCapability("deviceName", "iPhone 11");
            caps.setCapability("platformVersion", "26.3.1");
            caps.setCapability("automationName", "XCUITest");
            caps.setCapability("udid", "00008030-00161DC20290402E");
//        caps.setCapability("app", "/Users/savitakakade/Downloads/WizzAir.ipa");
            caps.setCapability("bundleId", "com.wizzair.WizzAirApp");

            iosDriver = new IOSDriver(
                    new URL("http://127.0.0.1:4723"),
                    caps
            );
        }
    }

//    public static By getDriver() {
//    }

    public static Object getDriver1() {
        return iosDriver;
    }
}