package com.tests;

import com.dataProvider.ExcelDataProvider;
import com.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test(dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
    public void loginTest(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.loginToAPP(username, password);

    }
    
    
}