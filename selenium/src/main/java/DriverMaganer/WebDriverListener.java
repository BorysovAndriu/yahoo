package DriverMaganer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.Arrays;

public class WebDriverListener implements WebDriverEventListener {

    private static final Logger LOG = LogManager.getLogger(WebDriverListener.class);

    @Override
    public void beforeAlertAccept(WebDriver driver) {
        LOG.info("beforeAlertAccept ");
    }

    @Override
    public void afterAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
                                     LOG.info("beforeNavigateTo [{}]", url );
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
       LOG.info("afterNavigateTo [{}]", url );
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        LOG.info("beforeFindBy [{}]", by );
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        LOG.info("afterFindBy [{}]", by );
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
          LOG.info("beforeClickOn [{}]", element.getTagName() );
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
               LOG.info("afterClickOn [{}]", element.getTagName() );
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        LOG.info("beforeChangeValueOf [{}]", Arrays.toString(keysToSend) );
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
          LOG.info("afterChangeValueOf [{}]", Arrays.toString(keysToSend) );
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {

    }
}
