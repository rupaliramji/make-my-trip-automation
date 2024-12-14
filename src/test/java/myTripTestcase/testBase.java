package myTripTestcase;

import myTripUtility.readConfigFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class testBase {
   public static WebDriver driver;
   readConfigFile read=new readConfigFile();
    //String br=read.getbrowser();

    Logger logger;
    @BeforeClass
   @Parameters("browser")
    public void setup(String browser) {
        logger = LogManager.getLogger("Etravel");


        switch (browser) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            default -> {
                System.out.println("this browser is invalid");
                return;
            }
        }
            //driver=new ChromeDriver();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().deleteAllCookies();
            driver.get(read.geturl());
            driver.manage().window().maximize();
        }
        @AfterClass
        public void teardown ()
        {
            //logger.info("close the Webpage");
            driver.quit();
        }

    }

