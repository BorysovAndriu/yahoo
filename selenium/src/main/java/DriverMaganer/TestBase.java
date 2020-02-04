package DriverMaganer;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    //Constants
    public String mainPageYahoo = "https://mail.yahoo.com/";

    //sender
    public String emailSender = "fireandriu@yahoo.com";
    public String passwordSender = "192837465mason";

    //receiver
    public String emailReceiver = "yuriy.rubinstest@yahoo.com";
    public String passwordReceiver = "Test123!";

    //name TAB
    public String tabSent = "Sent";
    public String tabInbox = "Inbox";


    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        openNewBrowser();
    }

    @AfterMethod
    public void quit(){
        close();
    }

    public void openNewBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void close(){
        driver.quit();
    }

    public void openUrl(String url){
        driver.navigate().to(url);
    }

}
