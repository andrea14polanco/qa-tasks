package com.shop.apotheke.automated_framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage<UserPage>{

    By lblCustomerNo = By.xpath("//*[@class='u-color--grey a-h6 u-no-margin']");

    public UserPage(WebDriver driver) {
        super(driver);
    }

    public By getLblCustomerNo() {
        return lblCustomerNo;
    }

    public String getCustomerData(){
        return getTextFromElement(lblCustomerNo);
    }

    public void waitForCustomerLabel(){
        waitElementToBeVisible(lblCustomerNo);
    }

}
