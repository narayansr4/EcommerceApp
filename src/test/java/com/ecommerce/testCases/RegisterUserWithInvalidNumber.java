package com.ecommerce.testCases;

import com.ecommerce.base.Base;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.RegisterPage;
import com.ecommerce.utils.Utilities;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegisterUserWithInvalidNumber extends Base {
    LoginPage loginPage;
    RegisterPage registerPage;
    public RegisterUserWithInvalidNumber(){
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
        registerPage.registerUser(Utilities.generateAlphabetsString(), Utilities.generateAlphabetsString(),  Utilities.generateAlphabetsString() + "@gmail.com", Utilities.generateNumbersString(),"Doctor","male","Password513@","Password513@");
        Assert.assertTrue(registerPage.phnNumberValidationMsg.isDisplayed());
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        close();
    }
}
