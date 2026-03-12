package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;
import base.DriverManager;


public class MobileActions {

    public static WebElement waitForElement(AppiumDriver driver, By locator, int timeoutSeconds) {
        long end = System.currentTimeMillis() + timeoutSeconds * 1000;
        while (System.currentTimeMillis() < end) {
            try {
                WebElement el = driver.findElement(locator);
                if (el.isDisplayed()) return el;
            } catch (Exception e) {}
            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        }
        throw new RuntimeException("Element not found: " + locator);
    }

    public static boolean scrollUntilElementVisible(AppiumDriver driver, By locator, String direction, int maxSwipes) {
        for (int i = 0; i < maxSwipes; i++) {
            try {
                WebElement el = driver.findElement(locator);
                if (el.isDisplayed()) return true;
            } catch (Exception e) {
                swipe(driver, direction);
            }
        }
        return false;
    }

    public static void swipe(AppiumDriver driver, String direction) {
        Map<String, Object> args = new HashMap<>();
        args.put("direction", direction);
        driver.executeScript("mobile: swipe", args);
    }

    public static WebElement waitForElement(By locator, int timeoutSeconds) {
        long end = System.currentTimeMillis() + timeoutSeconds * 1000;
        while (System.currentTimeMillis() < end) {
            try {
                WebElement el = DriverManager.getDriver().findElement(locator);
                if (el.isDisplayed()) return el;
            } catch (Exception ignored) {
                // element not yet visible
            }
            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        }
        throw new RuntimeException("Element not found: " + locator);
    }
}