package page;

import DriverMaganer.ManagerConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YahooLoginPage {

    WebDriver driver;

    public YahooLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    ManagerConfig user = new ManagerConfig();
    private Logger log = LogManager.getLogger(getClass());

    @FindBy(xpath = "//a[contains(@data-ylk,'mKey:signin_click')]")
    public WebElement buttonLogin;

    @FindBy(name = "username")
    public WebElement fieldEmail;

    @FindBy(id = "login-passwd")
    public WebElement fieldPassword;

    public void login(String email, String password){

        //Click to login
        buttonLogin.click();
        log.info("click on button " + buttonLogin.getText());

        //Fill email
        fieldEmail.sendKeys(user.getProperty(email), Keys.ENTER);
        log.info("fill email " + user.getProperty(email));

        //Fill password
        fieldPassword.sendKeys(user.getProperty(password), Keys.ENTER);
        log.info("fill password " + user.getProperty(password));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
