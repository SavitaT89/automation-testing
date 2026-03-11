package utils;

import io.appium.java_client.ios.IOSDriver;

public class ContextUtil {

    public static void switchToWebView(IOSDriver driver){

        for(String context:driver.getContextHandles()){

            if(context.contains("WEBVIEW")){
                driver.context(context);
                break;
            }
        }
    }

    public static void switchToNative(IOSDriver driver){

        driver.context("NATIVE_APP");
    }
}