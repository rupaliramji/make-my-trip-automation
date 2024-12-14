package myTripTestcase;

import myTripPageObject.searchPage;
import myTripUtility.utility;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class TC_SearchPage extends testBase{
     public  String expectedtext="Flights from Goa (North) to Mumbai, and back";
     utility ut=new utility();
@Test
   public void searchflight() throws InterruptedException, IOException {

        searchPage sp=new searchPage(driver);
        sp.clickRoundTrip();
        logger.info("round trip option has selected");
        sp.clickFromCity();
        sp.enterFromCity(read.getfromcity());
        sp.clickToCity();
        sp.enterToCity(read.getdestination());
        logger.info("departure and arrival airport has entered");
        sp.setdeparturedate(read.getdeparturedate(),read.getmonthyear());
        sp.setreturndate(read.getreturndate(),read.getmonthyear());
        logger.info("departure and return date has entered");
        sp.clickToTravelDrop();
        sp.clickToAdulttaraveler();
        sp.clickApply();
        sp.clickSearch();
        ut.screenShot(driver,"searchFlight");
        logger.info("number of passenger entered and clicked search button");
        Thread.sleep(1000);
        System.out.println(sp.getSearchResultText());
        Assert.assertEquals(sp.getSearchResultText(),expectedtext);
        logger.info("after search related search page is opened successfully hence test is passed");
        System.out.println("test is passed");
       }


    }


