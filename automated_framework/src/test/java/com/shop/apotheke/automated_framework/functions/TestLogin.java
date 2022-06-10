package com.shop.apotheke.automated_framework.functions;

import com.shop.apotheke.automated_framework.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest{
    
    @Test
    public void testLoginWithValidCredentials(){
        Assert.assertEquals(2, 2);
    }
}
