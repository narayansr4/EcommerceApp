package com.ecommerce.testCases;

import com.ecommerce.base.Base;
import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.testDatas.TestData;
import com.ecommerce.utils.Utilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteItemsFromCartTest extends Base {
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    public DeleteItemsFromCartTest(){
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

    @Test()
    public void verifyDeleteItems() {

        if (TestData.productsToAdd.size() > 1) {
            cartPage.deleteItemsInCart();
            Assert.assertEquals(Utilities.getCartCount(), (TestData.productsToAdd.size() - TestData.productsToRemove.size()));
             }
        else {
            cartPage.deleteItemsInCart();
            Assert.assertTrue(CartPage.noItemsInCartText.isDisplayed());
             }

    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        close();
    }
}
