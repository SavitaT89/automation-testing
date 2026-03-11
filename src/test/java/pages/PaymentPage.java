package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;

public class PaymentPage {

    IOSDriver driver;

    public PaymentPage(IOSDriver driver){
        this.driver=driver;
    }

    public void fillPayment(){

        driver.findElement(AppiumBy.id("cardNumber")).sendKeys("4111111111111111");

        driver.findElement(AppiumBy.id("expiry")).sendKeys("12/28");

        driver.findElement(AppiumBy.id("cvv")).sendKeys("123");

        driver.findElement(AppiumBy.id("payButton")).click();
    }
}