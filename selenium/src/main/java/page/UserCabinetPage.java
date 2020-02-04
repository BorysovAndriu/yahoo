package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class UserCabinetPage {

    WebDriver driver;

    public UserCabinetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@data-test-id,'compose-button')]")
    public WebElement buttonCreateMessage;

    @FindBy(id = "message-to-field")
    public WebElement fieldEmailAddress;

    @FindBy(xpath = "//input[contains(@data-test-id,'compose-subject')]")
    public  WebElement fieldSubject;

    @FindBy(xpath = "//div[contains(@data-test-id,'rte')]/div")
    public WebElement fieldMessageText;

    @FindBy(xpath = "//button[contains(@data-test-id,'compose-send-button')]")
    public WebElement buttonSendMessage;

    @FindBy(xpath = "//div[contains(@data-test-id,'senders')]")
    public List<WebElement> sentEmailNameSenderList;

    @FindBy(xpath = "//span[contains(@data-test-id,'message-subject')]")
    public List<WebElement> sentEmailSubjectList;

    @FindBy(xpath = "//div[contains(@data-test-id,'snippet')]")
    public List<WebElement> sentEmailSnippetList;


    public void createMessage(String email, String subjectText, String messageText){
        //Click create email
        buttonCreateMessage.click();

        //Fill senders email address
        fieldEmailAddress.sendKeys(email, Keys.ENTER);

        //Fill field subject
        fieldSubject.sendKeys(subjectText);

        //Fill field message
        fieldMessageText.click();
        fieldMessageText.sendKeys(messageText);

    }

    public void sendMessage(){
        //Click button send email
        buttonSendMessage.click();
    }

    public void openTab(String tabName) {
        //Open All email
        driver.findElement(By.xpath("//a[contains(@data-test-folder-name,'"+tabName+"')]")).click();
        WebDriverWait driverWait = new WebDriverWait(driver,5);
        driverWait.until(ExpectedConditions.visibilityOfAllElements(sentEmailSubjectList));
        driver.navigate().refresh();
    }

    public void waitSendEmail(String expectedSubjectText){
        if(!getSubjectTextWithLastSentEmail().equals(expectedSubjectText)){
            while (!getSubjectTextWithLastSentEmail().equals(expectedSubjectText)){
                int sumTime = 0;
                int time = 10000;
                driver.navigate().refresh();
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                sumTime+=time;

                if (sumTime==60000){
                    System.out.println("TIME more than 1 min - bug!!!");
                    break;
                }
            }
        }
    }

    public String getSenderNameWithLastSentEmail(){
        //Get with last email sender name
        String senderName = sentEmailNameSenderList.get(0).getText();
        System.out.println(senderName);
        return senderName;
    }

    public String getSubjectTextWithLastSentEmail(){
        //Get with last email subject text
        String subjectText = sentEmailSubjectList.get(0).getText();
        System.out.println(subjectText);
        return subjectText;
    }

    public String getSnippetTextWithLastSentEmail(){
        //Get with last email snippet text
        String snippetText = sentEmailSnippetList.get(0).getText();
        System.out.println(snippetText);
        return snippetText;
    }
}
