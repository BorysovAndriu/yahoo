package tests;

import DriverMaganer.WebDriverListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {


    private static final Logger LOG = LogManager.getLogger(WebDriverListener.class);


    @Override
    public void onTestStart(ITestResult result) {
        LOG.info("*** onTestStart {} " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        LOG.info("*** onTestSuccess {} " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        LOG.info("*** onTestFailure {} " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOG.info("*** onTestSkipped {} " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        LOG.info("*** onTestFailedButWithinSuccessPercentage {} " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        LOG.info("*** onStart {} " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        LOG.info("*** onFinish {} " + context.getName());
    }
}
