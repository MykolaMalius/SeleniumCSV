package com.epam.lab.reporter;

import org.apache.log4j.Logger;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.List;

public class TestNGListener implements ITestListener,IReporter {
    private static final Logger LOG = Logger.getLogger(TestNGListener.class);
    @Override
    public void onTestStart(ITestResult result) {
      LOG.info("Test start:"+result.getInstanceName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOG.info("Test success:"+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.info("Test fails");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOG.info("Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        LOG.info("Test start");
    }

    @Override
    public void onFinish(ITestContext context) {
        LOG.info("Test finish:"+context.getName());
    }

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

    }
}
