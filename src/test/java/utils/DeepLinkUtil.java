package utils;

import io.appium.java_client.ios.IOSDriver;

import java.util.HashMap;
import java.util.Map;

public class DeepLinkUtil {

    public static void openDeepLink(IOSDriver driver,String url){

        Map<String,Object> params = new HashMap<>();

        params.put("url",url);
        params.put("bundleId","com.apple.mobilesafari");

        driver.executeScript("mobile:deepLink",params);
    }
}