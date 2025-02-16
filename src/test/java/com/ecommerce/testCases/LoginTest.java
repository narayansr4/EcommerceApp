package com.ecommerce.testCases;

import com.ecommerce.base.Base;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.RegisterPage;
//import com.OrangeHrm.testComponents.Retry;
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


    @Test
    public void verifyLogin(){
        loginPage = new LoginPage();
        Utilities util = new Utilities();

        homepage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        Assert.assertTrue(Utilities.cartBtn.isDisplayed());
    }

}
