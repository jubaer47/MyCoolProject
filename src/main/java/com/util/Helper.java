package com.util;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Helper {

    public static Properties readProperties(String path) throws IOException {
        FileInputStream file = new FileInputStream(new File(path));
        Properties properties = new Properties();
        properties.load(file);
        return properties;
    }

    public static void type(WebElement element, String credentials) {
        element.sendKeys(credentials);

    }

    public static WebElement waitForElement(WebDriver driver, WebElement element, int second) {
        WebDriverWait wait = new WebDriverWait(driver, second);
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(element));
        return element2;

    }

    public static String getDateAndTime() {
        SimpleDateFormat date = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date currentDate = new Date();
        return date.format(currentDate);

    }

    public static void takeScreenShot(WebDriver driver) throws IOException {

        //
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        Files.copy(SrcFile, new File("ScreenShots/pic_" + getDateAndTime() + ".png"));
    }

}