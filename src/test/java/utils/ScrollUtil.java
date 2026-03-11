package utils;

import io.appium.java_client.ios.IOSDriver;

import java.util.HashMap;
import java.util.Map;

public class ScrollUtil {

    public static void scrollDown(IOSDriver driver){

        Map<String,Object> params = new HashMap<>();

        params.put("direction","down");

        driver.executeScript("mobile:scroll",params);
    }
}