package com.shop.apotheke.automated_framework.tests;

import com.shop.apotheke.automated_framework.BaseTest;

import com.shop.apotheke.automated_framework.pages.LoginPage;
import com.shop.apotheke.automated_framework.webdriver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest{
    
    @Test
    public void testLoginWithValidCredentials(){
        LoginPage account = new LoginPage(DriverManager.getWebDriver());
        account.NavigateToLogin();
        // Add assert to check if user is on login page or not
        account.typeUserCredentials();
        Assert.assertEquals(2,2);
    }

    @Test
    public void testUserwWithInvalidCredentials(){
        LoginPage account = new LoginPage(DriverManager.getWebDriver());
        account.NavigateToLogin();
        // Add assert to check if user is on login page or not
        account.typeUserCredentials("lol","lol");
        Assert.assertEquals(2,2);
    }
}