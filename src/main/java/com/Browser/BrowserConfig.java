package com.Browser;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserConfig {
	@Test

    public static WebDriver startAPP(WebDriver driver, String browserName, String url) throws MalformedURLException {

        DOMConfigurator.configure("Test-Data/log4j.xml");
        Logger logger = Logger.getLogger(BrowserConfig.class);
        DesiredCapabilities cap = null;

        if (browserName.equalsIgnoreCase("chrome")) {
            cap = DesiredCapabilities.chrome();
            logger.trace("Chrome is open");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            cap = DesiredCapabilities.firefox();
            cap.setPlatform(Platform.ANY);
            logger.trace("Firefox is open");
        } else if (browserName.equalsIgnoreCase("opera")) {
            cap = DesiredCapabilities.operaBlink();
            cap.setPlatform(Platform.ANY);
            logger.trace("Opera is open");
        } else if (browserName.equalsIgnoreCase("safari")) {
            cap = DesiredCapabilities.safari();
            cap.setPlatform(Platform.ANY);
            logger.trace("Safari is open");
        } else if (browserName.equalsIgnoreCase("edge")) {
            cap = DesiredCapabilities.edge();
            cap.setPlatform(Platform.ANY);
            logger.trace("Edge is open");
        } else {
            logger.error("Browser is not supported yet!! Browser name: "+browserName);
        }

        //
        driver = new RemoteWebDriver(new URL("http://192.168.1.11:4444/wd/hub"), cap);
        //
        logger.trace("Navigating to the :"+url);
        //
        driver.manage().window().maximize();
        //
        driver.get(url);
        //
        return driver;
    }

    public static void closeAPP(WebDriver driver) {
        DOMConfigurator.configure("Test-Data/log4j.xml");
        Logger logger = Logger.getLogger(BrowserConfig.class);
        driver.quit();
        logger.trace("Browser is closed");

    }


}
