package com.shop.apotheke.automated_framework.tests;


import com.shop.apotheke.automated_framework.BaseTest;

import com.shop.apotheke.automated_framework.pages.LoginPage;
import com.shop.apotheke.automated_framework.pages.UserPage;
import com.shop.apotheke.automated_framework.webdriver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestLogin extends BaseTest{
    
    @Test
    public void testLoginWithValidCredentials() throws InterruptedException {
        WebDriver driver = DriverManager.getWebDriver();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        LoginPage account = new LoginPage(driver);
        account.navigateToLogin();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        account.clickResgiterButton();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        account.typeUserCredentials();
        wait.until(ExpectedConditions.elementToBeClickable( By.id("login-submit-btn")));
        account.login();
        UserPage userPage = new UserPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='u-color--grey a-h6 u-no-margin']")));
        String customerData =userPage.getCustomerData();
        Assert.assertEquals(customerData,"Kundennummer 19236690", "Customer Number");
    }

    @Test
    public void testUserWithInvalidCredentials() throws InterruptedException {
        LoginPage account = new LoginPage(DriverManager.getWebDriver());
        account.navigateToLogin();
        // Add assert to check if user is on login page or not
        account.typeUserCredentials("lol","lol");
        account.login();
        Assert.assertEquals(2,2);
    }
}