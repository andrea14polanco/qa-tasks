package com.shop.apotheke.automated_framework.pages;

import com.shop.apotheke.automated_framework.utils.ConfigurationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage<LoginPage>{
    By inptEmail = By.id("loginForm-eMail");
    By inptPassword = By.id("loginForm-password");
    By btnRegister = By.id("btn-login");
    By btnLogin = By.id("login-submit-btn");
    By shadowRoot = By.id("usercentrics-root");
    By cookies = By.cssSelector("#focus-lock-id > div > div > div.sc-bYoBSM.hrDdPG > div > div > div.sc-dlVxhl.bEDIID > div > button.sc-gsDKAQ.dZIwB");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLogin() {
        goTo(ConfigurationManager.getInstance().getKey("url"));
    }

    public void typeUserCredentials() throws InterruptedException {
        String user = ConfigurationManager.getInstance().getKey("user");
        String password = ConfigurationManager.getInstance().getKey("password");
        typeUserCredentials(user,password);
    }

    public void typeUserCredentials(String user , String password) throws InterruptedException {
        writeText(inptEmail, user);
        Thread.sleep(10);
        writeText(inptPassword, password);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement root1 = driver.findElement(shadowRoot);
        WebElement shadow_root1 = expandRootElement(root1);
        shadow_root1.findElement(cookies).click();
        System.out.println("Here");
    }


    public void clickResgiterButton(){
        click(btnRegister);
    }
    public void login(){
        click(btnLogin);
    }
}
