package page;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//a[contains(@data-ylk,'mKey:signin_click')]")
    public WebElement buttonLogin;

    @FindBy(name = "username")
    public WebElement fieldEmail;

    @FindBy(id = "login-passwd")
    public WebElement fieldPassword;

    public void login(String email, String password){

        //Click to login
        buttonLogin.click();

        //Fill email
        fieldEmail.sendKeys(email, Keys.ENTER);

        //Fill password
        fieldPassword.sendKeys(password, Keys.ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
