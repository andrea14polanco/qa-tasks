package com.shop.apotheke.automated_framework.pages;

import com.shop.apotheke.automated_framework.utils.ConfigurationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage<LoginPage>{
    By inptEmail = By.id("login-email");
    By inptPassword = By.id("login-password");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void NavigateToLogin() {
        goTo(ConfigurationManager.getInstance().getKey("url"));
    }

    public void typeUserCredentials() {
        String user = ConfigurationManager.getInstance().getKey("user");
        String password = ConfigurationManager.getInstance().getKey("password");
        typeUserCredentials(user,password);
    }

    public void typeUserCredentials(String user , String password) {
        writeText(inptEmail, user);
        writeText(inptPassword, user);
    }
}
