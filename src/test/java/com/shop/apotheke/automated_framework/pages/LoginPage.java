package com.shop.apotheke.automated_framework.pages;

import com.shop.apotheke.automated_framework.utils.ConfigurationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage<LoginPage>{
    By inptEmail = By.id("loginForm-eMail");
    By inptPassword = By.id("loginForm-password");
    By btnRegister = By.id("btn-login");
    By btnLogin = By.id("login-submit-btn");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLogin() {
        goTo(ConfigurationManager.getInstance().getKey("url"));
    }

    public void typeUserCredentials() {
        String user = ConfigurationManager.getInstance().getKey("user");
        String password = ConfigurationManager.getInstance().getKey("password");
        typeUserCredentials(user,password);
    }

    public void typeUserCredentials(String user , String password) {
        writeText(inptEmail, user);
        writeText(inptPassword, password);
    }


    public void clickResgiterButton(){
        click(btnRegister);
    }
    public void login(){
        click(btnLogin);
    }
}
