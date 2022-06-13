package com.shop.apotheke.automated_framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage<UserPage>{
    By lblCustomerNo = By.xpath("//font/*[contains(text(),'Customer')]");

    public UserPage(WebDriver driver) {
        super(driver);
    }

    public String getCustomerData(){
        return getTextFromElement(lblCustomerNo);
    }

}
