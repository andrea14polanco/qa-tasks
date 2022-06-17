package com.shop.apotheke.automated_framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class BasePage<T extends BasePage<T>> extends LoadableComponent<BasePage<T>> {
    WebDriver driver;

    WebDriverWait wait;
    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
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
    protected void click(By elementBy) {
        driver.findElement(elementBy).click();
    }
    protected WebElement expandRootElement(WebElement element) {
        Object jsObject=  ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].shadowRoot", element);
        Map<String, Object> shadowRootMap = (Map<String, Object>) jsObject;
        String shadowRootKey = (String) shadowRootMap.keySet().toArray()[0];
        String id = (String) shadowRootMap.get(shadowRootKey);
        RemoteWebElement remoteWebElement = new RemoteWebElement();
        remoteWebElement.setParent((RemoteWebDriver) driver);
        remoteWebElement.setId(id);
        return remoteWebElement;

    }
    protected String getTextFromElement(By elementBy) {
        return driver.findElement(elementBy).getText();
    }

    protected WebElement waitElementToBeVisible(By locator){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    protected  void waitElementToBeClickable(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    protected boolean isElementPresent(By locator){
        if(waitElementToBeVisible(locator)!= null)
            return true;
        return false;
    }
}
