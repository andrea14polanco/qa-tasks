package com.shop.apotheke.automated_framework.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
                ChromeOptions chromeOptions = new ChromeOptions();
               // chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                chromeOptions.setExperimentalOption("useAutomationExtension", false);
                chromeOptions.addArguments("--disable-blink-features=AutomationControlled");

                chromeOptions.addArguments("--window-size=1200,800");
                chromeOptions.addArguments("incognito");
                driver = new ChromeDriver(chromeOptions);
                break;
        }
        
        return driver; 
    }
   
    public static WebDriver getWebDriver(){
        LOG.info("Returning set up driver");
        return driver;
    }
    public static void setWebDriver(WebDriver newDriver){
        LOG.info("Adding reference to driver");
        driver = newDriver; 
    }
    public static void killDriver(){
        if(driver != null){
            LOG.info("Killing webdriver proccess{}", driver);
			driver.quit();
        }
    }
}
