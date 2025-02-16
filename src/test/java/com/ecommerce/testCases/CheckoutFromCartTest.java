package com.ecommerce.testCases;

import com.ecommerce.base.Base;
import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.PaymentPage;
//import com.OrangeHrm.testComponents.Retry;
import com.ecommerce.utils.Utilities;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheckoutFromCartTest extends Base {

    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    public CheckoutFromCartTest(){
        super();
    }


    @Test
    public void checkoutItems(){
        Utilities util = new Utilities();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        homePage.addToCart();
        homePage.scrollToCartIcon();
        cartPage = homePage.goToCartPage();


        PaymentPage paymentPage = cartPage.clickOnCheckoutButton();
        Assert.assertTrue(paymentPage.paymentLabel.isDisplayed());
    }


}
