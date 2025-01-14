package com.ecommerce.testCases;

import com.ecommerce.base.Base;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.RegisterPage;
import com.ecommerce.utils.ExcelUtils;
import com.ecommerce.utils.Utilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterUserTest extends Base {
    LoginPage loginPage;
    RegisterPage registerPage;
    public RegisterUserTest(){
        super();
    }
    @BeforeMethod(alwaysRun = true)
    public void setup(){
        initialize();
        loginPage = new LoginPage();
        registerPage = loginPage.clickOnRegisterLink();
    }

    @Test
    public void validateRegisterUser(){
        registerPage.registerUser(Utilities.generateAlphabetsString(), Utilities.generateAlphabetsString(),  Utilities.generateAlphabetsString() + "@gmail.com","9" + Utilities.generateNumbersString(),"Doctor","male","Password513@","Password513@");
        Assert.assertTrue(registerPage.successText.isDisplayed());
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        close();
    }
}
