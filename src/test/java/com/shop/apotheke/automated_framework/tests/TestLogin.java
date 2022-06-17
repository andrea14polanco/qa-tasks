package com.shop.apotheke.automated_framework.tests;


import com.shop.apotheke.automated_framework.BaseTest;

import com.shop.apotheke.automated_framework.pages.LoginPage;
import com.shop.apotheke.automated_framework.pages.UserPage;
import com.shop.apotheke.automated_framework.webdriver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest{
    
    @Test(enabled = true)
    public void testLoginWithValidCredentials() throws InterruptedException {
        // SET UP
        WebDriver driver = DriverManager.getWebDriver();

        // Test Prep
        LoginPage loginPage = new LoginPage(driver);

        loginPage.navigateToLogin();

        loginPage.clickRegisterButton();

        loginPage.waitForLoginBtn();

        loginPage.acceptCookies();

        loginPage.typeUserCredentials();

        loginPage.login();

        UserPage userPage = new UserPage(driver);

        userPage.waitForCustomerLabel();

        String customerData = userPage.getCustomerData();

        // Assertion
        Assert.assertEquals(customerData,"Kundennummer 19236690", "Customer Number");
    }

    @Test(enabled = true)
    public void testUserWithInvalidCredentials() throws InterruptedException {
        WebDriver driver = DriverManager.getWebDriver();
        // Test Prep
        LoginPage loginPage = new LoginPage(driver);

        loginPage.navigateToLogin();

        loginPage.clickRegisterButton();

        loginPage.waitForLoginBtn();

        loginPage.acceptCookies();

        loginPage.typeUserCredentials("DummyUser@dumb.com", "DummyPass");

        loginPage.login();

        Assert.assertTrue(loginPage.isErrorBannerPresent());


    }

    @Test(enabled = true)
    public void testLoginWithEmptyFields() throws InterruptedException {
        WebDriver driver = DriverManager.getWebDriver();

        // Test Prep
        LoginPage loginPage = new LoginPage(driver);

        loginPage.navigateToLogin();

        loginPage.clickRegisterButton();

        loginPage.waitForLoginBtn();

        loginPage.acceptCookies();

        loginPage.typeUserCredentials("", "");

        loginPage.login();

        //Asserts
        Assert.assertTrue(loginPage.isErrorBannerEmailPresent());
        Assert.assertTrue(loginPage.isErrorBannerPasswordPresent());


    }

    @Test(enabled = false)
    public void testLoginWithWrongEmailFormat() throws InterruptedException {
        WebDriver driver = DriverManager.getWebDriver();
        //TODO: fix this test
        // Test Prep
        LoginPage loginPage = new LoginPage(driver);

        loginPage.navigateToLogin();

        loginPage.clickRegisterButton();

        loginPage.waitForLoginBtn();

        loginPage.acceptCookies();

        loginPage.typeUserCredentials("Test", "nothing");

        loginPage.login();

        //Asserts
        Assert.assertTrue(loginPage.isErrorBannerEmailFormatPresent());


    }
}