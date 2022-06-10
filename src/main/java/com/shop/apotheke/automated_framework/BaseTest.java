package com.shop.apotheke.automated_framework;

import com.shop.apotheke.automated_framework.utils.ConfigurationManager;
import com.shop.apotheke.automated_framework.webdriver.DriverManager;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);
    @BeforeMethod
    public void setUp(Method method){
        LOG.debug("starting this");
        DriverManager.setWebDriver(DriverManager.startDriver("chrome"));
        System.out.println(DriverManager.getWebDriver());
    }
    @AfterMethod
    public void tearDown(){
        if(null != null){
            //getDriver().close();
            //getDriver().quit();
        }
    }
    
}
