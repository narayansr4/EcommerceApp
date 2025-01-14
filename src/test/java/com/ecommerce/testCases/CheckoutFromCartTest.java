package com.ecommerce.testCases;

import com.ecommerce.base.Base;
import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.PaymentPage;
import com.ecommerce.testComponents.Retry;
import com.ecommerce.testDatas.TestData;
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

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        initialize();
        Utilities util = new Utilities();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        homePage.addToCart();
        cartPage = homePage.goToCartPage();
    }

//    @Test
//    public void verifyTotalCost(){
//        Assert.assertEquals(cartPage.calculateTotalPrice(),Integer.parseInt(cartPage.totalPrice.getText().substring(1)));
//    }
//
//    @Test()
//    public void verifyDeleteItems() {
//        cartPage.deleteItemsInCart();
//        Assert.assertEquals(Utilities.getCartCount(), (TestData.productsToAdd.size() - TestData.productsToRemove.size()));
//    }

    @Test(groups = {"smoke"}, retryAnalyzer = Retry.class)
    public void checkoutItems(){
        PaymentPage paymentPage = cartPage.clickOnCheckoutButton();
        Assert.assertTrue(paymentPage.paymentLabel.isDisplayed());
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        close();
    }
}
