package com.shop.apotheke.automated_framework.pages;

import com.shop.apotheke.automated_framework.utils.ConfigurationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;


public class LoginPage extends BasePage<LoginPage>{
    By inputEmail = By.id("loginForm-eMail");
    By inputPassword = By.id("loginForm-password");
    By btnRegister = By.id("btn-login");
    By btnLogin = By.id("login-submit-btn");
    By errorBanner = By.xpath("//*[@class='l-flex__primary u-no-margin " +
            "u-padding--ends m-Notification__message']");
    By errorBannerEmail = By.xpath("(//*[text()='Please fill out this field.'])[1]");
    By errorBannerPassword = By.xpath("(//*[text()='Please fill out this field.'])[2]");
    By errorBannerEmailFormat = By.xpath("//*[text()=\"Please include an '@' in the email address. \"]");
    By shadowRoot = By.id("usercentrics-root");
    //TODO: fix this selector
    By cookies = By.cssSelector("#focus-lock-id > div > div > div.sc-bYoBSM.hrDdPG > div > div > div.sc-dlVxhl.bEDIID > div > button.sc-gsDKAQ.dZIwB");

    public By getInputEmail() {
        return inputEmail;
    }

    public By getInputPassword() {
        return inputPassword;
    }

    public By getBtnRegister() {
        return btnRegister;
    }

    public By getBtnLogin() {
        return btnLogin;
    }

    public By getShadowRoot() {
        return shadowRoot;
    }

    public By getCookies() {
        return cookies;
    }

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
        writeText(inputEmail, user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        writeText(inputPassword, password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

    }
    public void acceptCookies(){
        WebElement root = driver.findElement(shadowRoot);
        SearchContext shadowRoot = expandRootElement(root);
        shadowRoot.findElement(cookies).click();
    }
    public void clickRegisterButton(){
        click(btnRegister);
    }
    public void login(){
        waitElementToBeClickable(btnLogin);
        click(btnLogin);
    }
    public void waitForLoginBtn(){
        waitElementToBeVisible(btnLogin);
    }
    public boolean isErrorBannerPresent() {
        return isElementPresent(errorBanner);
    }
    public boolean isErrorBannerEmailPresent() {
        return isElementPresent(errorBannerEmail);
    }
    public boolean isErrorBannerEmailFormatPresent() {
        return isElementPresent(errorBannerEmailFormat);
    }
    public boolean isErrorBannerPasswordPresent() {
        return isElementPresent(errorBannerPassword);
    }
}
