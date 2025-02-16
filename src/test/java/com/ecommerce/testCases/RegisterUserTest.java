package com.ecommerce.testCases;

import com.ecommerce.base.Base;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.RegisterPage;
import com.ecommerce.utils.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUserTest extends Base {
    LoginPage loginPage;
    RegisterPage registerPage;
    public RegisterUserTest(){
        super();
    }

    @Test
    public void validateRegisterUser(){
        loginPage = new LoginPage();
        registerPage = loginPage.clickOnRegisterLink();

        registerPage.registerUser(Utilities.generateAlphabetsString(), Utilities.generateAlphabetsString(),  Utilities.generateAlphabetsString() + "@gmail.com","9" + Utilities.generateNumbersString(),"Doctor","male","Password513@","Password513@");
        Assert.assertTrue(registerPage.successText.isDisplayed());
    }

}
