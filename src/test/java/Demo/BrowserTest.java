package Demo;

/*import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;*/
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class BrowserTest {

    static Logger logger = LogManager.getLogger(BrowserTest.class);

    public static void main(String[] args) throws InterruptedException {

//        ExtentSparkReporter spark = new ExtentSparkReporter("target/spark/sparkReport.html");
//
//        ExtentReports extentReports = new ExtentReports();
//        extentReports.attachReporter(spark);

       // WebDriverManager.chromedriver().browserVersion("90.0").setup();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        logger.info("Chrome driver is set");
        logger.debug("Chrome browser is lunched");
        //extentReports.createTest("Lunching chrome browser")
       //         .pass("Successfully lunched");
        driver.get("https://paytm.com/");
        logger.debug("Open the web page in chrome");
      //  extentReports.createTest("Lunched web page", "Opened the web page in chrome")
        //        .addScreenCaptureFromPath("screenshots/screenshot.png", "PayTm home page");

       /*
        WebDriverManager.firefoxdriver().browserVersion("88.0").setup();
        WebDriver driver1 = new FirefoxDriver();
        logger.info("Mozilla driver is set");
        logger.debug("Mozilla browser is lunched");
        driver1.get("https://www.amazon.in/");
        logger.debug("Open the web page in Mozilla");

//       driver.wait(3000);
//        driver1.wait(3000);
        
        driver.close();
        driver1.close();
*/
      /*  List<WebElement> listOfServices = new ArrayList<WebElement>();
        logger.info("list is initialized");
        logger.info("Finding the xpath element for services");
        int i = 1;
        for( i=1; i<12; i++){

            listOfServices= driver.findElements(By.xpath("//*[@id='app']/div/div[2]/div/div[1]/div/div/a[" + i +"]/div/span"));
        }
        logger.info("creating array of the services");
        //int size = listOfServices.size();
       // System.out.println(size);
        for(WebElement service : listOfServices){
            logger.debug("Below is the list of services");
            System.out.println(service.getText());
        }*/


       // driver.findElement(By.xpath("//span[text()='Prepaid/Postpaid']")).click();
        //driver.findElement(By.xpath("//span[text() = 'Electricity']")).click();
       // driver.findElement(By.xpath("//span[text() = 'DTH']")).click();
        driver.findElement(By.xpath("//span[text() = 'Flight']")).click();
        driver.findElement(By.xpath("//label[@for='oneWay']")).click();
        driver.findElement(By.xpath("//label[@for='roundTrip']")).click();
        driver.findElement(By.xpath("//label[@for='oneWay']")).click();
        driver.findElement(By.xpath("//label[text()='From']")).sendKeys("BLR");
        List<WebElement> suggestedCities = driver.findElements(By.xpath("//div[@class='_2Alu']"));
        for(WebElement city : suggestedCities){
            System.out.println(city.getText());
        }


        driver.findElement(By.xpath("//label[text() = 'From']")).sendKeys("Bengaluru");
        driver.findElement(By.xpath("//label[text() = 'To']")).sendKeys("Mumbai");
        driver.findElement(By.xpath("//img[@role='presentation' and @data-reactid='194']")).click();

     /*   List<WebElement> listOfServices= driver.findElements(By.xpath("//div[@class='headerContainer']"));
        for(WebElement service : listOfServices){
            System.out.println(service.getText());
        }*/




















        driver.wait();
        driver.quit();
       // extentReports.flush();
    }


}
