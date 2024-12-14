package myTripUtility;

import net.bytebuddy.implementation.bytecode.Throw;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;

public class readConfigFile {
    String path=("/Users/rupaliramji/IdeaProjects/rupali/Etravel/src/test/resources/config.properties");
    FileInputStream input;
    Properties properties;
    public readConfigFile(){
        properties=new Properties();
        try
        {
           input=new FileInputStream(path);
            properties.load(input);
        }
        catch (Exception e){
            throw new RuntimeException ("file not found");
        }
    }

  public String geturl(){
       return properties.getProperty("url");

    }
    public String getfromcity(){
        return properties.getProperty("fromcity");

    }
    public String getdestination(){
        return properties.getProperty("destination");

    }
   public String getbrowser(){
        return properties.getProperty("browser");

    }
    public String getdeparturedate(){
        return properties.getProperty("departuredate");

    }
    public String getreturndate(){
        return properties.getProperty("returndate");

    }
    public String getmonthyear(){
        return properties.getProperty("month-year");

    }
    }

