package myTripUtility;

import com.beust.ah.A;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static myTripTestcase.testBase.driver;

public class utility  {

    /* explicite wait utility code*/
    public void expliwait(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void expliwaittoclick(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    //customised xpath
    public WebElement datecustomisedxpath(String dDate){
       return   driver.findElement(By.xpath("//div[@class=\"dateInnerCell\"]//p[1][contains(text(),"+dDate+")]"));
    }
    public List month_yearcustomisedxpath(String month){
        List<WebElement>MonthYear= driver.findElements(By.xpath(month));
        return MonthYear;
    }

    //javascript for element to click

    public void javaScriptToClick(WebElement element) {
        JavascriptExecutor executor=(JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click;",element);
    }
    // mouse action for element to click
      public void Action(WebElement element){
          Actions act=new Actions(driver);
          act.click(element).perform();

      }

      //code to take Screenshot

        public void screenShot(WebDriver driver,String testName) throws IOException
        {
            File F = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path=System.getProperty("user.dir")+"//Screenshot//"+testName+".jpeg";
            FileUtils.copyFile(F,new File(path));

    }

        }

