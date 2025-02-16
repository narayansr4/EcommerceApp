package com.ecommerce.testCases;

import com.ecommerce.base.Base;
import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
//import com.OrangeHrm.testComponents.Retry;
import com.ecommerce.testDatas.TestData;
import com.ecommerce.utils.Utilities;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddToCartTest extends Base {

    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    public AddToCartTest(){
        super();
    }


    @Test
    public void verifyAddToCart()  {
        Utilities util = new Utilities();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));

        homePage.addToCart();
        //new steps
        homePage.scrollToCartIcon();
        cartPage = homePage.goToCartPage();
        Assert.assertEquals(cartPage.getProductNames(),TestData.productsToAdd);
        //new step ends
        //Assert.assertEquals(Utilities.getCartCount(), TestData.productsToAdd.size());
    }

}
