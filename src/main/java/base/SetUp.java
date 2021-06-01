package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.reportUtils.ExtentUtility;
import utilities.fileUtils.PropertiesUtility;


import java.util.Properties;

public class SetUp {

    public static Properties properties;
    public static String testDataSheetPath;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static String testName;
    public WebDriver driver;


    @BeforeSuite
    public void beforeSetUp(){
        try{
            properties = PropertiesUtility.getApplicationProperties("Properties/config.properties");
            testDataSheetPath = System.getProperty("user.dir") + "/TestData" + properties.getProperty("TestDataFileName");

            extentReports = ExtentUtility.createReport("//TestReport//" + properties.getProperty("ExtentTestName"));


        }catch (Exception e){
            throw new RuntimeException(e.getMessage(), e);

        }
    }

    @AfterSuite
    public void cleanUp(){
        try{
            extentReports.flush();
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage(), e);
        }
    }


}
