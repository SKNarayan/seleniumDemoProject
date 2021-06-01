package pages;

import base.SetUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver = null;
    public Logger logger = LogManager.getLogger(HomePage.class);


    By flight_service = By.xpath("//span[text()='Flight']");

    public HomePage(WebDriver driver){
        this.driver = driver;
        logger.info("On home page");
    }

    public void clickOnFlightService(){
        logger.debug("clicking on flight service");
        driver.findElement(flight_service).click();
    }


}
