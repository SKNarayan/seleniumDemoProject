package utilities.webUtils;

import base.SetUp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.http.io.ssl.DefaultTlsSetupHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utilities.reportUtils.ExtentUtility;

import java.util.concurrent.TimeUnit;

public class LaunchBrowser extends SetUp{

    public Logger logger = LogManager.getLogger(LaunchBrowser.class);
    public WebDriver driver;
    public String baseUrl = "https://paytm.com/";

    @Parameters({"browser"})
    @BeforeTest
    public void launchBrowser(String browser) throws InterruptedException {

        if(browser.equalsIgnoreCase("chrome")){

            ExtentUtility.createReport("starting up with " + browser );
            logger.info(browser + " is opened ");
            System.out.println("Chrome browser is started ");
            WebDriverManager.chromedriver().browserVersion("90.0").setup();
            driver = new ChromeDriver();
            System.out.println("Chrome browser is lunched ");
            driver.get(baseUrl);
        }
        if(browser.equalsIgnoreCase("firefox")){
            ExtentUtility.createReport("starting up with " + browser );
            logger.info(browser + " is opened ");
            System.out.println("Firefox browser is started ");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println("Firefox browser is lunched ");
            driver.get(baseUrl);
        }

        driver.manage().window().maximize();
        System.out.println(browser + " is maximized. ");
        Thread.sleep(5000);
        System.out.println("Sleeped for some time ");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @AfterTest
    public void tearDown(){
        System.out.println("Driver is tear down now ");
        driver.quit();

    }


}


