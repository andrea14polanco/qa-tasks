package com.shop.apotheke.automated_framework.tests;

import com.shop.apotheke.automated_framework.BaseTest;

import com.shop.apotheke.automated_framework.pages.LoginPage;
import com.shop.apotheke.automated_framework.pages.UserPage;
import com.shop.apotheke.automated_framework.webdriver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest{
    
    @Test
    public void testLoginWithValidCredentials(){
        WebDriver driver = DriverManager.getWebDriver();
        LoginPage account = new LoginPage(driver);
        account.NavigateToLogin();
        account.typeUserCredentials();
        UserPage userPage = new UserPage(driver);
        String customerData = userPage.getCustomerData();
        Assert.assertEquals("Customer number 19236690", customerData,"Customer Number");
    }

    @Test
    public void testUserwWithInvalidCredentials(){
        LoginPage account = new LoginPage(DriverManager.getWebDriver());
        account.NavigateToLogin();
        // Add assert to check if user is on login page or not
        account.typeUserCredentials("lol","lol");
        account.login();
        Assert.assertEquals(2,2);
    }
}