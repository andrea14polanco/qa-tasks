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
        account.login();
        Assert.assertEquals(2,2);
    }
}