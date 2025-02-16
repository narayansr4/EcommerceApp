package com.ecommerce.testCases;

import com.ecommerce.base.Base;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.utils.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithInvalidCredTest extends Base {
    LoginPage loginPage;

    public LoginWithInvalidCredTest(){
        super();
    }

    @Test
    public void verifyIncorrectLogin(){
        loginPage = new LoginPage();
        loginPage.login(Utilities.generateAlphabetsString()+"gmail.com",Utilities.generateNumbersString());
        Assert.assertTrue(loginPage.loginBtn.isDisplayed());

    }
}
