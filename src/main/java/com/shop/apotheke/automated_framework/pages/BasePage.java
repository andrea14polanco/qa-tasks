package com.shop.apotheke.automated_framework.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class BasePage<T extends BasePage<T>> extends LoadableComponent<BasePage<T>> {
    WebDriver driver;

    WebDriverWait wait;
    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    @Override
    protected void load() {
        driver.navigate().refresh();
    }
    @Override
    protected void isLoaded() throws Error {
    //TODO: implement
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
    protected SearchContext expandRootElement(WebElement element) {
        SearchContext shadowEl= (SearchContext ) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].shadowRoot", element);

        return shadowEl;

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
