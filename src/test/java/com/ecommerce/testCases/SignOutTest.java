package com.ecommerce.testCases;

import com.ecommerce.base.Base;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.utils.Utilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignOutTest extends Base {

    LoginPage loginPage;
    HomePage homePage;
    public SignOutTest(){
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        initialize();
        Utilities util = new Utilities();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test
    public void verifySignOut(){
        Utilities.signOutBtn.click();
        Assert.assertTrue(loginPage.loginBtn.isDisplayed());
    }

    @AfterMethod
    public void teardown(){
        close();
    }
}
