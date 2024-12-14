package myTripPageObject;

import myTripUtility.utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class base {
    WebDriver driver;
    utility ut=new utility();

    public base(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }



}

