package DriverManager;

import PageManager.PageManager;
import com.duckduckgo.pages.SeachPage;
import com.newtours.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.net.URL;


public class DriverManager {
    protected static WebDriver driver;
    public static void driverInit(String browser){
//            if (browser.equalsIgnoreCase("firefox")) {
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//            }else if (browser.equalsIgnoreCase("edge")){
//                WebDriverManager.edgedriver().setup();
//                driver = new EdgeDriver();
//            }else {
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//            }

        String protocol = "http://";
        String host = "127.0.0.1";
        DesiredCapabilities dc;
        try {
            if(System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
                dc = DesiredCapabilities.firefox();
            }else {
                dc = DesiredCapabilities.chrome();
            }

            if(System.getProperty("HUB_HOST") != null){
                host = System.getProperty("HUB_HOST");
            }
            String completeAddress = protocol+host+":4444/wd/hub";
            driver = new RemoteWebDriver(new URL(completeAddress), dc);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @BeforeSuite
    public void BeforeSuite(){

    }

    @BeforeTest
    public void BeforeTest(){
        driverInit("chrome");
        PageManager.registrationPage = new RegistrationPage(driver);
        PageManager.registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        PageManager.findFlightsPage = new FindFlightsPage(driver);
        PageManager.flightDetailsPage = new FlightDetailsPage(driver);
        PageManager.billingAddressPage = new BillingAddressPage(driver);
        PageManager.flightConfirmationPage = new FlightConfirmationPage(driver);
        PageManager.seachPage = new SeachPage(driver);
    }

    @AfterTest
    public void AfterTest(){
        driver.quit();
        driver = null;
    }


    @AfterSuite
    public void AfterSuite(){

    }
}
