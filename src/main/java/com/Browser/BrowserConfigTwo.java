package com.Browser;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class BrowserConfigTwo {

    public static WebDriver startAPP(WebDriver driver, String browserName, String url) {
        DOMConfigurator.configure("log4j.xml");
        Logger logger = Logger.getLogger(BrowserConfig.class);

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
            driver = new ChromeDriver();
            logger.debug("Hello world");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/Drivers/geckodriver");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("opera")) {
            System.setProperty("webdriver.opera.driver", "src/main/resources/Drivers/operadriver");
            driver = new OperaDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.egde.driver", "src/main/resources/Drivers/msedgedriver");
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            System.setProperty("webdriver.safari.driver", "src/main/resources/Drivers/safaridriver");
            driver = new SafariDriver();
        } else {
            System.out.println("Your browser is not supported");
        }

        //
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        //
        return driver;
    }

    public static void closeAPP(WebDriver driver) {
        driver.quit();
    }

}