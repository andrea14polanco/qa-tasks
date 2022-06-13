package com.shop.apotheke.automated_framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class BasePage<T extends BasePage<T>> extends LoadableComponent<BasePage<T>> {
    WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    @Override
    protected void load() {
        driver.navigate().refresh();
    }

    @Override
    protected void isLoaded() throws Error {

    }
    protected void writeText(By elementBy, String text) {
        driver.findElement(elementBy).sendKeys(text);
    }

    protected void goTo(String url) {
        driver.get(url);
    }

}
