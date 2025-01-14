package com.ecommerce.testCases;

import com.ecommerce.base.Base;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.RegisterPage;
import com.ecommerce.testComponents.Retry;
import com.ecommerce.utils.Utilities;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends Base {
    LoginPage loginPage;
    HomePage homepage;
    RegisterPage registerPage;

    public LoginTest(){
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        initialize();
        loginPage = new LoginPage();
        Utilities util = new Utilities();
    }

    @Test(groups = {"smoke"}, retryAnalyzer = Retry.class)
    public void verifyLogin(){
        homepage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        Assert.assertTrue(Utilities.signOutBtn.isDisplayed());
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        close();
    }
}
