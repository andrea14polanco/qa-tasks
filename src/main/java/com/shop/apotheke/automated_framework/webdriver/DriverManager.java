package com.shop.apotheke.automated_framework.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
public class DriverManager {


    private static final Logger LOG = LoggerFactory.getLogger(DriverManager.class);
    
    static WebDriver driver;


    DriverManager(String browser){

    }
    public static WebDriver startDriver(String browser){
        switch(browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--window-size=1920,1080");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        
        return driver; 
    }
   
    public static WebDriver getWebDriver(){
        LOG.info("Returning default driver: chrome");
        return driver;
    }
    public static void setWebDriver(WebDriver newDriver){
        driver = newDriver; 
    }
    public static void killDriver(){
        if(driver != null){
            LOG.info("Killing webdriver proccess{}", driver);
			driver.quit();
        }
    }
}
