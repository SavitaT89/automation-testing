package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import io.appium.java_client.MobileElement;
import java.util.HashMap;
import java.util.Map;
import base.DriverManager;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.touch.WaitOptions;
import java.time.Duration;

public class MobileActions {

    private static AppiumDriver driver;

    public MobileActions(AppiumDriver driver) {
        this.driver = driver;
    }
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
                WebElement el = ((WebDriver) DriverManager.getDriver1()).findElement(locator);
                if (el.isDisplayed()) return el;
            } catch (Exception ignored) {
                // element not yet visible
            }
            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        }
        throw new RuntimeException("Element not found: " + locator);
    }


    public static WebElement waitForElement(By locator) {
        int retries = 5;
        while (retries > 0) {
            try {
                WebElement el = driver.findElement(locator);
                if (el.isDisplayed()) return el;
            } catch (Exception ignored) {}
            retries--;
            sleep(1000);
        }
        throw new RuntimeException("Element not found: " + locator);
    }

    // Scroll down inside a container
    public static void scrollDown(WebElement container) {
        int startX = container.getLocation().getX() + container.getSize().getWidth() / 2;
        int startY = container.getLocation().getY() + (int)(container.getSize().getHeight() * 0.8);
        int endY = container.getLocation().getY() + (int)(container.getSize().getHeight() * 0.2);

        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

    private static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}
