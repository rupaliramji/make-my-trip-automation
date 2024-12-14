package myTripPageObject;

import myTripUtility.utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.SQLOutput;
import java.util.List;

public class searchPage extends base {
    WebDriver driver;

    public searchPage(WebDriver driver){
        super(driver);}

    @FindBy(xpath="//li[@data-cy=\"roundTrip\"]")
    WebElement roundtrip;

    @FindBy(id="fromCity")
    WebElement sourcecity;
    @FindBy(xpath="//input[@placeholder=\"From\"]")
    WebElement from;
    @FindBy(xpath="//ul[@role=\"listbox\"]/li[2]//div/p[contains(text(),'Goa (North), India')]")
    WebElement fromairport;
    @FindBy(id="toCity")
    WebElement tocity;

    @FindBy(xpath="//input[@placeholder=\"To\"]")
    WebElement to;
    @FindBy(xpath="//ul[@class=\"react-autosuggest__suggestions-list\"]//li[1]")
    WebElement toairport;
    @FindBy(xpath = "//span[contains(text(),'Departure')]")
    WebElement departurbtn;
    @FindBy(xpath="//input[@data-cy=\"return\"]")
    WebElement returnbtn;

    @FindBy(xpath="//span[@class=\"lbl_input appendBottom5\"]")
     WebElement traveldrop;
    @FindBy(xpath = "//ul[@class=\"guestCounter font12 darkText \"]//li[@data-cy=\"adults-1\"]")
     WebElement adultTraveller;
    @FindBy(xpath="//button[contains(text(),'APPLY')]")
    WebElement apply;
    @FindBy(xpath = "//a[contains(text(),'Search')]")
    WebElement search;
    @FindBy(xpath="//p[@class=\"font24 blackFont whiteText appendBottom20 journey-title makeFlex spaceBetween bottom\"]")
    WebElement searchresulttext;
    String month_year="//div[@class=\"DayPicker-Caption\"]/div";


   //Action Method
    public void setdeparturedate(String date,String monthyear) throws InterruptedException {
        Thread.sleep(1000);
       List <WebElement>departuremonth_year=ut.month_yearcustomisedxpath(month_year);
        for(WebElement M:departuremonth_year) {
            String month = M.getText();
            System.out.println(month);
            if (month.equals(monthyear))
                ut.Action(ut.datecustomisedxpath(date));
            break;}
    }
    public void setreturndate(String retdate,String monthyear) throws InterruptedException {
        List<WebElement>returnmonth_year= ut.month_yearcustomisedxpath(month_year);
        for(WebElement R:returnmonth_year){
            String rmonth=R.getText();
            System.out.println(rmonth);
            Thread.sleep(1000);
            if(rmonth.equals(monthyear))
                ut.Action(ut.datecustomisedxpath(retdate));
            break;
        }
    }
    public void clickRoundTrip() {
        roundtrip.click();
    }
     public void clickFromCity(){
        sourcecity.click();
    }
    public void enterFromCity(String fromcity){
        from.sendKeys(fromcity);
        ut.expliwait(fromairport);
        fromairport.click();
    } public void clickToCity(){
        tocity.click();
    }
    public void enterToCity(String destination){
        to.sendKeys(destination);
        ut.expliwait(toairport);
        toairport.click();

    }
    public void clickToTravelDrop(){
        traveldrop.click();
    }
    public void clickToAdulttaraveler(){
        adultTraveller.click();
    }
    public void clickApply(){
        apply.click();
    }
    public void clickSearch(){
        search.click();
    }
    public String getSearchResultText(){
       return searchresulttext.getText();
    }




}
