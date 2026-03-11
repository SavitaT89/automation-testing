package utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.NoSuchElementException;

public class PermissionHandler {

    public static void acceptPermissions(IOSDriver driver){

        try{

            driver.findElement(AppiumBy.accessibilityId("Allow")).click();

        }catch (NoSuchElementException ignored){}
    }
}