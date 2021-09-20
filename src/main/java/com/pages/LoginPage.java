package com.pages;

import com.util.Helper;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@id='txtUsername']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='txtPassword']")
    WebElement passWord;

    @FindBy(xpath = "//input[@id='btnLogin']")
    WebElement loginButton;


    public void loginToAPP(String userName, String passWord) {
        try {
            Helper.type(this.userName, userName);
            Helper.type(this.passWord, passWord);
            Helper.waitForElement(driver, loginButton, 20).click();
        } catch (ElementNotInteractableException e) {
            System.out.println("ERROR: Element is not found!!! Please check the LoginPage loginToAPP");
        }
    }
    
}