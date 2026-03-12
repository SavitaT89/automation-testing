package pages;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class SearchPage extends BasePage {

    By fromField = By.id("from_input");
    By toField = By.id("to_input");
    By searchButton = By.id("search_button");

    public SearchPage(IOSDriver driver){
        super(driver);
    }

    public void searchFlight(String from,String to){

        type(fromField,from);
        type(toField,to);
        click(searchButton);
    }
}