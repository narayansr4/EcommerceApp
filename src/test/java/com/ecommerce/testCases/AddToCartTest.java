package com.ecommerce.testCases;

import com.ecommerce.base.Base;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.testComponents.Retry;
import com.ecommerce.testDatas.TestData;
import com.ecommerce.utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddToCartTest extends Base {

    LoginPage loginPage;
    HomePage homePage;
    public AddToCartTest(){
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        initialize();
        Utilities util = new Utilities();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test(groups = {"smoke"}, retryAnalyzer = Retry.class)
    public void verifyAddToCart()  {
        homePage.addToCart();
        Assert.assertEquals(Utilities.getCartCount(), TestData.productsToAdd.size());
    }

    @AfterMethod(alwaysRun = true)
    public  void teardown(){
        close();
    }
}
