package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.FlightPage;
import pages.HomePage;
import utilities.reportUtils.ExtentUtility;
import utilities.webUtils.LaunchBrowser;

public class AssignmentTest extends LaunchBrowser{
    public Logger logger = LogManager.getLogger(AssignmentTest.class);

    @Test
    public void testFlightService(){
        ExtentUtility.createReport("Testing flight service availability ");

        HomePage homePage = new HomePage(driver);
        homePage.clickOnFlightService();
        logger.info("Clicking on flight service");


        FlightPage flightPage = new FlightPage(driver);
        flightPage.selectOneWay();


    }

/*
    @Test
    public void testOneWayRadioButton(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnFlightService();

        FlightPage flightPage = new FlightPage(driver);
        flightPage.selectOneWay();

    }

    @Test
    public void testToEnterFrom(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnFlightService();

        FlightPage flightPage = new FlightPage(driver);
        flightPage.selectOneWay();
        flightPage.enter_from("Bengaluru");
    }
    @Test
    public void testToEnterTo(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnFlightService();

        FlightPage flightPage = new FlightPage(driver);
        flightPage.selectOneWay();
        flightPage.enter_from("Bengaluru");
        flightPage.enter_to("Mumbai");
    }
*/

}
