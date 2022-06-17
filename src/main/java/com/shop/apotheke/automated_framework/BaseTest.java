package com.shop.apotheke.automated_framework;

import com.shop.apotheke.automated_framework.utils.ConfigurationManager;
import com.shop.apotheke.automated_framework.webdriver.DriverManager;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import javax.swing.*;

public abstract class BaseTest {
    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);
    @BeforeMethod
    public void setUp(Method method){
        LOG.info("Initiating BaseTest class with set up driver");
        DriverManager.setWebDriver(DriverManager.startDriver(ConfigurationManager.getInstance().getKey("browser")));

    }
    @AfterMethod
    public void tearDown(){
        LOG.info("IKilling  driver");
        DriverManager.killDriver();
    }
    
}
