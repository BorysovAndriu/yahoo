package tests;

import DriverMaganer.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.UserCabinetPage;
import page.YahooLoginPage;

public class TestLoginYahoo extends TestBase {

    private String subject = "subject" + System.currentTimeMillis();

    @Test
    public void loginYahooSender(){

        YahooLoginPage loginSender = new YahooLoginPage(driver);
        //Open main page Yahoo
        openUrl(mainPageYahoo);

        //Login sender
        loginSender.login(emailSender, passwordSender);

        UserCabinetPage senderCabinet = new UserCabinetPage(driver);
        //Create email
        senderCabinet.createMessage(emailSender, subject, "test Sender");

        //SendEmail
        senderCabinet.sendMessage();

        //Open Sent tab
        senderCabinet.openTab(tabSent);

        //Verify sender email
        Assert.assertEquals(senderCabinet.getSenderNameWithLastSentEmail(),"Я");
        Assert.assertEquals(senderCabinet.getSubjectTextWithLastSentEmail(),subject);
        Assert.assertEquals(senderCabinet.getSnippetTextWithLastSentEmail(),"test Sender");


        //Create and Send email another user (Receiver)
        senderCabinet.createMessage(emailReceiver, subject, "test Receiver");
        senderCabinet.sendMessage();

        //Close browser
        close();

        //Open new session for Receiver
        openNewBrowser();

        //Open main page Yahoo
        YahooLoginPage loginReceiver = new YahooLoginPage(driver);
        openUrl(mainPageYahoo);

        //Login like receiver
        loginReceiver.login(emailReceiver,passwordReceiver);

        //Open Sent tab
        UserCabinetPage receiverCabinet = new UserCabinetPage(driver);
        receiverCabinet.openTab(tabInbox);

        //wait send email
        receiverCabinet.waitSendEmail(subject);

        //Verify that email is sent
        Assert.assertEquals(receiverCabinet.getSenderNameWithLastSentEmail(),"andriu borysov");
        Assert.assertEquals(receiverCabinet.getSubjectTextWithLastSentEmail(),subject);
        Assert.assertEquals(receiverCabinet.getSnippetTextWithLastSentEmail(),"test Receiver");
    }
}
