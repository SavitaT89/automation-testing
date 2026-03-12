package utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Dimension;
import java.util.Map;
import java.util.HashMap;
import org.openqa.selenium.WebElement;



public class ScrollUtil {

    public static void scrollDown(IOSDriver driver){

        Dimension size = driver.manage().window().getSize();

        int startY = (int)(size.height * 0.8);
        int endY = (int)(size.height * 0.2);
        int startX = size.width / 2;

        Map<String, Object> args = new HashMap<>();
        args.put("direction", "up");  // swipe direction

        driver.executeScript("mobile: swipe", args);


    }
}