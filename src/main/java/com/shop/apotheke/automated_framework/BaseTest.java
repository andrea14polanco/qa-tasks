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
    @BeforeMethod
    public void setUp(Method method){
        DriverManager.setWebDriver(DriverManager.startDriver(ConfigurationManager.getInstance().getKey("browser")));

    }
    @AfterMethod
    public void tearDown(){
        DriverManager.killDriver();
    }
    
}
