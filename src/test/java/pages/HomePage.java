package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private IOSDriver driver;

    public HomePage(IOSDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @iOSXCUITFindBy(accessibility = "search_button")
    public WebElement searchButton;

    public void clickSearch(){
        searchButton.click();
    }

    public void allowPermissions() {
        
    }

    public void openFlightDeepLink(String s) {
    }
}