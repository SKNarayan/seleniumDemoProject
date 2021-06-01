package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightPage {

    WebDriver driver= null;

    By oneWayRadioButton = By.xpath("//label[@for='oneWay']");
    By fromPlace= By.xpath("//label[text()='From']");
    By fromPlaceholder = By.xpath("//label[normalize-space()='From']");
    By toPlace = By.xpath("//label[text()='To']");
    By toPlaceHolder = By.xpath("//label[normalize-space()='To']");

    public FlightPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectOneWay(){
        driver.findElement(oneWayRadioButton).click();
    }

    public void enter_from(String from){
        driver.findElement(fromPlace).sendKeys(Keys.ENTER);
        driver.findElement(fromPlaceholder).sendKeys(from);

    }

    public void enter_to(String to){
        driver.findElement(toPlace).sendKeys(to);
    }



}
