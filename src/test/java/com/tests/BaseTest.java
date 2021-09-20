package com.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.Browser.BrowserConfigTwo;
import com.pages.LoginPage;
import com.Browser.BrowserConfig;
import com.util.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {
    
    public WebDriver driver;
    ExtentReports extent;
    ExtentTest test;
    LoginPage loginPage;

    @BeforeClass
    public void getTestData() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("TestReports/reports_"+ Helper.getDateAndTime()+".html");
        extent.attachReporter(spark);
        test = extent.createTest("Orange Test");
    }

    @Parameters({"browserName", "url"})
    @BeforeMethod
    public void browserSetUp(String browserName, String url) throws MalformedURLException {
        driver = BrowserConfigTwo.startAPP(driver, browserName, url);
    }

    @AfterMethod
    public void testResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Failed");
            Helper.takeScreenShot(driver);
        } else {
            test.pass("Passed");
        }

        extent.flush();

        BrowserConfig.closeAPP(driver);
    }
    
    
    
}