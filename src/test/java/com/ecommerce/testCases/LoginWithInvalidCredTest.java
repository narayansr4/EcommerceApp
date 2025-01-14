package com.ecommerce.testCases;

import com.ecommerce.base.Base;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.RegisterPage;
import com.ecommerce.testComponents.Retry;
import com.ecommerce.utils.Utilities;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginWithInvalidCredTest extends Base {
    LoginPage loginPage;
    HomePage homepage;
    RegisterPage registerPage;

    public LoginWithInvalidCredTest(){
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        initialize();
        loginPage = new LoginPage();
        Utilities util = new Utilities();
    }

    @Test
    public void verifyLoginIncorrectCred(){
        homepage = loginPage.login(Utilities.generateAlphabetsString() + "@gmail.com",Utilities.generateNumbersString());
        Assert.assertTrue(loginPage.loginBtn.isDisplayed());
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        close();
    }
}
